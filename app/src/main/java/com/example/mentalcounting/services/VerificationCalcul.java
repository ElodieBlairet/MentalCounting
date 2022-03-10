package com.example.mentalcounting.services;

import com.example.mentalcounting.AffichageResultat.ResultatCorrect;
import com.example.mentalcounting.AffichageResultat.ResultatFaux;
import com.example.mentalcounting.AffichageResultat.ResultatVide;

public class VerificationCalcul {
    //Attributs

    //le calcul avec le vrai résultat:
    int premier = 0;
    int second = 0;
    String operateur = "";
    double res;

    //résultat de l'utilisateur:
    double resultat;

    //Essai pour récupérer les vraies valeurs
    //int premier = getPremier();//fonction créé dans OperationService
    //int second = getSecond();//fonction créé dans OperationService
    //String operateur = getOperateur();//fonction créé dans OperationService
    //double resultat = getResultat();//Cette fonction n'existe pas!!!!

    public void Operation(){
        switch (operateur){
            case "+":
                res = premier + second;
                break;
            case "-":
                res = premier - second;
                break;
            case "*":
                res = premier * second;
                break;
            case "/":
                res = premier / second;
                break;
            default:
                //Erreur déjà vérifiée dans OperationService.java
        }
    }

    public void Verification() throws ResultatCorrect, ResultatFaux, ResultatVide {
        Operation();
        if (res == resultat) {//l'utilisateur a bon
            throw new ResultatCorrect("Bravo !!");
            //return (true);
        }
        else//l'utilisateur a faux
        {
            //Si resultat est vide :
            // throw new ResultatVide("Entrer un resultat");
            //Else :
            //throw new ResultatFaux("Raté : XX");
            // XX = res
            //return (false);
        }
    }
}
