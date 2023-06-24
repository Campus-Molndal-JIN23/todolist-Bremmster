package org.campusmolndal;

import org.campusmolndal.DatabaseHandler;
import org.campusmolndal.todo.Todo;
import org.campusmolndal.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class DatabaseHandlerTest {

    private DatabaseHandler sut;


    @BeforeEach
    void setUp() {
        sut = DatabaseHandler.getInstance();
    }

    @Test
    public void readTodoByInt() {
        // arrange
        Todo expected = new Todo(1, "Test text", 0, 1);
        // act
        Todo actual;

        actual = sut.readTodoById(1);

        // assert
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getText(), actual.getText());
        assertEquals(expected.getDone(), actual.getDone());
        assertEquals(expected.getAssignedTo(), actual.getAssignedTo());
    }

    @Test
    public void readTodoByText() {
        // arrange
        Todo expected = new Todo(1, "Test text", 0, 1);
        // act
        Todo actual;

        actual = sut.readTodoById(expected);

        // assert
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getText(), actual.getText());
        assertEquals(expected.getDone(), actual.getDone());
        assertEquals(expected.getAssignedTo(), actual.getAssignedTo());
    }

    @Test
    public void getAllTodos() {

        assertNotNull(sut.getAllTodos());

    }

    @Test
    public void getUserIntIndex() {
        // arrange
        String expected = "Bremmster";
        // act
        User actual = sut.readUserByIndex(2);
        // assert
        assertEquals(expected, actual.getName());

    }

}