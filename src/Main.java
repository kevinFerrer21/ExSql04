import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement;

        try {
            String DB_URL = "jdbc:mysql://localhost:3306/newdb";
            String USER = "developer";
            String PASSWORD = "passwordhere";

            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            statement = connection.createStatement();

            statement.executeUpdate("ALTER TABLE `newdb`.`student` \n" +
                    "ADD COLUMN `country` VARCHAR(30) NULL AFTER `first_name`");

            statement.execute("UPDATE `newdb`.`student` SET `country` = 'italy' WHERE (`student_id` = '1');");
            statement.execute("UPDATE `newdb`.`student` SET `country` = 'italy' WHERE (`student_id` = '2');");
            statement.execute("UPDATE `newdb`.`student` SET `country` = 'germany' WHERE (`student_id` = '3');");
            statement.execute("UPDATE `newdb`.`student` SET `country` = 'germany' WHERE (`student_id` = '4');");



        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }
    }
}