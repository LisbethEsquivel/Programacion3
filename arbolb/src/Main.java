import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el grado del árbol B: ");
        int grado = sc.nextInt();

        ArbolB arbol = new ArbolB(grado);

        System.out.println("Ingrese 5 números para insertar en el árbol:");
        for (int i = 0; i < 5; i++) {
            int num = sc.nextInt();
            arbol.insertar(num);
        }

        System.out.println("Claves en orden dentro del árbol B:");
        arbol.imprimir(arbol.raiz);
    }
}