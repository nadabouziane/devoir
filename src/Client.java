package org.example;

public class Client {
    private int numclient;
    private String nom;
    private String prenom;
    private String adresse;
    private String phone;
    private String email;

    public Client(int numclient, String nom, String prenom, String adresse, String phone, String email) {
        this.numclient = numclient;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.phone = phone;
        this.email = email;
    }

    public int getNumclient() {
        return numclient;
    }
}
