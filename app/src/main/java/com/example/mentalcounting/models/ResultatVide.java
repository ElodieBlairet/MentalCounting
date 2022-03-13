package com.example.mentalcounting.models;

public class ResultatVide extends Exception{
    public ResultatVide(String message){
        super(message);
    }
    public ResultatVide(String message, Throwable innerException){
        super(message, innerException);
    }
    //Faire apparaître le message d'erreur sur la page activity_game.xml
}
