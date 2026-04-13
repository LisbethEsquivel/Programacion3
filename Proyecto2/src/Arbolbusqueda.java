public class Arbolbusqueda {
    private Nodo raiz;

    public void insertar(String palabra, int posicion) {
        raiz = insertarRec(raiz, palabra, posicion);
    }

    private Nodo insertarRec(Nodo raiz, String palabra, int posicion) {
        if (raiz == null) return new Nodo(palabra, posicion);
        if (palabra.compareTo(raiz.palabra) < 0)
            raiz.izquierda = insertarRec(raiz.izquierda, palabra, posicion);
        else if (palabra.compareTo(raiz.palabra) > 0)
            raiz.derecha = insertarRec(raiz.derecha, palabra, posicion);
        return raiz;
    }

    public boolean buscar(String palabra) {
        return buscarRec(raiz, palabra);
    }

    private boolean buscarRec(Nodo raiz, String palabra) {
        if (raiz == null) return false;
        if (raiz.palabra.equals(palabra)) return true;
        if (palabra.compareTo(raiz.palabra) < 0)
            return buscarRec(raiz.izquierda, palabra);
        else
            return buscarRec(raiz.derecha, palabra);
    }
}
