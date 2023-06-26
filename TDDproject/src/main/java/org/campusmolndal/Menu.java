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
        boolean run = true;
        while (run) {
            printMenuOptions();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addTodo();
                    break;
                case 2:
                    findTodo();
                    break;
                case 3:
                    updateTodo();
                    break;
                case 4:
                    deleteTodo();
                    break;
                case 5:
                    showAllTodos();
                    break;
                case 6:
                    exit();
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

    private void printMenuOptions() {
        System.out.println("\n|  Main Menu  |\n");
        System.out.println("1. Add todo");
        System.out.println("2. Find todo");
        System.out.println("3. Update todo");
        System.out.println("4. Delete todo");
        System.out.println("5. Show all todos");
        System.out.println("6. Exit");
        System.out.println();
        System.out.print("Enter your choice: ");
        System.out.println();
    }

    private void exit() {
        System.out.println("Exiting...");
        System.exit(0);
    }

    private void addTodo() {
        String text = getTextInput();
        boolean done = getDoneInput();

        try {
        todoFacade.createTodo(text, done);
        System.out.println("\n~ Todo has been added ~");
        } catch (Exception e) {
            System.out.println("Something went wrong, please try again");
            addTodo();
        }
    }

    private void findTodo() {
        int id = getIdInput();

        Todo todo = todoDFacade.getTodoById(id);
        displayTodo(todo);
    }

    private void updateTodo() {
        int id = getIdInput();
        Todo todo = todoDFacade.getTodoById(id);
        System.out.println("\nDescription: " + todo.getText() + "\nIs done: " + todo.isDone());

        String text = getTextInput();
        boolean done = getDoneInput();

        todoFacade.updateTodo(id, text, done);
        System.out.println("\n~ Todo has been updated ~");
    }

    private void deleteTodo() {
        int id = getIdInput();

        Todo todo = todoDFacade.getTodoById(id);
        displayTodo(todo);
        System.out.println("Are you sure you want to delete this todo? Y/N");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("Y")) {
            todoDFacade.deleteTodoById(id);
            System.out.println("\n~ Todo has been deleted ~");
        } else {
            System.out.println("\nReturning to menu...");
        }
    }

    private void showAllTodos() {
        ArrayList allTodos = todoDFacade.getAllTodos();
        displayArrayListTodos(allTodos);
    }

    private void displayArrayListTodos(ArrayList<Todo> todos) {
        System.out.println("\nTodos:");
        for (Todo todo : todos) {
            System.out.println("ID: " + todo.getId());
            System.out.println("Text: " + todo.getText());
            System.out.println("Done: " + todo.isDone());
            System.out.println();
        }
    }

    private void displayTodo(Todo todo) {
        System.out.println("\nID: " + todo.getId());
        System.out.println("Text: " + todo.getText());
        System.out.println("Done: " + todo.isDone());
        System.out.println();
    }

    private int getIdInput() {
        System.out.print("Enter todo id: ");
        String input = scanner.nextLine();
        try {
            int id = Integer.parseInt(input);
            if (id <= 0) {
                System.out.println("Invalid input, please try again");
                return getIdInput();
            }
            return id;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input, please try again");
            return getIdInput();
        }
    }

    private boolean getDoneInput() {
        System.out.print("Enter todo status (Is the todo done? Y/N): ");
        String doneString = scanner.nextLine();
        boolean done;
        if (doneString.equalsIgnoreCase("Y")) {
            done = true;
        } else if (doneString.equalsIgnoreCase("N")) {
            done = false;
        } else {
            System.out.println("Invalid input, please try again");
            done = getDoneInput();
        }
        return done;
    }

    private String getTextInput() {
        System.out.print("Enter todo text: ");
        String text = scanner.nextLine();
        if (text.isEmpty()) {
            System.out.println("Invalid input, please try again");
            getTextInput();
        }
        return text;
    }
}
