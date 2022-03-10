package com.example.mentalcounting.AffichageResultat;

public class ResultatCorrect extends Exception{
    public ResultatCorrect(String message){
        super(message);
    }
    public ResultatCorrect(String message, Throwable innerException) {
        super(message, innerException);
    }
}
