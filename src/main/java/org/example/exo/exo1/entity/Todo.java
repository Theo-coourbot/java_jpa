package org.example.exo.exo1.entity;

import javax.persistence.*;

@Entity
@Table(name = "exo_todo")
public class Todo {
    @Id
    @Column(name = "id_todo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String titre;

    @Column(name = "status")
    boolean completed;

    public Todo() {
    }



    public Todo(String titre, boolean completed) {
        this.titre = titre;
        this.completed = completed;
    }

    public String getTitre() {
        return titre;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @Override
    public String toString() {
        return "todo{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                '}';
    }
}
