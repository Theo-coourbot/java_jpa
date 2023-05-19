package org.example.exo.exo1.demo;

import org.example.exo.exo1.dao.TodoDao;

import java.util.Scanner;

public class Menu {

    static Scanner sc = new Scanner(System.in);

    static TodoDao todoDao;

    public static void start(){
        String choix;

        do {
        System.out.println("=====Menus==Todo=====");
        System.out.println("1)ajout de todo");
        System.out.println("2)affichage des todos");
        System.out.println("3)terminer une tache");
        System.out.println("4)supprimer une todo");
        System.out.println("0)quiter");
          choix = sc.nextLine();


        switch (choix) {

            case "1" :
                System.out.println("merci de saisir le titre de la todo");
               String titre = sc.nextLine();

               TodoDao.ajoutDeTodo(titre);
                break;

            case "2":

                TodoDao.touteLesTodo();


                break;
            case "3" :
                System.out.println("merci de saisir l'id de la todo a modifier");
                int id = sc.nextInt();
                sc.nextLine();
                TodoDao.updateTodo();
                break;

            case "4" :
                TodoDao.touteLesTodo();
                System.out.println("merci de saisir l'id de la todo a retirer");
                int idSupp = sc.nextInt();
                sc.nextLine();
                todoDao.suprimerTodo(idSupp);
                break;

            default:
                System.out.println("Aurevoir");
                TodoDao.close();
                break;

        }

        } while (!choix.equals("0"));




    }
    public static void ajoutDeTodo(String titre){


    }





}
