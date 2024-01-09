package com.itasofttest.concertsystem.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Ticket {
    //Buat Model untuk Ticket
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String buyer_name;
    private String buyer_email;
    private String buyer_phone;
    private String concert_name;
    private String category;

   @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;

    public Ticket() {

    }

    //getter dan setter untuk semua Model

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBuyer_name() {
        return buyer_name;
    }

    public void setBuyer_name(String buyer_name) {
        this.buyer_name = buyer_name;
    }

    public String getBuyer_email() {
        return buyer_email;
    }

    public void setBuyer_email(String buyer_email) {
        this.buyer_email = buyer_email;
    }

    public String getBuyer_phone() {
        return buyer_phone;
    }

    public void setBuyer_phone(String buyer_phone) {
        this.buyer_phone = buyer_phone;
    }

    public String getConcert_name() {
        return concert_name;
    }

    public void setConcert_name(String concert_name) {
        this.concert_name = concert_name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getCreated_at() {
        return created_at;
    }

    @PrePersist
    protected void onCreate() {
        this.created_at = new Date();
    }
}
