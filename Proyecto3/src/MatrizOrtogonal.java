class MatrizOrtogonal {
    Nodo inicio;

    public void insertar(String placa, String color, String linea, String modelo, String propietario) {
        Nodo nuevo = new Nodo(placa, color, linea, modelo, propietario);
        if (inicio == null) {
            inicio = nuevo;
        } else {
            Nodo temp = inicio;
            while (temp.derecha != null) {
                temp = temp.derecha;
            }
            temp.derecha = nuevo;
        }
    }

    public Nodo buscar(String dato) {
        Nodo temp = inicio;
        while (temp != null) {
            if (temp.placa.equalsIgnoreCase(dato) ||
                    temp.color.equalsIgnoreCase(dato) ||
                    temp.linea.equalsIgnoreCase(dato) ||
                    temp.modelo.equalsIgnoreCase(dato) ||
                    temp.propietario.equalsIgnoreCase(dato)) {
                return temp;
            }
            temp = temp.derecha;
        }
        return null;
    }

    public boolean eliminar(String placa) {
        if (inicio == null) return false;
        if (inicio.placa.equalsIgnoreCase(placa)) {
            inicio = inicio.derecha;
            return true;
        }
        Nodo temp = inicio;
        while (temp.derecha != null) {
            if (temp.derecha.placa.equalsIgnoreCase(placa)) {
                temp.derecha = temp.derecha.derecha;
                return true;
            }
            temp = temp.derecha;
        }
        return false;
    }

    public void mostrar() {
        Nodo temp = inicio;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.derecha;
        }
    }
}