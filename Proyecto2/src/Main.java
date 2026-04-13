import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Editar editor = new Editar();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Editor de Texto ---");
            System.out.println("1. Escribir");
            System.out.println("2. Deshacer");
            System.out.println("3. Rehacer");
            System.out.println("4. Buscar palabra");
            System.out.println("5. Reemplazar palabra");
            System.out.println("6. Mostrar texto");
            System.out.println("0. Salir");
            System.out.print("Elija una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Escriba un texto: ");
                    String nuevo = sc.nextLine();
                    editor.escribir(nuevo);
                    break;
                case 2:
                    editor.deshacer();
                    break;
                case 3:
                    editor.rehacer();
                    break;
                case 4:
                    System.out.print("Escriba la palabra que desea buscar: ");
                    String buscar = sc.nextLine();
                    System.out.println("¿Existente? " + editor.buscar(buscar));
                    break;
                case 5:
                    System.out.print("Palabra que desea reemplazar: ");
                    String vieja = sc.nextLine();
                    System.out.print("Nueva palabra: ");
                    String nueva = sc.nextLine();
                    editor.reemplazar(vieja, nueva);
                    break;
                case 6:
                    editor.mostrar();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        } while (opcion != 0);
    }
}
