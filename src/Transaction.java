package org.example;

import java.time.LocalDateTime;

public class Transaction extends Banque{
    private String type;
    private LocalDateTime timestamp;
    private String reference;
    private String pays_re;
    private String bank_re;


    public Transaction(String reference, String pays_re, String bank_re) {
        this.timestamp = LocalDateTime.now();
        this.type = transactionType();
        this.reference= reference;
        this.pays_re= pays_re;
        this.bank_re= bank_re;
    }

    private String transactionType() {

        if(getPays().equals(this.pays_re)){
            if(getBankName().equals(this.bank_re)){
                return "VIRINT";
            }else return "VIREST";
        }
        else return "VIRMULTA";
    }
}
