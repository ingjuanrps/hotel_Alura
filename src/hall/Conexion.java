package hall;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    // Conexion Local
    public static Connection conectar() throws SQLException {

        try {
            /*
             * Connection cn = DriverManager.getConnection(
             * "jdbc:mysql://localhost/bd_hotelalura?useTimeZone=true&serverTimeZone=UTC",
             * "root",
             * "Wip@8Wip@8");
             */

            Connection cn = DriverManager.getConnection(
                    "mysql://ui5esryvwzxdg4jr:RHc7fF2KCICwF45cI9bE@buxyt7wqrbsu0umjbuux-mysql.services.clever-cloud.com:3306/buxyt7wqrbsu0umjbuuxui5esryvwzxdg4jr",
                    "ui5esryvwzxdg4jr",
                    "RHc7fF2KCICwF45cI9bE");

            return cn;
        } catch (SQLException e) {
            // TODO: handle exception
            System.out.println("Error en conexión local  " + e);
        }
            System.out.println("CONEXION CORRECTA");
        return (null);
    }
}
