import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CargarHoja {

    public void cargarHoja(String hoja, Hoja modelo) {
        try (Connection conn = ConexionBD.getConnection()) {
            String sql = "SELECT fila, columna, valor, formula FROM celdas WHERE hoja=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hoja);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int fila = rs.getInt("fila");
                int columna = rs.getInt("columna");
                double valor = rs.getDouble("valor");
                String formula = rs.getString("formula");

                modelo.getCelda(fila, columna).setValor(valor);
                modelo.getCelda(fila, columna).setFormula(formula);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


