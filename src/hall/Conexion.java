package hall;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
     // Conexion Local
     public static Connection conectar() throws SQLException {

        try {
            Connection cn = DriverManager.getConnection(
                "jdbc:mysql://localhost/bd_hotelalura?useTimeZone=true&serverTimeZone=UTC",
				"root",
				"Wip@8Wip@8");

                return cn;
        } catch (SQLException e) {
            // TODO: handle exception
            System.out.println("Error en conexión local  " + e);
        }

        return (null);
    }
}
