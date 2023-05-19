package org.example.exo.exoTodoV3.dao;


import org.example.cours.entity.oneToMany.User;
import org.example.exo.exoTodoV3.model.UserTodo;

import java.util.List;

public interface UserTodoDAO {

    public boolean addUser(UserTodo userTodo);



    public List<User> getAllUser();

    public User getUserById(Long id);

    public boolean deleteUser(Long userId);
}
