package org.example.exo.exoTodoV3.controller;

import org.example.cours.entity.oneToMany.User;
import org.example.exo.exoTodoV3.dao.UserTodoDAO;
import org.example.exo.exoTodoV3.impl.TaskDAOImpl;
import org.example.exo.exoTodoV3.impl.UserDAOImpl;
import org.example.exo.exoTodoV3.model.InfoV3;
import org.example.exo.exoTodoV3.model.TaskV3;
import org.example.exo.exoTodoV3.model.UserTodo;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class ToDoListAppConsole {

    private static EntityManagerFactory entityManagerFactory;
    private static TaskDAOImpl taskDAO;
    private static UserTodoDAO userTodoDAO;

    public static void main() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpa_demo");
        taskDAO = new TaskDAOImpl(entityManagerFactory);
        userTodoDAO = new UserDAOImpl(entityManagerFactory);

        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("#### To Do List ####");
            System.out.println("1. Ajouter une tâche à la liste");
            System.out.println("2. Afficher toutes les tâches de la liste");
            System.out.println("3. Marquer une tâche comme terminée");
            System.out.println("4. Supprimer une tâche de la liste");
            System.out.println("5. ajout d'utilisateur");
            System.out.println("6. afficher toute les tache d'une personne");
            System.out.println("7. supprimer un utilisateur");
            System.out.println("10. quiter");
            System.out.println("Choix : ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consomme la nouvelle ligne

            switch (choice){
                case 1:
                    addTask(scanner);
                    break;
                case 2:
                    displayTasks();
                    break;
                case 3:
                    markTaskAsCompleted(scanner);
                    break;
                case 4:
                    deleteTask(scanner);
                    break;
                case 5:
                   ;
                    addUser(scanner);
                    break;

                case 6:
                    selectAllTasksByIdUser(scanner);
                    break;
                case 7:
                    deleteUser(scanner);

                    break;

                case 10:
                    System.out.println("Bye");
                    entityManagerFactory.close();
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");

            }

        }while (choice != 0);
    }

    private static void addTask(Scanner scanner){
        System.out.println("Entrer le titre de la tâche : ");

        String title = scanner.nextLine();
        System.out.println("description de la tache");
        String description = scanner.nextLine();
        int priority;
        InfoV3 info = new InfoV3();
        do {

        info.setDescription(description);
        System.out.println("niveau de priorite entre 1 (bas) et 5 (elever)");
         priority = scanner.nextInt();
        scanner.nextLine();

        info.setPriority(priority);
        } while (priority > 5 && priority < 0);
        System.out.println("date de fin de todo (format 12.06.2000) ");
        String date= scanner.nextLine();
        LocalDate dueDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        info.setDueDate(dueDate);

        System.out.println("a quelle utilisateur atribuer cette tache ?");
        Long idUserSelect = scanner.nextLong();
        User userSelect = userTodoDAO.getUserById(idUserSelect);
        scanner.nextLine();


        TaskV3 task = new TaskV3();
        task.setTitle(title);
        task.setUserTodoId(userSelect);

        task.setCompleted(false);
        task.setInfo(info);

        if(taskDAO.addTask(task)){
            System.out.println("Tâche ajoutée avec succès !");
        }else {
            System.out.println("Erreur");
        }
    }

    private static void displayTasks() {
        List<TaskV3> tasks = taskDAO.getAllTasks();

        if (tasks.isEmpty()) {
            System.out.println("Aucune tâche trouvée.");
        } else {
            System.out.println("=== Liste des tâches ===");
            for (TaskV3 task : tasks) {
                System.out.println(task.getId() + ". " + task.getTitle() + " (" + (task.isCompleted() ? "Terminée" : "En cours") + ") prioriter de niveau : " +  task.getInfo().getPriority() + " description :" + task.getInfo().getDescription());
            }
        }
    }

    private static void deleteTask(Scanner scanner){
        System.out.println("Entrez l'ID de la tâche à supprimer : ");
        Long taskId  = scanner.nextLong();
        scanner.nextLine();

        if (taskDAO.deleteTask(taskId)){
            System.out.println("Suppression OK");
        }else {
            System.out.println("Erreur");
        }
    }

    private static void markTaskAsCompleted(Scanner scanner){
        System.out.println("Entrez l'ID de la tâche à supprimer : ");
        Long taskId  = scanner.nextLong();
        scanner.nextLine();

        if (taskDAO.markTaskAsCompleted(taskId)){
            System.out.println("Modification OK");
        }else {
            System.out.println("Erreur");
        }
    }

    private static void addUser(Scanner scanner){
        System.out.println("nom d'utilisateur");
        String name = scanner.nextLine();
        UserTodo userTodo = new UserTodo();
        userTodo.setName(name);
        if (userTodoDAO.addUser(userTodo)){
            System.out.println("ajout reussi");
        } else {
            System.out.println("erreur");
        }

    }

    private static  void deleteUser(Scanner scanner){
        System.out.println("Entrez l'ID de la personne à supprimer : ");
        Long userId  = scanner.nextLong();
        scanner.nextLine();

        if (userTodoDAO.deleteUser(userId)){
            System.out.println("Suppression OK");
        }else {
            System.out.println("Erreur");
        }
    }

    private static void selectAllTasksByIdUser(Scanner scanner){
        System.out.println("Entrez l'ID de la personne  : ");
        Long userId  = scanner.nextLong();
        scanner.nextLine();

        List<TaskV3> tasks = taskDAO.getAllTasksByUser(userId);

        if (tasks.isEmpty()) {
            System.out.println("Aucune tâche trouvée.");
        } else {
            System.out.println("=== Liste des tâches ===");
            for (TaskV3 taskV3 : tasks) {
                System.out.println(taskV3.getId() + ". " + taskV3.getTitle() + " (" + (taskV3.isCompleted() ? "Terminée" : "En cours") + ") prioriter de niveau : " +  taskV3.getInfo().getPriority() + " description :" + taskV3.getInfo().getDescription());
            }
        }

    }
}
