package org.example.cours.entity.onToOne;

import javax.persistence.*;

@Entity
@Table(name = "maison")
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "maison_id")
    private long id;
    private  Integer taille;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adresse_id", referencedColumnName = "id_adresse")
    private Adresse adresse;


    public House() {
    }

    public House(Integer taille, Adresse adresse) {
        this.taille = taille;
        this.adresse = adresse;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getTaille() {
        return taille;
    }

    public void setTaille(Integer taille) {
        this.taille = taille;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", taille=" + taille +
                ", adresse=" + adresse +
                '}';
    }
}
