package com.example.mentalcounting.models;

import com.example.mentalcounting.services.OperationService;

public class GetteurOperation {
    //Service de création d'une opération
    OperationService ope = new OperationService();
    int premier;
    int deuxieme;
    String operateur;

    public String GetOpe(){
        this.operateur = ope.getOperateur();
        return (operateur);
    }

    public int GetPrem(){
        this.premier = ope.getPremier();
        return (premier);
    }

    public int GetDeux(){
        this.deuxieme = ope.getDeuxieme();
        return (deuxieme);
    }
}
