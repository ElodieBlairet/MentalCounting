package com.example.mentalcounting.services;

import java.util.Random;

public class OperationService {
    //Attributs
    int premier;
    int deuxieme;
    String operateur = "";

    //Fonction pour les aléatoires
    public void Aleatoire(){
        Random random = new Random();
        premier = random.nextInt(21);//Chiffre comprit entre 0 et 20
        deuxieme = random.nextInt(21);
        int operator = random.nextInt(3);//Chiffre comprit entre 0 et 2
        Operation(operator);
    }

    //Fonction qui attribue le symbole de l'opérateur
    public void Operation(int operator){
        switch (operator){
            case 0:
                operateur = "+";
                CorrectOpe();
                break;
            case 1:
                operateur = "-";
                CorrectOpe();
                break;
            case 2:
                operateur = "*";
                CorrectOpe();
                break;
            default:
                Aleatoire();
        }
    }

    public boolean CorrectOpe(){
        //if (operateur.equals(""))
            return true;
        //else
            //Aleatoire();
            //return false;
    }

    //Accesseurs
    public int getPremier() {
        return premier;
    }

    public int getDeuxieme() {
        return deuxieme;
    }

    public String getOperateur() {
        return operateur;
    }
}
//On a 2 int et un opérateur String