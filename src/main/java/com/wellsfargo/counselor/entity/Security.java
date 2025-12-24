package com.wellsfargo.counselor.entity;


import java.util.Date;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Security {
    
    @Id
    @GeneratedValue()
    private Long securityId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private Date purchasedate;

    @Column(nullable = false)
    private float purchaseprice;

    @Column(nullable = false)
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "portfolioId") 
    private Portfolio portfolio;

    protected Security(){

    }

    public Security(String name,
        String category,
        Date purchasedate,
        float purchaseprice,
        int quantity,
        Portfolio portfolio){
        this.name = name;
        this.category = category;
        this.purchasedate = purchasedate;
        this.purchaseprice = purchaseprice;
        this.quantity = quantity;
        this.portfolio = portfolio;
    }

    public Long getsecurityId(){
        return securityId;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }
   
    public String getcategory() {
        return category;
    }

    public void setcategory(String category) {
        this.category = category;
    }

    public Date getpurchasedate() {
        return purchasedate;
    }

    public void setpurchasedate(Date purchasedate) {
        this.purchasedate = purchasedate;
    }

    public float getpurchaseprice() {
        return purchaseprice;
    }

    public void setpurchaseprice(float purchaseprice) {
        this.purchaseprice = purchaseprice;
    }    

    public int getquantity() {
        return quantity;
    }

    public void setquantity(int quantity) {
        this.quantity = quantity;
    }

}
