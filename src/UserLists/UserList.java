package UserLists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that creates an ordered list of user-input values.
 * @author Andrew McKay
 */
public class UserList implements UserLists{
    //Properties
    private HashMap<Integer, UserListItem> userListItems;

    //Getters & Setters
    public HashMap<Integer, UserListItem> getUserListItems() {
        return userListItems;
    }
    public void setUserListItems(HashMap<Integer, UserListItem> userListItems){
        this.userListItems = userListItems;
    }
    public void setUserListItems(){
        this.userListItems = new HashMap<Integer, UserListItem>();
    }

    //Constructors

    /**
     * Construct a UserList with a new Map
     */
    public UserList(){
        setUserListItems();
    }

    /**
     * Construct a UserList using an existing Map
     * @param userListItems Map of userListItems
     */
    public UserList(HashMap<Integer, UserListItem> userListItems){
        setUserListItems(userListItems);
    }

    @Override
    public UserListItem addUserListItem(int itemPosition, String itemDescription) {
        return null;
    }

    @Override
    public void removeUserListItem(int itemPosition) {

    }

    @Override
    public void displayUserList() {

    }
}
