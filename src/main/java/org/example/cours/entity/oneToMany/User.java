package org.example.cours.entity.oneToMany;

import javax.persistence.*;
import java.util.Date;
import java.util.stream.Stream;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String username;
    private String password;
    private Date createTime;
    @ManyToOne
    @JoinColumn(name="id_group")
    private GroupUser groupUser;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public GroupUser getGroup() {
        return groupUser;
    }

    public void setGroup(GroupUser group) {
        this.groupUser = groupUser;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", createTime=" + createTime +
                ", group=" + groupUser +
                '}';
    }
}
