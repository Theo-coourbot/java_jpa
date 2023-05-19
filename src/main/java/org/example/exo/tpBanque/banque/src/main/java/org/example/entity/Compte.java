package org.example.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity

public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_compte")
    int idCompte;

    @Column(nullable = false)
    String libelle;

    @Column(nullable = false , length = 27)
    int  IBAN;

    int solde;

    @ManyToOne
    Agence agence;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "compte_client",joinColumns = @JoinColumn(name = "id_compte"),
    inverseJoinColumns = @JoinColumn(name = "id_client"))
    List<Client> clientList = new ArrayList<>();
    public Compte() {
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    public int getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(int idCompte) {
        this.idCompte = idCompte;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getIBAN() {
        return IBAN;
    }

    public void setIBAN(int IBAN) {
        this.IBAN = IBAN;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

    @Override
    public String toString() {
        return "Compte{" +
                "idCompte=" + idCompte +
                ", libelle='" + libelle + '\'' +
                ", IBAN=" + IBAN +
                ", solde=" + solde +
                ", agence=" + agence +
                ", clientList=" + clientList +
                '}';
    }
}
