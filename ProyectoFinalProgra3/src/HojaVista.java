import javax.swing.*;

public class HojaVista extends JFrame {
    private JTabbedPane pestañas;
    private JTextField formulaField;
    private JMenuItem tablaHash;

    public HojaVista() {
        setTitle("Un pequeño excel");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pestañas = new JTabbedPane();
        formulaField = new JTextField(40);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Fórmula:"));
        panel.add(formulaField);

        JMenuBar menuBar = new JMenuBar();
        JMenu archivo = new JMenu("Archivo");
        tablaHash = new JMenuItem("Tabla Hash");
        archivo.add(tablaHash);
        menuBar.add(archivo);
        setJMenuBar(menuBar);

        add(panel, "North");
        add(pestañas, "Center");
    }

    public JTabbedPane getPestañas() { return pestañas; }
    public JTextField getFormulaField() { return formulaField; }
    public JMenuItem getTablaHash() { return tablaHash; }
}





