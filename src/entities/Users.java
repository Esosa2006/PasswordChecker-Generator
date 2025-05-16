package entities;

import exceptions.UserAlreadyExistsException;

import java.util.ArrayList;

public class Users {
    private ArrayList<User> list_of_users = new ArrayList<>();

    public Users(ArrayList<User> listOfUsers) {
        list_of_users = listOfUsers;
    }

    public Users() {
    }

    public void addUser(User user){
        for (User user_ : list_of_users){
            if (user_.getEmail().equalsIgnoreCase(user.getEmail())){
                throw new UserAlreadyExistsException("User already exists!");
            }
        }
        list_of_users.add(user);
    }

    public boolean isUserInList(String email) {
        for (User user : list_of_users) {
            if (email.equalsIgnoreCase(user.getEmail())) {
                return true;
            }
        }
        return false;
    }


    public User getUser(String email){
        User userFromList = new User();
        for(User user : list_of_users){
            if (user.getEmail().equalsIgnoreCase(email)){
                userFromList = user;
                return userFromList;
            }
        }
        throw new UserAlreadyExistsException("User does not exist");
    }
}
