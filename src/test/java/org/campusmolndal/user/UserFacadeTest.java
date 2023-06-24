package org.campusmolndal.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserFacadeTest {

    UserFacade sut;
    UserDatabase mockDb;

    @BeforeEach
    void setUp() {
        mockDb = mock(UserDatabase.class);
        sut = new UserFacade(mockDb);

        when(mockDb.readUserByIndex(1)).thenReturn(new User(1, "Default", 1337));
        when(mockDb.readUserByIndex(2)).thenReturn(new User(2, "Bremmster", 39));
        when(mockDb.readUserByIndex(3)).thenReturn(new User(0, "",0));

    }

    @Test
    void createUser() {
    }

    @Test
    void readUser() {
    }

    @Test
    void changeUser() {
        assertNotNull(sut.changeUser(new User(1, "Default", 1337), 2));

    }

    @Test
    void changeToUserThatDontExist() {
        int expected = new User(1, "Default", 1337).getId();
        int actual = sut.changeUser(new User(1, "Default", 1337), 3).getId();
        assertEquals(expected,actual);
    }

    @Test
    void list() {
    }

    @Test
    void changeName() {
    }

    @Test
    void changeAge() {
    }
}