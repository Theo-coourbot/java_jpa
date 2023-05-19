package org.example.exo.exoTodoV3.model;


import javax.persistence.*;
import java.util.List;

@Entity
public class UserTodo {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Column(name = "todo_user_id")
    int idUserTodo;
    String name;

    @OneToMany(mappedBy =  "userTodoId",cascade = CascadeType.ALL)
    List<TaskV3> userTasks;


    public UserTodo() {
    }

    public int getIdUserTodo() {
        return idUserTodo;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TaskV3> getUserTasks() {
        return userTasks;
    }

    public void setUserTasks(List<TaskV3> userTasks) {
        this.userTasks = userTasks;
    }

    @Override
    public String toString() {
        return "UserTodo{" +
                "idUserTodo=" + idUserTodo +
                ", name='" + name + '\'' +
                ", userTasks=" + userTasks +
                '}';
    }
}
