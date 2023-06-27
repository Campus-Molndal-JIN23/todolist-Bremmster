package org.campusmolndal;

import org.campusmolndal.todo.Todo;
import org.campusmolndal.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Test in the production database, all test should be disabled
 */

class DatabaseHandlerTest {

    private DatabaseHandler sut;


    @BeforeEach
    void setUp() {
        sut = DatabaseHandler.getInstance();
    }

    @Test
    @Disabled
    public void readTodoByInt() {

        assertNotNull(sut.readTodoById(1));

    }

    @Test
    @Disabled
    public void readTodoByText() {
        // arrange
        Todo expected = new Todo(1, "Test text", 0, 1);


        // assert
        assertNotNull(sut.readTodoById(expected));

    }

    @Test
    @Disabled
    public void getAllTodos() {

        assertNotNull(sut.getAllTodos());

    }

    @Test
    @Disabled
    public void getUserIntIndex() {

        assertNotNull(sut.readUserByIndex(1));

    }

}