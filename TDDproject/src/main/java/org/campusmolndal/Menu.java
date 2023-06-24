package org.campusmolndal;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private TodoDatabase todoDatabase;
    private TodoDatabaseFacade todoDFacade;
    private TodoFacade todoFacade;
    Scanner scanner = new Scanner(System.in);

    public Menu() {
        this.todoDatabase = new TodoDatabase("todo-list-db");
        this.todoDFacade = new TodoDatabaseFacade(todoDatabase);
        this.todoFacade = new TodoFacade(todoDFacade);
        printMenu();
    }
    public void printMenu() {
        System.out.println("1. Add todo");
        System.out.println("2. Find todo");
        System.out.println("3. Update todo");
        System.out.println("4. Delete todo");
        System.out.println("5. Show all todos");
        System.out.println("6. Exit");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Add todo");
                addTodo();
                break;
            case 2:
                System.out.println("Find todo");
                findTodo();
                break;
            case 3:
                System.out.println("Update todo");
                updateTodo();
                break;
            case 4:
                System.out.println("Delete todo");
                deleteTodo();
                break;
            case 5:
                System.out.println("Show all todos");
                showAllTodos();
                break;
            case 6:
                System.out.println("Exit");
                exit();
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    private void exit() {
        System.out.println("Exiting...");
        System.exit(0);
    }

    private void addTodo() {
        System.out.print("Enter todo text: ");
        String text = scanner.next();
        System.out.print("Enter todo status (Is the todo done? Y/N): ");
        String doneString = scanner.next();
        boolean done;
        if (doneString.equalsIgnoreCase("Y")) {
            done = true;
        } else {
            done = false;
        }

        todoFacade.createTodo(text, done);
    }

    private void findTodo() {
        System.out.print("Enter todo id: ");
        int id = scanner.nextInt();

        todoDFacade.getTodoById(id);
    }

    private void updateTodo() {
        System.out.print("Enter todo id: ");
        int id = scanner.nextInt();
        Todo todo = todoDFacade.getTodoById(id);
        System.out.println("Description: " + todo.getText() + "Is done: " + todo.isDone());

        System.out.print("Enter new todo description: ");
        String text = scanner.next();
        System.out.print("Enter new todo status (Is the todo done? Y/N): ");
        String doneString = scanner.next();
        boolean done;
        if (doneString.equalsIgnoreCase("Y")) {
            done = true;
        } else {
            done = false;
        }
        todoFacade.updateTodo(id, text, done);
    }

    private void deleteTodo() {
        System.out.print("Enter todo id: ");
        int id = scanner.nextInt();

        todoDFacade.deleteTodoById(id);
    }

    private void showAllTodos() {
        ArrayList allTodos = todoDFacade.getAllTodos();
        System.out.println(allTodos);
    }
}
