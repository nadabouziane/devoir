package org.example;

public class Compte {
    private Client client;
    private int acnbr;
    private String date_cr;
    private String date_up;
    private String devise;

    public Compte(Client client, int acnbr, String date_cr, String date_up, String devise) {
        this.client = client;
        this.acnbr = acnbr;
        this.date_cr = date_cr;
        this.date_up = date_up;
        this.devise = devise;
    }

    public int getNumclient() {
        return client.getNumclient();
    }

    public String getDevise() {
        return devise;
    }

    public int getAccountNumber(){
        return acnbr;
    }
}
