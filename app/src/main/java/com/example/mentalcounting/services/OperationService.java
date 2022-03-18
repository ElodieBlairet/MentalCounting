package com.example.mentalcounting.services;

import java.util.Random;

public class OperationService {
    //Attributs
    int premier;
    int deuxieme;
    int res;
    String operateur = "";

    //Fonction pour les aléatoires
    public int Aleatoire(){
        Random random = new Random();
        premier = random.nextInt(21);//Chiffre comprit entre 0 et 20
        deuxieme = random.nextInt(21);
        int operator = random.nextInt(3);//Chiffre comprit entre 0 et 2
        //Operation(operator);
        switch (operator){
            case 0:
                operateur = "+";
                res = premier+deuxieme;
                CorrectOpe();
                break;
            case 1:
                operateur = "-";
                res = premier-deuxieme;
                CorrectOpe();
                break;
            case 2:
                operateur = "*";
                res = premier*deuxieme;
                CorrectOpe();
                break;
            default:
                Aleatoire();
        }
        return res;
    }

    public boolean CorrectOpe(){
        return true;
    }

    //Accesseurs
    public int getPremier() {
        return premier;
    }

    public int getDeuxieme() {return deuxieme;}

    public String getOperateur() {
        return operateur;
    }
}
//On a 2 int et un opérateur String