package com.example.mentalcounting.services;

import java.util.Random;

public class OperationService {
    //Attributs
    int premier = 0;
    int deuxieme = 0;
    String operateur = "";

    //Fonction pour les aléatoires
    public void Aleatoire(){
        Random random = new Random();
        premier = random.nextInt();
        deuxieme = random.nextInt();
        int operator = random.nextInt(4);
        Operation(operator);
    }

    //Fonction qui attribue le symbole de l'opérateur
    public void Operation(int operator){
        switch (operator){
            case 0:
                operateur = "+";
                break;
            case 1:
                operateur = "-";
                break;
            case 2:
                operateur = "*";
                break;
            case 3:
                operateur = "/";
                break;
            default:
                Aleatoire();
        }
        Verification(premier, deuxieme, operateur);
    }

    //Fonction qui vérifie si l'opération est possible
    public boolean Verification(int premier, int deuxieme, String ope){
        Aleatoire();
        //division par 0
        while (ope == "/") {
            if (deuxieme == 0){
                Aleatoire();
            }
        }

        //résultat négatif
        while (ope == "-"){
            int res = premier - deuxieme;
            if (res < 0){
                Aleatoire();
            }
        }

        return (true);
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