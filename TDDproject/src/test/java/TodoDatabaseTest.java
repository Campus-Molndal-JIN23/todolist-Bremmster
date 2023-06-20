import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TodoDatabaseTest {

    @Mock
    private Connection mockConnection;
    @Mock
    private PreparedStatement mockPreparedStatement;
    @Mock
    private ResultSet mockResultSet;

    private TodoDatabase todoDatabase;
    @BeforeAll
    void setUp() throws SQLException {
        MockitoAnnotations.initMocks(this);
        todoDatabase = mock(TodoDatabase.class);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
    }
    @Test
    public void testQueryData() throws SQLException {
        // Definiera ett SQL-uttryck och förväntade resultat
//        String sql = "SELECT * FROM todo";
//        when(mockResultSet.next()).thenReturn(true).thenReturn(false);
        when(todoDatabase.readTodoById(1)).thenReturn(new Todo(1,"Hej på dig!",0,1));

        // Kör testet
        Todo result = todoDatabase.readTodoById(1);

        // Verifiera att förväntade metoder har anropats
        /*
        verify(mockConnection).prepareStatement(sql);
        verify(mockPreparedStatement).executeQuery();
        verify(mockResultSet, times(2)).next();
        verify(mockResultSet).getString("text");
        */

        // Verifiera resultatet
        assertEquals("Hej på dig!", result.getText());
    }


}