import javax.swing.*;
import java.sql.*;

public class HojaControlador {
    private Libro libro;
    private HojaVista vista;

    public HojaControlador(Libro libro, HojaVista vista) {
        this.libro = libro;
        this.vista = vista;

        vista.getFormulaField().addActionListener(e -> aplicarFormula());
        vista.getTablaHash().addActionListener(e -> mostrarTablaHash());
    }

    public void iniciar() {
        for (int i = 0; i < libro.getNumeroHojas(); i++) {
            Hoja hoja = libro.getHoja(i);
            JTable tabla = new JTable(20, 10);

            tabla.setCellSelectionEnabled(true);
            tabla.setRowSelectionAllowed(true);
            tabla.setColumnSelectionAllowed(true);

            tabla.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent e) {
                    int fila = tabla.getSelectedRow();
                    int columna = tabla.getSelectedColumn();
                    if (fila >= 0 && columna >= 0) {
                        char colLetter = (char) ('A' + columna);
                        String ref = colLetter + String.valueOf(fila + 1);

                        String actual = vista.getFormulaField().getText();
                        if (actual.startsWith("=")) {
                            vista.getFormulaField().setText(actual + (actual.endsWith("(") ? "" : ",") + ref);
                        } else {
                            vista.getFormulaField().setText(ref);
                        }
                    }
                }
            });

            tabla.putClientProperty("terminateEditOnFocusLost", true);
            tabla.getModel().addTableModelListener(e -> {
                int fila = e.getFirstRow();
                int columna = e.getColumn();
                Object valorObj = tabla.getValueAt(fila, columna);

                if (valorObj != null) {
                    try {
                        double valor = Double.parseDouble(valorObj.toString());
                        hoja.getCelda(fila, columna).setValor(valor);
                        hoja.getCelda(fila, columna).setFormula("");
                        guardarCeldaBD(hoja.getNombre(), fila, columna, valor, "");
                    } catch (NumberFormatException ex) {

                    }
                }
            });

            cargarHojaBD(hoja, tabla);
            vista.getPestañas().addTab(hoja.getNombre(), new JScrollPane(tabla));
        }
        vista.setVisible(true);
    }

    private void aplicarFormula() {
        String formula = vista.getFormulaField().getText();
        int indexHoja = vista.getPestañas().getSelectedIndex();
        JTable tabla = (JTable) ((JScrollPane) vista.getPestañas().getComponentAt(indexHoja)).getViewport().getView();

        int fila = tabla.getSelectedRow();
        int columna = tabla.getSelectedColumn();

        if (fila == -1 || columna == -1) {
            JOptionPane.showMessageDialog(vista, "Selecciona una celda primero");
            return;
        }

        double resultado = interpretarFormula(formula, libro.getHoja(indexHoja));
        libro.getHoja(indexHoja).getCelda(fila, columna).setFormula(formula);
        libro.getHoja(indexHoja).getCelda(fila, columna).setValor(resultado);

        tabla.setValueAt(resultado, fila, columna);

        guardarCeldaBD(libro.getHoja(indexHoja).getNombre(), fila, columna, resultado, formula);
    }

    private double interpretarFormula(String formula, Hoja hoja) {
        formula = formula.trim().toUpperCase();

        if (formula.startsWith("=SUMA")) return operar(formula, hoja, "SUMA");
        if (formula.startsWith("=RESTA")) return operar(formula, hoja, "RESTA");
        if (formula.startsWith("=MULT")) return operar(formula, hoja, "MULT");
        if (formula.startsWith("=DIV")) return operar(formula, hoja, "DIV");

        return 0;
    }

    private double operar(String formula, Hoja hoja, String tipo) {
        String contenido = formula.substring(formula.indexOf("(")+1, formula.indexOf(")"));
        String[] partes = contenido.split(",");
        double resultado = (tipo.equals("MULT")) ? 1 : 0;

        for (int i = 0; i < partes.length; i++) {
            double valor = obtenerValor(partes[i].trim(), hoja);
            switch (tipo) {
                case "SUMA": resultado += valor; break;
                case "RESTA": if (i == 0) resultado = valor; else resultado -= valor; break;
                case "MULT": resultado *= valor; break;
                case "DIV": if (i == 0) resultado = valor; else if (valor != 0) resultado /= valor; break;
            }
        }
        return resultado;
    }

    private double obtenerValor(String ref, Hoja hoja) {
        try {
            return Double.parseDouble(ref);
        } catch (NumberFormatException e) {
            int col = ref.charAt(0) - 'A';
            int fila = Integer.parseInt(ref.substring(1)) - 1;
            return hoja.getCelda(fila, col).getValor();
        }
    }

    private void guardarCeldaBD(String hoja, int fila, int columna, double valor, String formula) {
        try (Connection conn = ConexionBD.getConnection()) {
            String sql = "INSERT INTO celdas (hoja, fila, columna, valor, formula) " +
                    "VALUES (?,?,?,?,?) " +
                    "ON DUPLICATE KEY UPDATE valor=VALUES(valor), formula=VALUES(formula)";
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

    private void cargarHojaBD(Hoja hoja, JTable tabla) {
        try (Connection conn = ConexionBD.getConnection()) {
            String sql = "SELECT fila, columna, valor, formula FROM celdas WHERE hoja=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hoja.getNombre());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int fila = rs.getInt("fila");
                int columna = rs.getInt("columna");
                double valor = rs.getDouble("valor");
                String formula = rs.getString("formula");

                hoja.getCelda(fila, columna).setValor(valor);
                hoja.getCelda(fila, columna).setFormula(formula);
                tabla.setValueAt(valor, fila, columna);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void mostrarTablaHash() {
        int indexHoja = vista.getPestañas().getSelectedIndex();
        Hoja hojaActual = libro.getHoja(indexHoja);

        JFrame hashFrame = new JFrame("Tabla Hash " + hojaActual.getNombre());
        JTable hashTable = new JTable(20, 2);

        for (int fila = 0; fila < 20; fila++) {
            for (int col = 0; col < 10; col++) {
                double valor = hojaActual.getCelda(fila, col).getValor();
                if (valor != 0.0) {
                    int indice = (int) (valor % 20);
                    hashTable.setValueAt(valor, fila, 0);
                    hashTable.setValueAt(indice, fila, 1);
                }
            }
        }

        hashFrame.add(new JScrollPane(hashTable));
        hashFrame.setSize(400, 300);
        hashFrame.setVisible(true);
    }
}
