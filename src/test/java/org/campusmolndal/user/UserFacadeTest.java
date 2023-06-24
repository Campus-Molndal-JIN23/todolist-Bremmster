package org.campusmolndal.user;

import org.campusmolndal.DatabaseHandler;
import org.campusmolndal.todo.Todo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserFacadeTest {

    UserFacade sut;
    DatabaseHandler mockDb;

    @BeforeEach
    void setUp() {
        mockDb = mock(DatabaseHandler.class);
        sut = new UserFacade(mockDb);

        when(mockDb.readUserByIndex(1)).thenReturn(new User(1, "Default", 1337));
        when(mockDb.readUserByIndex(2)).thenReturn(new User(2, "Bremmster", 39));
        when(mockDb.readUserByIndex(3)).thenReturn(new User(0, "",0));

    }

    @Test
    void createUser() {
        sut.createUser((new User(1, "Default", 1337)));
        assertNotNull(sut.readUser(1));
    }

    @Test
    void readUser() {
        assertNotNull(sut.readUser(2));
    }

    @Test
    void changeUser() {
        assertNotNull(sut.changeUser(new User(1, "Default", 1337), 2));

    }

    @Test
    void changeToUserThatDontExist() {
        System.out.print("should not change user ");
        int expected = new User(1, "Default", 1337).getId();
        int actual = sut.changeUser(new User(1, "Default", 1337), 3).getId();
        assertEquals(expected,actual);
    }

    @Test
    void list() {
        List<User> expected = sut.list();
        assertNotNull(expected);
    }

    @Test
    void changeName() {
        sut.changeName(new User(2, "Boris", 39), "Bremmster");
        assertEquals("Bremmster", sut.readUser(2).getName());
    }

    @Test
    void changeAge() {
        sut.changeAge(new User(2, "Bremmster", 29), 39);
        assertEquals(39, sut.readUser(2).getAge());
    }
    @Test
    void testConsturctor() {
        assertNotNull(new UserFacade());
    }
}