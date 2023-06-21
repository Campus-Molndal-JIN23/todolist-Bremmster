import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TodoFacadeTest {

    TodoFacade sut;
    TodoDatabase mockDb;

    @BeforeEach
    void setUp() throws SQLException {
        mockDb = mock(TodoDatabase.class);
        sut = new TodoFacade(mockDb);

        when(mockDb.readTodoById(1)).thenReturn(new Todo(1, "Mockat testobjekt", 0, 0));
        when(mockDb.readTodoById(2)).thenReturn(new Todo(2, "Avslutad todo", 1, 0));
    }

    @Test
    void readTodo() {
        // Arrange
        Todo expected = new Todo(1, "Mockat testobjekt", 0, 0);
        // Act
        Todo actual = sut.readTodo(1);
        // Assert
        assertEquals(expected.getText(), actual.getText());

    }

    @Test
    void markDone() {
        // Arrange
        Todo expected = new Todo(1, "Mockat testobjekt", 0, 0);
        // Act
        sut.markDone(expected);
        Todo actual = sut.readTodo(1);
        // Assert
        assertNotEquals(expected.getDone(), actual.getDone());
    }
    @Test
    void markUnDone() {
        // Arrange
        Todo expected = new Todo(2, "Avslutad todo", 1, 0);
        // Act
        sut.markDone(expected);
        Todo actual = sut.readTodo(2);
        // Assert
        assertNotEquals(expected.getDone(), actual.getDone());
    }

    @Test
    void changeText() {
        // Arrange
        Todo expected = new Todo(1, "uppdaterat Mockat test object", 0, 0);
        // Act
        sut.changeText(expected, "uppdaterat Mockat test object");
        Todo actual = sut.readTodo(1);
        // Assert
        assertNotEquals(expected.getText(), actual.getText());
    }

    @Test
    void deleteTodo() {
        // Arrange
        // Act
        sut.deleteTodo(1);
        Todo actual = sut.readTodo(1);
        // Assert
        assertNull(actual);
    }

    @Test
    void assignToUser() {
    }
}