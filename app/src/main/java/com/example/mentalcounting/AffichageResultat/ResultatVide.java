package com.example.mentalcounting.AffichageResultat;

public class ResultatVide extends Exception{
    public ResultatVide(String message){
        super(message);
    }
    public ResultatVide(String message, Throwable innerException){
        super(message, innerException);
    }
}
