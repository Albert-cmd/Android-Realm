package com.example.m8_uf1_activitat6_bdlocal_realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class PersonaBD extends RealmObject {

    @PrimaryKey
    private String nom;
    private String residencia;
    private int edat;


    public PersonaBD() {
    }

    @Override
    public String toString() {
        return
                "nom:" + nom + '\'' +
                "residencia:" + residencia + '\'' +
                "edat:" + edat ;

    }

    public PersonaBD(String nom, String residencia, int edat) {
        this.nom = nom;
        this.residencia = residencia;
        this.edat = edat;

    }

    public String getnom() {
        return nom;
    }

    public void setnom(String nom) {
        this.nom = nom;
    }

    public String getResidencia() {
        return residencia;
    }

    public void setResidencia(String residencia) {
        this.residencia = residencia;
    }

    public int getEdat() {
        return edat;
    }
    public void setEdat(int edat) {
        this.edat = edat;
    }

}
