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

    private int res;//vrai résultat
    private EditText text;//Ce que l'utilisateur entre
    private TextView calculText;//"calcul :"
    private TextView incorrectText;//"rate: XX"
    private TextView correctText;//"bravo"
    private CharSequence textCalcul;
    private CharSequence textF;

    //Services externes :
    private GetteurOperation aff = new GetteurOperation();
    private OperationService ope = new OperationService();//Service de création d'une opération
    private VerificationReponse verif = new VerificationReponse();//Service de vérification d'un calcul

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);//Dire que c'est le code de activity_game.xml

        text = findViewById(R.id.answer_text);//réponse de l'utilisateur
        calculText = findViewById(R.id.calcul_text);
        incorrectText = findViewById(R.id.false_text);
        correctText = findViewById(R.id.correct_text);

        //Récupération du texte de départ :
        textCalcul = this.calculText.getText();//ce qui est déjà écrit

        //On récupère les valeurs du calcul pour les afficher :
        calculFunction();

        //On vérifie la réponse de l'utilisateur :
        Button submitButton = findViewById(R.id.submit_game_button);
        submitButton.setOnClickListener(view -> submitFunction());
        textF = this.incorrectText.getText();//Message : "Rate"

        //Boutton pour une nouvelle operation :
        Button newButton = findViewById(R.id.new_button);
        newButton.setOnClickListener(view -> nouvelleOperation());
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

    private void calculFunction(){
        res = ope.Aleatoire();//génére 2 int et un string

        boolean calcul = ope.CorrectOpe();//L'opération est correcte : 2 int et un String
        if (calcul) {//Récupération des valeurs de l'opération car elle est correcte
            int premier = ope.getPremier();
            String operateur = ope.getOperateur();
            int deuxieme = ope.getDeuxieme();
            String affichage = getString(
                    // le template
                    R.string.operation_template,
                    // les variables qui sont injectées
                    premier,
                    operateur,
                    deuxieme
            );
            this.calculText.setText(textCalcul + affichage);
        }
    }

    private void submitFunction(){
        try {
            int valeur;
            String value = text.getText().toString();
            valeur = Integer.parseInt(value);

            verif.Verification(valeur,res);

            // il faut récupérer le composant : c est pas l ID qui change de visibility
            correctText.setVisibility(View.VISIBLE);
            findViewById(R.id.calcul_text);
        } catch (ResultatFaux resultatFaux) {
            // View.VISIBLE => la valeur qui va t afficher le truc
            incorrectText.setVisibility(View.VISIBLE);//on rend le message visible
            resultatFaux.printStackTrace();
            //Affichage du message d'erreur avec le bon résultat:

            int reponse = verif.getCorrectRes();//reponse correcte
            String rep = Integer.toString(reponse);
            this.incorrectText.setText(textF+rep);//Affichage
        } catch (ResultatVide resultatVide) {
            resultatVide.printStackTrace();
        }
    }

    private void nouvelleOperation(){
        //On efface les messages précédents :
        correctText.setVisibility(View.INVISIBLE);
        incorrectText.setVisibility(View.INVISIBLE);
        //On change d'operation :
        calculFunction();
    }
}