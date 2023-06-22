import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyChar;
import static org.mockito.Mockito.when;


class TodoDatabaseTest {

    private TodoDatabase sut;


    @BeforeEach
    void setUp() throws SQLException {
        sut = new TodoDatabase();
    }

    @Test
    public void readTodoByInt() {
        // arrange
        Todo expected = new Todo(1, "Test text", 1,0);
        // act
        Todo actual;
        try {
            actual = sut.readTodoById(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // assert
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getText(), actual.getText());
        assertEquals(expected.getDone(), actual.getDone());
        assertEquals(expected.getAssignedTo(), actual.getAssignedTo());
    }
    @Test
    public void readTodoByText() {
        // arrange
        Todo expected = new Todo(1, "Test text", 1,0);
        // act
        Todo actual;
        try {
            actual = sut.readTodoById(expected);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // assert
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getText(), actual.getText());
        assertEquals(expected.getDone(), actual.getDone());
        assertEquals(expected.getAssignedTo(), actual.getAssignedTo());
    }

    @Test
    public void getAllTodos() {
        try {
            assertNotNull(sut.getAllTodos());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}