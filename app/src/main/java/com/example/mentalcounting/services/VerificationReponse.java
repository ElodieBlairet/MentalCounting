package com.example.mentalcounting.services;

import android.widget.TextView;

import com.example.mentalcounting.R;
import com.example.mentalcounting.models.ResultatFaux;
import com.example.mentalcounting.models.ResultatVide;
import com.example.mentalcounting.models.GetteurOperation;

public class VerificationReponse {
    //Modèle de récupération des valeurs de l'opération
    GetteurOperation aff = new GetteurOperation();

    //Attributs
    int premier = aff.GetPrem();
    int second = aff.GetDeux();
    String operateur = aff.GetOpe();
    double correctRes;//vrai résultat
    double utilisateurRes;//résultat de l'utilisateur à récupérer

    //double resultat = getResultat();//Cette fonction n'existe pas!!!!

    public void Operation(){
        switch (operateur){
            case "+":
                correctRes = premier + second;
                break;
            case "-":
                correctRes = premier - second;
                break;
            case "*":
                correctRes = premier * second;
                break;
            //default:
                //Erreur déjà vérifiée dans OperationService.java
        }
    }

    public void Verification() throws ResultatFaux, ResultatVide {

        Operation();//Fait le vrai calcul
        if (correctRes == utilisateurRes) {//l'utilisateur a bon
            //R.id.correct_text.visibility = visible;
        }
        else//l'utilisateur a faux
        {
            //Si resultat est vide :
                // throw new ResultatVide("Entrer un resultat"); (ou mettre le bouton valider en enable)
            //Else :
            throw new ResultatFaux("Raté : XX");// XX = res
        }
    }
    /*String answer = text.getText().toString();
      Double rep = Double.parseDouble(answer);
    }*/
}
