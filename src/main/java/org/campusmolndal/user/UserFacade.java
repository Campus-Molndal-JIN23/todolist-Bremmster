package org.campusmolndal.user;

import org.campusmolndal.helpers.TextManager;

import java.util.List;

public class UserFacade {

    private final UserDatabase db;

    public UserFacade() {
        this.db = new UserDatabase();
    }

    public UserFacade(UserDatabase mockDb) {
        this.db = mockDb; // constructor to enable testing

    }

    public User createUser(User user) {
        db.createUser(user);
        return searchUserByName(user);
    }

    private User searchUserByName(User user) {
        return db.readUserName(user);
    }

    public User readUser(int index) {
        return db.readUserByIndex(index);
    }
    public User changeUser(User currentUser, int index) {
        User user = db.readUserByIndex(index);

        if (user.getId() == 0) {
           return currentUser;
        } else {
            TextManager.thisDontExist();
            return user;
        }
    }

    public List<User> list() {
        List<User> users = null;
        return db.getAllUsers();

    }

    public void changeName(User user, String name) {
        user.setName(name);
        writeChanges(user);
    }

    public void changeAge(User user, int age) {
        user.setAge(age);
        writeChanges(user);
    }

    private void writeChanges(User user) {
        db.updateUser(user);
    }
}
