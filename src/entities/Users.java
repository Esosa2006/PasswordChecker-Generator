package entities;

import exceptions.UserAlreadyExistsException;

import java.util.ArrayList;

public class Users {
    private ArrayList<User> list_of_users;

    public Users(ArrayList<User> listOfUsers) {
        list_of_users = listOfUsers;
    }

    public Users() {
    }

    public void addUser(User user){
        if (list_of_users.contains(user)){
            throw new UserAlreadyExistsException("User already exists");
        }
        list_of_users.add(user);
    }
    public boolean isUserInList(String email){
        User user = new User();
        user.setEmail(email);
        return list_of_users.contains(user);
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
