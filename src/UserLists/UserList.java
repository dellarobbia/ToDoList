package UserLists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

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

    //Methods
    @Override
    public void addUserListItem(int position, UserListItem newUserListItem) {
        if(userListItemExists(position) == true){
            UserListItem tempUserListItem = userListItems.get(position);
            userListItems.replace(position, newUserListItem);
            addUserListItem(position++, tempUserListItem);
        } else {
            userListItems.put(position, newUserListItem);
        }
    }

    @Override
    public void removeUserListItem(int itemPosition) {
        if(userListItemExists(itemPosition) == true){
            userListItems.remove(itemPosition);
        } else {
            System.out.println("No list item at position " + itemPosition);
        }
    }

    @Override
    public void displayUserList() {
        String userListItemString = "";
        List<Integer> sortedKeyList = userListItems.keySet().stream().toList();
        Collections.sort(sortedKeyList);

        for(int position : sortedKeyList){
            userListItemString = userListItems.get(position).toString();
            System.out.println(position + ": " + userListItemString);
        }
    }

    /**
     * Check if an item exists on the UserList at the given position
     * @param position Position in the UserList to check.
     * @return True: item exits at that position. False: item does not exist at that position.
     */
    private boolean userListItemExists(int position){
        return userListItems.containsKey(position);
    }
}
