package UserLists;

/**
 * UserListItem that represents an item that would appear on a To-Do list
 * @author Andrew McKay
 */

public class ToDoListItem extends UserListItem{
    //Properties
    private String dueDate;

    //Getters & Setters
    public String getDueDate(){
        return dueDate;
    }
    public void setDueDate(String dueDate){
        this.dueDate = dueDate;
    }

    //Constructor
    /**
     * Creates a To-Do list item
     * @param toDoDescription String to describe the item that needs to be done.
     * @param dueDate String to show when the item should be completed by.
     */
    public ToDoListItem(String toDoDescription, String dueDate) {
        super(toDoDescription);
        setDueDate(dueDate);
    }

    @Override
    public String toString() {
        return getItemDescription() + " (Due on " + dueDate + ")";
    }
}
