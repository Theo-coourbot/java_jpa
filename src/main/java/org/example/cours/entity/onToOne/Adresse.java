package org.example.cours.entity.onToOne;

import javax.persistence.*;

    @Entity
public class Adresse {


        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id_adresse")
        long id;

        @Column(nullable = false)
        private Integer numero;

        private String nomRue;

        @Column(name = "code_postal",length = 5,nullable = false)
        private String codePostal;
        private String ville;

        @Transient
        private  Integer longeur;

        @OneToOne(mappedBy = "adresse")
        private House house;

            public Adresse(Integer numero, String nomRue, String codePostal, String ville, Integer longeur) {
                    this.numero = numero;
                    this.nomRue = nomRue;
                    this.codePostal = codePostal;
                    this.ville = ville;
                    this.longeur = longeur;

            }

            public Adresse() {
            }

            public long getId() {
                    return id;
            }

            public void setId(long id) {
                    this.id = id;
            }

            public Integer getNumero() {
                    return numero;
            }

            public void setNumero(Integer numero) {
                    this.numero = numero;
            }

            public String getNomRue() {
                    return nomRue;
            }

            public void setNomRue(String nomRue) {
                    this.nomRue = nomRue;
            }

            public String getCodePostal() {
                    return codePostal;
            }

            public void setCodePostal(String codePostal) {
                    this.codePostal = codePostal;
            }

            public String getVille() {
                    return ville;
            }

            public void setVille(String ville) {
                    this.ville = ville;
            }

            public Integer getLongeur() {
                    return longeur;
            }

            public void setLongeur(Integer longeur) {
                    this.longeur = longeur;
            }

            public House getHouse() {
                    return house;
            }

            public void setHouse(House house) {
                    this.house = house;
            }

            @Override
            public String toString() {
                    return "Adresse{" +
                            "id=" + id +
                            ", numero=" + numero +
                            ", nomRue='" + nomRue + '\'' +
                            ", codePostal='" + codePostal + '\'' +
                            ", ville='" + ville + '\'' +
                            ", longeur=" + longeur +
                            ", house=" + house +
                            '}';
            }
    }
