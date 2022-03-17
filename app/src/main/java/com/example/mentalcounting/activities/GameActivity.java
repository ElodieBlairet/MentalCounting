package com.example.mentalcounting.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mentalcounting.models.ResultatFaux;
import com.example.mentalcounting.models.ResultatVide;
import com.example.mentalcounting.services.OperationService;
import com.example.mentalcounting.services.VerificationReponse;
import com.example.mentalcounting.models.GetteurOperation;


import com.example.mentalcounting.R;

public class GameActivity extends AppCompatActivity {

    private EditText text;//Ce que l'utilisateur entre
    private TextView calculText;
    private TextView incorrectText;
    private TextView correctText;
    private GetteurOperation aff = new GetteurOperation();

    //Services externes :
    OperationService ope = new OperationService();//Service de création d'une opération
    VerificationReponse verif = new VerificationReponse();//Service de vérification d'un calcul

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);//Dire que c'est le code de activity_game.xml

        text = findViewById(R.id.answer_text);//réponse de l'utilisateur
        calculText = findViewById(R.id.calcul_text);
        incorrectText = findViewById(R.id.false_text);
        correctText = findViewById(R.id.correct_text);

        //On récupère les valeurs du calcul pour les afficher :
        ope.Aleatoire();//génére 2 int et un string
        calculFunction();

        //On vérifie la réponse de l'utilisateur :
        Button submitButton = findViewById(R.id.submit_game_button);
        submitButton.setOnClickListener(view -> submitFunction());
    }

    private void calculFunction(){
        boolean calcul = ope.CorrectOpe();//L'opération est correcte : 2 int et un String
        if (calcul) {//Récupération des valeurs de l'opération car elle est correcte
            int premier = aff.GetPrem();
            String operateur = aff.GetOpe();
            int deuxieme = aff.GetDeux();
            String text = getString(
                    // le template
                    R.string.operation_template,
                    // les variables qui sont injectées
                    premier,
                    operateur,
                    deuxieme
            );
            CharSequence text1 = this.calculText.getText();//ce qui est déjà écrit
            this.calculText.setText(text1 + text);
        }
    }

    private void submitFunction(){
        try {
            String value = text.getText().toString();
            verif.Verification(aff, value);

            // il faut récupérer le composant : c est pas l ID qui change de visibility
            TextView component = findViewById(R.id.correct_text);
            component.setVisibility(View.VISIBLE);
            findViewById(R.id.calcul_text);
        } catch (ResultatFaux resultatFaux) {
            // View.VISIBLE => la valeur qui va t afficher le truc
            incorrectText.setVisibility(View.VISIBLE);//on rend le message visible
            resultatFaux.printStackTrace();
            //Affichage du message d'erreur avec le bon résultat:
            CharSequence textF = this.incorrectText.getText();//Message : "Rate"
            int reponse = verif.getCorrectRes();//reponse correcte
            String rep = Integer.toString(reponse);
            this.incorrectText.setText(textF+rep);//Affichage
        } catch (ResultatVide resultatVide) {
            resultatVide.printStackTrace();
        }
    }

    //Ajoute game_menu à la page gameActivity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.game_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Ouvre la page home et result
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.result_menu_button:
                Intent intent = new Intent(this, ResultActivity.class);
                startActivity(intent);
                break;
            case R.id.home_menu_button:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //Getteur pour affichage
    public EditText getText() {
        return text;
    }
    public TextView getCalculText() {
        return calculText;
    }
    public TextView getIncorrectText() {
        return incorrectText;
    }
    public TextView getCorrectText() {
        return correctText;
    }
}