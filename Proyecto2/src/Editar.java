import java.util.Stack;

public class Editar {
    private String texto = "";
    private Stack<String> pilaUndo = new Stack<>();
    private Stack<String> pilaRedo = new Stack<>();
    private Arbolbusqueda arbol = new Arbolbusqueda();

    public void escribir(String nuevoTexto) {
        pilaUndo.push(texto);
        texto += " " + nuevoTexto;
        actualizarArbol();
    }

    public void deshacer() {
        if (!pilaUndo.isEmpty()) {
            pilaRedo.push(texto);
            texto = pilaUndo.pop();
        }
    }

    public void rehacer() {
        if (!pilaRedo.isEmpty()) {
            pilaUndo.push(texto);
            texto = pilaRedo.pop();
        }
    }

    public boolean buscar(String palabra) {
        return arbol.buscar(palabra);
    }

    public void reemplazar(String vieja, String nueva) {
        pilaUndo.push(texto);
        texto = texto.replace(vieja, nueva);
        actualizarArbol();
    }

    private void actualizarArbol() {
        arbol = new Arbolbusqueda();
        String[] palabras = texto.split("\\s+");
        for (int i = 0; i < palabras.length; i++) {
            arbol.insertar(palabras[i], i);
        }
    }

    public void mostrar() {
        System.out.println("Palabras agregadas: " + texto);
    }
}

