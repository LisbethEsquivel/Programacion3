public class Hoja {
    private Celda[][] matriz;
    private String nombre;

    public Hoja(String nombre, int filas, int columnas) {
        this.nombre = nombre;
        matriz = new Celda[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = new Celda();
            }
        }
    }

    public Celda getCelda(int fila, int columna) {
        return matriz[fila][columna];
    }

    public String getNombre() { return nombre; }
}
