import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GuardarCelda {

    public void guardarCelda(String hoja, int fila, int columna, double valor, String formula) {
        try (Connection conn = ConexionBD.getConnection()) {
            String sql = "INSERT INTO celdas (hoja, fila, columna, valor, formula) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hoja);
            ps.setInt(2, fila);
            ps.setInt(3, columna);
            ps.setDouble(4, valor);
            ps.setString(5, formula);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
