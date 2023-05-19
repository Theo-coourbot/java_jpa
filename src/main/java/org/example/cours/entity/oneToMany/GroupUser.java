package org.example.cours.entity.oneToMany;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class GroupUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String name;


    // marche aussi avec list set = evite les doublon
@OneToMany(mappedBy = "groupUser", fetch = FetchType.EAGER)
    Set<User> userSet = new HashSet<>();

    public GroupUser() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUserSet() {
        return userSet;
    }
    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userSet=" + userSet +
                '}';
    }
}
