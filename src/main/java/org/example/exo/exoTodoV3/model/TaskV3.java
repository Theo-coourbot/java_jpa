package org.example.exo.exoTodoV3.model;




import org.example.cours.entity.oneToMany.User;

import javax.persistence.*;

@Entity
@Table(name= "task_v3")
public class TaskV3 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private boolean completed;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "info_id")
    InfoV3 info;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User userTodoId;

    public TaskV3() {
    }

    public User getUserTodoId() {
        return userTodoId;
    }

    public void setUserTodoId(User userTodoId) {
        this.userTodoId = userTodoId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public InfoV3 getInfo() {
        return info;
    }

    public void setInfo(InfoV3 info) {

        this.info = info;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                ", info=" + info +
                ", userTodoId=" + userTodoId +
                '}';
    }
}
