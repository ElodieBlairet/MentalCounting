package com.example.mentalcounting.services;

import android.widget.EditText;
import android.widget.TextView;

import com.example.mentalcounting.R;
import com.example.mentalcounting.activities.GameActivity;
import com.example.mentalcounting.models.ResultatFaux;
import com.example.mentalcounting.models.ResultatVide;
import com.example.mentalcounting.models.GetteurOperation;

public class VerificationReponse {
    //Modèle de récupération des valeurs de l'opération
    GetteurOperation aff = new GetteurOperation();

    //Récupérer les textes d'affichages:
    GameActivity game = new GameActivity();
    TextView textcalul = game.getCalculText();
    TextView textfaux = game.getIncorrectText();
    TextView textvrai = game.getCorrectText();

    //Attributs
    int premier = aff.GetPrem();
    int second = aff.GetDeux();
    String operateur = aff.GetOpe();
    int correctRes;//vrai résultat
    EditText utilisateurRes = game.getText();//résultat de l'utilisateur

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
        String resUtilString = utilisateurRes.toString();//Pour le else
        int resUtilInt = Integer.parseInt(resUtilString);//Pour le if

        Operation();//Fait le vrai calcul

        if (correctRes == resUtilInt) {//l'utilisateur a bon
            //R.id.correct_text.visibility = visible;
            textcalul.findViewById(R.id.calcul_text);//C'EST CORRECT ????
        }
        else//l'utilisateur a faux
        {
            if (resUtilString == "")//resultat vide
                throw new ResultatVide("Entrer un resultat");// (ou mettre le bouton valider en enable)
            else//resultat incorrect
                throw new ResultatFaux("Raté : XX");// XX = res
        }
    }
}