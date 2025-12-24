package com.wellsfargo.counselor.entity;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;


@Entity
public class Client {
    
    @Id
    @GeneratedValue()
    private Long clientId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private Date dateofbirth;

    @Column(nullable = false)
    private String accountnumber;

    @ManyToOne
    @JoinColumn(name = "advisor_id") 
    private Advisor advisor;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio_id", unique = true)
    private Portfolio portfolio;

    protected Client(){

    }

    public Client(String firstName, 
        String lastName, 
        String address, 
        String phone, 
        String email, 
        Date dateofbirth, 
        String accountnumber, 
        Advisor advisor) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.dateofbirth = dateofbirth;
        this.accountnumber = accountnumber;
        this.advisor = advisor;
    }

    public Portfolio createPortfolio(String name, String description) {
        Portfolio portfolio = new Portfolio(name);
        this.setPortfolio(portfolio);
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        if (this.portfolio != null && this.portfolio.getClient() == this) {
            this.portfolio.setClient(null);
        }
        this.portfolio = portfolio;
        if (portfolio != null && portfolio.getClient() != this) {
            portfolio.setClient(this);
        }
    }

    public Long getclientId(){
        return clientId;
    }
    
    public String getFirstName() {
        return firstName;
    }

     public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

        public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate_of_birth(){
        return dateofbirth;
    }   
    
    public void setDateofbirth(Date dateofbirth){
        this.dateofbirth = dateofbirth;
    }

    public String getAccountnumber(){
        return accountnumber;
    }

    public void setAccountnumber(String accountnumber){
        this.accountnumber = accountnumber;
    }
}
