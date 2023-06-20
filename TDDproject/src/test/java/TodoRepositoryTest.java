import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class TodoRepositoryTest {

    private TodoRepository database;
    @BeforeEach
    void setUp() {
        database = mock(TodoRepository.class);
    }

    @Test
    void createTodo() {
        // arrange

        // act

        // assert

    }

    @Test
    void readTodoById() {
    }

    @Test
    void updateTodo() {
    }

    @Test
    void deleteTodo() {
    }

    @Test
    void getAllTodos() {
    }
}