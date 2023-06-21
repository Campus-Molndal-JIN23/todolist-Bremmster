import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        Application todoApp = new Application(new TodoFacade());
    }
}
