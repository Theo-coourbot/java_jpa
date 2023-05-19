package org.example.entity;


import javax.persistence.*;
import java.util.List;
//
@Entity
public class Agence {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_agence")
    int idAgence;
    String adresse;

    @OneToMany(mappedBy = "agence", cascade = CascadeType.ALL)
    private List<Compte> comptes;

    public Agence() {
    }

    public int getIdAgence() {
        return idAgence;
    }

    public void setIdAgence(int idAgence) {
        this.idAgence = idAgence;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public List<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }

    @Override
    public String toString() {
        return "Agence{" +
                "idAgence=" + idAgence +
                ", adresse='" + adresse + '\'' +
                ", comptes=" + comptes +
                '}';
    }
}
