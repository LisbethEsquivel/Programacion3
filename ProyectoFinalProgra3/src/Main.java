public class Main {
    public static void main(String[] args) {
        Libro libro = new Libro();
        libro.agregarHoja(new Hoja("Hoja1", 20, 10));
        libro.agregarHoja(new Hoja("Hoja2", 20, 10));
        libro.agregarHoja(new Hoja("Hoja3", 20, 10));


        HojaVista vista = new HojaVista();

        HojaControlador controlador = new HojaControlador(libro, vista);

        controlador.iniciar();
    }
}
