package org.example;

public class Banque {
    private String bankName;
    private int id;
    private String pays;

    public Banque(String bankName,int id, String pays){
        this.bankName = bankName;
        this.id= id;
        this.pays= pays;
    }

    public Banque(){

    }

    public String getBankName() {
        return bankName;
    }

    public String getPays(){
        return pays;
    }
}
x