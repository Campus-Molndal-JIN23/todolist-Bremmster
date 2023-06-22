package org.campusmolndal.todo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class TodoDatabaseTest {

    private TodoDatabase sut;


    @BeforeEach
    void setUp() throws SQLException {
        sut = new TodoDatabase();
    }

    @Test
    public void readTodoByInt() {
        // arrange
        Todo expected = new Todo(1, "Test text", 0, 0);
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
        Todo expected = new Todo(1, "Test text", 0, 0);
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

}