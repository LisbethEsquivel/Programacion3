import java.util.LinkedList;

public class Libro {
    private LinkedList<Hoja> hojas;

    public Libro() {
        hojas = new LinkedList<>();
    }

    public void agregarHoja(Hoja hoja) {
        hojas.add(hoja);
    }

    public Hoja getHoja(int index) {
        return hojas.get(index);
    }

    public int getNumeroHojas() {
        return hojas.size();
    }
}
