package org.campusmolndal.user;

import org.campusmolndal.helpers.TextManager;
import org.campusmolndal.user.User;

public class UserViewer {

    public static void viewUser(User user) {
        if (user.getId() != 0) {
            System.out.println(user.toString());
        } else {
            TextManager.thisDontExist();
        }
    }
}
