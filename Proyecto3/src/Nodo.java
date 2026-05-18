class Nodo {
    String placa, color, linea, modelo, propietario;
    Nodo derecha, abajo;

    public Nodo(String placa, String color, String linea, String modelo, String propietario) {
        this.placa = placa;
        this.color = color;
        this.linea = linea;
        this.modelo = modelo;
        this.propietario = propietario;
        this.derecha = null;
        this.abajo = null;
    }
    @Override
    public String toString() {
        return placa + " - " + color + " - " + linea + " - " + modelo + " - " + propietario;
    }
}