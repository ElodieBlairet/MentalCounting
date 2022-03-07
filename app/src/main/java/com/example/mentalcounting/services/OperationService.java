package com.example.mentalcounting.services;

import java.util.Random;

public class OperationService {
    String operateur = null;
    public void Operator(){
        int premier = 0;
        int deuxieme = 0;

        Random random = new Random();
        premier = random.nextInt();
        deuxieme = random.nextInt();
        int operator = random.nextInt(4);
    }
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
        }
    }
}


