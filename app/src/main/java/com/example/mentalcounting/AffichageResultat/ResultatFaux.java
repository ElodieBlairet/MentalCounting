package com.example.mentalcounting.AffichageResultat;

public class ResultatFaux extends Exception{
    public ResultatFaux(String message){
        super(message);
    }
    public ResultatFaux(String message, Throwable innerException){
        super(message, innerException);
    }
}
