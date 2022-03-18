package com.example.mentalcounting.services;

import com.example.mentalcounting.models.ResultatFaux;
import com.example.mentalcounting.models.ResultatVide;

public class VerificationReponse {

    private int correctRes;//vrai résultat

    public void Verification(int resUtilInt, int res) throws ResultatFaux, ResultatVide {
        correctRes=res;
        if (correctRes == resUtilInt) {//l'utilisateur a bon
            return;
        }
        else//l'utilisateur a faux
        {
            if (resUtilInt == -21)//resultat vide car impossible d'aller à + de -20 (0-20 max)
                throw new ResultatVide("Entrer un resultat");// (ou mettre le bouton valider en enable)
            else//resultat incorrect
                throw new ResultatFaux("Raté : XX");// XX = res
        }
    }

    public int getCorrectRes() {
        return correctRes;
    }
}