import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MatrizOrtogonal matriz = new MatrizOrtogonal();
        int opcion;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Insertar vehiculo");
            System.out.println("2. Buscar vehiculo");
            System.out.println("3. Eliminar vehiculo");
            System.out.println("4. Mostrar todos");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Placa: ");
                    String placa = sc.nextLine();
                    System.out.print("Color: ");
                    String color = sc.nextLine();
                    System.out.print("Linea: ");
                    String linea = sc.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = sc.nextLine();
                    System.out.print("Propietario: ");
                    String propietario = sc.nextLine();
                    matriz.insertar(placa, color, linea, modelo, propietario);
                    break;

                case 2:
                    System.out.print("Dato a buscar (placa, color, linea, modelo o propietario): ");
                    String dato = sc.nextLine();
                    Nodo encontrado = matriz.buscar(dato);
                    if (encontrado != null) {
                        System.out.println("Encontrado: " + encontrado);
                    } else {
                        System.out.println("No se encontro el vehiculo.");
                    }
                    break;
                case 3:
                    System.out.print("Placa del vehiculo a eliminar: ");
                    String eliminarPlaca = sc.nextLine();
                    if (matriz.eliminar(eliminarPlaca)) {
                        System.out.println("Vehiculo eliminado.");
                    } else {
                        System.out.println("No se encontro el vehiculo.");
                    }
                    break;
                case 4:
                    System.out.println("Lista de vehiculos:");
                    matriz.mostrar();
                    break;

                case 5:
                    System.out.println("Se acabo...");
                    break;

                default:
                    System.out.println("Opcion inexistente");
            }
        } while (opcion != 5);

        sc.close();
    }
}