
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    // nome usuario SQL

    public Connection conectar() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();

        }
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/sneaker_store", "root", "araujo164");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}