package UserLists;

/**
 * Interface to handle user-made lists.
 * @author Andrew McKay
 */

public interface UserLists {
    public UserListItem addUserListItem(int itemPosition, String itemDescription);
    public void removeUserListItem(int itemPosition);
    public void displayUserList();
}
