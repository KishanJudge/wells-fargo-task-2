package com.wellsfargo.counselor.entity;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Portfolio {
    
    @Id
    @GeneratedValue()
    private Long portfolioId;

    @Column(nullable = false)
    private String name;

    @OneToOne(mappedBy = "portfolio")  
    private Client client;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL)
    private List<Security> securities = new ArrayList<>();

    protected Portfolio(){

    }

    public Portfolio(String name, 
        Client client, 
        Security security) {
        this.name = name;
        this.client = client;
    }

    public void addSecurity(Security security) {
        securities.add(security);
    }

    public List<Security> getsSecurities() {
        return securities;
    }

    public Long getClientId() {
        return client != null ? client.getclientId() : null;
    }

    public Portfolio(String name) {
        this.name = name;
    }

    public Long getPortfolioId() { 
        return portfolioId; 
    }

    public void setPortfolioId(Long portfolioId) { 
        this.portfolioId = portfolioId; 
    }
    
    public String getName() {
         return name; 
    }

    public void setName(String name) { 
        this.name = name; 
    }

    public Client getClient() { 
        return client; 
    }
    public void setClient(Client client) { 
        this.client = client; 
    }
}
