public class Nodo {
    String palabra;
    int posicion;
    Nodo izquierda, derecha;

    public Nodo(String palabra, int posicion) {
        this.palabra = palabra;
        this.posicion = posicion;
        izquierda = derecha = null;
    }
}