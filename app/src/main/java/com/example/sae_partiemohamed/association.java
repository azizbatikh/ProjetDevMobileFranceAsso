package com.example.sae_partiemohamed;

public class association {
    private String nom;
    private int numimage ;

    public association(String nom, int numimage) {
        this.nom = nom;
        this.numimage = numimage;
    }
    public String getNom() {
        return nom;

    }
    public int getNumimage() {
        return numimage;
    }
}
