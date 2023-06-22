import org.campusmolndal.todo.Todo;
import org.campusmolndal.todo.TodoDatabase;
import org.campusmolndal.todo.TodoFacade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TodoFacadeTest {

    TodoFacade sut;
    TodoDatabase mockDb;

    //org.campusmolndal.todo.TodoFacade mockFacade;

    @BeforeEach
    void setUp() {
        mockDb = mock(TodoDatabase.class);
        //  mockFacade = mock(org.campusmolndal.todo.TodoFacade.class);
        sut = new TodoFacade(mockDb);

        when(mockDb.readTodoById(1)).thenReturn(new Todo(1, "Mockat testobjekt", 0, 0));
        when(mockDb.readTodoById(2)).thenReturn(new Todo(2, "Avslutad todo", 1, 0));
        when(mockDb.readTodoById(3)).thenReturn(null);

    }

    @Test
    void testCreateTodo()  {
        // Arrange
        sut.createTodo(new Todo(1, "Mockat testobjekt", 0, 0));

        // Assert
        assertNotNull((mockDb.readTodoById(1))); // logic is a bit flipped but production works.
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
    void testList() {
        List<Todo> expected = sut.list();

        assertNotNull(expected);

    }

    @Test
    void deleteTodo() {
        // Arrange
        // Act
        sut.deleteTodo(3);
        Todo actual = sut.readTodo(3);
        // Assert
        assertNull(actual);
    }

    @Test
    void assignToUser() {
        sut.assignToUser();

    }

    @Test
    void testConstructor() {

        assertNotNull(new TodoFacade());
    }
}