import java.sql.Connection;
import java.sql.PreparedStatement;


public class PruebaBD {
    public static void main(String[] args) {
        try (Connection conn = ConexionBD.getConnection()) {
            String sql = "INSERT INTO celdas (hoja, fila, columna, valor, formula) " +
                    "VALUES ('Hoja1', 0, 0, 99.0, 'TEST') " +
                    "ON DUPLICATE KEY UPDATE valor=VALUES(valor), formula=VALUES(formula)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("Dato guardado!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

