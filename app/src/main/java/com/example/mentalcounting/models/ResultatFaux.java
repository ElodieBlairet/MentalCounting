package com.example.mentalcounting.models;

public class ResultatFaux extends Exception{
    public ResultatFaux(String message){
        super(message);
    }
    public ResultatFaux(String message, Throwable innerException){
        super(message, innerException);
    }
    //Faire apparaître le message d'erreur sur la page activity_game.xml
}
