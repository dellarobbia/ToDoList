import Prompts.*;
import UserLists.*;

/**
 * Main class for ToDoList program
 * @author Andrew McKay
 */

public class Main {
    static UserList userList = loadUserList();
    static int selection;

    public static void main(String[] args){
        InputPrompt mainMenu = new InputPrompt(
                "Please select an option: \n" +
                        "\t1: View To-Do List\n" +
                        "\t2: Add Item to To-Do List\n" +
                        "\t3: Remove Item from To-Do List\n" +
                        "\t4: Exit Program\n");

        boolean finished = false;

        do{
            mainMenu.displayPrompt();
            selection = Integer.valueOf(mainMenu.getUserInput());
            switch (selection){
                case 1:
                    if(userList.getUserListItems().size() > 0) {
                        userList.displayUserList();
                    } else {
                        System.out.println("No to-do items to view.");
                    }
                    break;
                case 2:
                    addUserItemMenu();
                    break;
                case 3:
                    if(userList.getUserListItems().size() > 0) {
                        removeItemMenu();
                    } else {
                        System.out.println("No to-do items to remove.");
                    }
                    break;
                case 4:
                    finished = true;
                    break;
                default:
                    System.out.println("Invalid selection.");
            }
        }while(finished == false);
    }

    /**
     * Default UserList builder
     * @return A new, empty UserList object
     */
    private static UserList loadUserList(){
        return new UserList();
    }

    private static void addUserItemMenu(){
        //Prompts
        InputPrompt addItemPositionPrompt = new InputPrompt(
                "What position will the new item be added to?");
        InputPrompt addItemDescriptionPrompt = new InputPrompt(
                "What do you need to do?");
        InputPrompt addDueDatePrompt = new InputPrompt(
                "When does it need to be done by?");

        //ToDoList constructor values
        int toDoItemPosition;
        String toDoItemDescription;
        String toDoItemDueDate;

        //Display the current to-do list so the user can see its current state
        if (userList.getUserListItems().size() > 0) {
            userList.displayUserList();
        } else {
            System.out.println("No to-do items.");
        }

        //Display prompts needed to get input for the new To-Do list item
        addItemPositionPrompt.displayPrompt();
        toDoItemPosition = Integer.valueOf(addItemPositionPrompt.getUserInput());

        addItemDescriptionPrompt.displayPrompt();
        toDoItemDescription = addItemDescriptionPrompt.getUserInput();

        addDueDatePrompt.displayPrompt();
        toDoItemDueDate = addDueDatePrompt.getUserInput();

        //Construct the new ToDOListItem and add it to the to-do list
        ToDoListItem newToDoListItem = new ToDoListItem(toDoItemDescription, toDoItemDueDate);
        userList.addUserListItem(toDoItemPosition, newToDoListItem);
    }

    private static void removeItemMenu(){
        //Prompts
        InputPrompt removeItemPositionPrompt = new InputPrompt(
                "Which item will be removed?");
        InputPrompt removeitemConfirmationPrompt = new InputPrompt(
                "Please confirm the removal:\n" +
                "\t1: Yes\n" +
                "\t2: No\n");

        int confirmSelection;
        int positionSelection;
        boolean finished = false;

        do{
            removeItemPositionPrompt.displayPrompt();
            positionSelection = Integer.valueOf(removeItemPositionPrompt.getUserInput());

            removeitemConfirmationPrompt.displayPrompt();
            confirmSelection = Integer.valueOf(removeitemConfirmationPrompt.getUserInput());
            switch(confirmSelection){
                case 1:
                    userList.removeUserListItem(positionSelection);
                    finished = true;
                    break;
                case 2:
                    System.out.println("Removal canceled. Returning to main menu...");
                    finished = true;
                    break;
                default:
                    System.out.println("Invalid selection");
            }
        } while(finished == false);
    }
}
