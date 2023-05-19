package org.example.exo.exo2TodoV2.controller;

import org.example.exo.exo2TodoV2.impl.TaskDAOImpl;
import org.example.exo.exo2TodoV2.model.Info;
import org.example.exo.exo2TodoV2.model.Task;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class ToDoListAppConsole {

    private static EntityManagerFactory entityManagerFactory;
    private static TaskDAOImpl taskDAO;

    public static void main() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpa_demo");
        taskDAO = new TaskDAOImpl(entityManagerFactory);

        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("#### To Do List ####");
            System.out.println("1. Ajouter une tâche à la liste");
            System.out.println("2. Afficher toutes les tâches de la liste");
            System.out.println("3. Marquer une tâche comme terminée");
            System.out.println("4. Supprimer une tâche de la liste");
            System.out.println("5. Quitter l'application");
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
                    System.out.println("Bye");
                    entityManagerFactory.close();
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");

            }

        }while (choice != 5);
    }

    private static void addTask(Scanner scanner){
        System.out.println("Entrer le titre de la tâche : ");

        String title = scanner.nextLine();
        System.out.println("description de la tache");
        String description = scanner.nextLine();
        int priority;
        Info info = new Info();
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

        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);
        task.setInfo(info);

        if(taskDAO.addTask(task)){
            System.out.println("Tâche ajoutée avec succès !");
        }else {
            System.out.println("Erreur");
        }
    }

    private static void displayTasks() {
        List<Task> tasks = taskDAO.getAllTasks();

        if (tasks.isEmpty()) {
            System.out.println("Aucune tâche trouvée.");
        } else {
            System.out.println("=== Liste des tâches ===");
            for (Task task : tasks) {
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
}
