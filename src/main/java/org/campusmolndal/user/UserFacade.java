package org.campusmolndal.user;

import java.util.List;

public class UserFacade {

    private final userDatabase db;

    public UserFacade() {
        this.db = new userDatabase();
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
