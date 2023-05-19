package org.example.exo.exoTodoV3.dao;




import org.example.exo.exoTodoV3.model.TaskV3;

import java.util.List;

public interface TaskDAO {

    public boolean addTask(TaskV3 task);



    public List<TaskV3> getAllTasks();

    public boolean deleteTask(Long taskId);

    public boolean markTaskAsCompleted(Long taskId);
}
