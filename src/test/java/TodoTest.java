import org.campusmolndal.todo.Todo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TodoTest {
    Todo sut;

    @Test
    public void testTodoSmalConstructor() {
        // Arrange
        String expected = "text sträng";
        sut = new Todo(expected);
        // act
        String actual = sut.getText();
        // assert
        assertEquals(expected, actual);
    }

    @Test
    public void testTodoMediumConstructor() { // String text, int done, int assignedTo
        // Arrange
        String expectedText = "text sträng";
        int expectedDone = 0;
        int expectedAssignedTo = 1;
        sut = new Todo(expectedText, expectedDone, expectedAssignedTo);
        // act
        String actualText = sut.getText();
        int actualDone = sut.getDone();
        int actualAssignedTo = sut.getAssignedTo();
        // assert
        assertEquals(expectedText, actualText);
        assertEquals(expectedDone, actualDone);
        assertEquals(expectedAssignedTo, actualAssignedTo);
    }
    @Test
    public void testTodoBigConstructor() {
        // Arrange
        int expetedID = 1;
        String expectedText = "text sträng";
        int expectedDone = 0;
        int expectedAssignedTo = 1;
        sut = new Todo(expetedID, expectedText, expectedDone, expectedAssignedTo);
        // act
        int actualId = sut.getId();
        String actualText = sut.getText();
        int actualDone = sut.getDone();
        int actualAssignedTo = sut.getAssignedTo();
        // assert
        assertEquals(expetedID, actualId);
        assertEquals(expectedText, actualText);
        assertEquals(expectedDone, actualDone);
        assertEquals(expectedAssignedTo, actualAssignedTo);
    }

    @Test
    public void testTodoToString() {
        // Arrange
        int id = 1;
        String text = "text sträng";
        int done = 0;
        int assignedTo = 1;
        sut = new Todo(id, text, done, assignedTo);
        String expected = "Todo{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", done=" + false +
                ", assignedTo=" + assignedTo +
                '}';
        // assert
        assertEquals(expected, sut.toString());
    }
}
