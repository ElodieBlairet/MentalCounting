package com.example.mentalcounting.services;

import com.example.mentalcounting.models.ResultatFaux;
import com.example.mentalcounting.models.ResultatVide;
import com.example.mentalcounting.models.GetteurOperation;

public class VerificationReponse {

    int correctRes;//vrai résultat

    public void Operation(GetteurOperation aff){

        int premier = aff.GetPrem();
        int second = aff.GetDeux();
        String operateur = aff.GetOpe();

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

    public void Verification(GetteurOperation operation, String resUtilString) throws ResultatFaux, ResultatVide {
        int resUtilInt = Integer.parseInt(resUtilString);//Pour le if

        Operation(operation);//Fait le vrai calcul

        if (correctRes == resUtilInt) {//l'utilisateur a bon
            return;
        }
        else//l'utilisateur a faux
        {
            if (resUtilString.equals(""))//resultat vide
                throw new ResultatVide("Entrer un resultat");// (ou mettre le bouton valider en enable)
            else//resultat incorrect
                throw new ResultatFaux("Raté : XX");// XX = res
        }
    }

    public int getCorrectRes() {
        return correctRes;
    }
}