package org.example.exo.exoTodoV3.model;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class InfoV3 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_info")
    private Long idInfo;

    private String description;
    private LocalDate dueDate;

    @Column(length = 5)
    private int priority;

    public InfoV3() {
    }

    public Long getIdInfo() {
        return idInfo;
    }

    public void setIdInfo(Long idInfo) {
        this.idInfo = idInfo;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Info{" +
                "idInfo=" + idInfo +
                ", description='" + description + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", priority=" + priority +
                '}';
    }
}
