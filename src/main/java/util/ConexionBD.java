package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {

    private static final String URL =
            "jdbc:mysql://localhost:3306/helpdesk_db";

    private static final String USER =
            "root";

    private static final String PASSWORD =
            "Summer.664";

    public static Connection conectar() {

        try {

            return DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );

        } catch (Exception e) {

            System.out.println(
                    "Error conexión: "
                            + e.getMessage()
            );

            return null;
        }
    }

}
