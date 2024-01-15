package ev2;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.testng.annotations.Test;

public class BDTest {

    
    private static final String URL = "jdbc:mysql://localhost:3306/Persona";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "";

    @Test
    public void testConexionBaseDatos() {
        Connection conexion = null;

        try {
            // Intenta establecer la conexión
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            assertNotNull("La conexión a la base de datos no debe ser nula", conexion);
        } catch (SQLException e) {
            fail("Error al conectar a la base de datos: " + e.getMessage());
        } finally {
            // Cierra la conexión si se estableció
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
