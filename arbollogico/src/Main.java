import java.util.Scanner;

class Nodo {
    int dato;
    Nodo siguiente;

    Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}

// para pila
class Pila {
    Nodo cima = null;

    void push(int dato) {
        Nodo nuevo = new Nodo(dato);
        nuevo.siguiente = cima;
        cima = nuevo;
    }

    void pop() {
        if (cima == null) {
            System.out.println("No hay nada en la pila");
        } else {
            System.out.println("dato eliminado: " + cima.dato);
            cima = cima.siguiente;
        }
    }

    void mostrar() {
        if (cima == null) {
            System.out.println("no hay nada en la pila");
            return;
        }

        Nodo aux = cima;
        System.out.print("Contenido de la pila: ");
        while (aux != null) {
            System.out.print(aux.dato + " ");
            aux = aux.siguiente;
        }
        System.out.println();
    }
}

// para cola
class Cola {
    Nodo frente = null;
    Nodo fin = null;

    void enqueue(int dato) {
        Nodo nuevo = new Nodo(dato);

        if (fin == null) {
            frente = fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
    }

    void dequeue() {
        if (frente == null) {
            System.out.println("no hay datos en la cola");
        } else {
            System.out.println("dato eliminado: " + frente.dato);
            frente = frente.siguiente;

            if (frente == null) {
                fin = null;
            }
        }
    }

    void mostrar() {
        if (frente == null) {
            System.out.println("no hay nada en la cola");
            return;
        }

        Nodo aux = frente;
        System.out.print("Contenido de la cola: ");
        while (aux != null) {
            System.out.print(aux.dato + " ");
            aux = aux.siguiente;
        }
        System.out.println();
    }
}

// para arbol bin.
class NodoArbol {
    int dato;
    NodoArbol izquierdo, derecho;

    NodoArbol(int dato) {
        this.dato = dato;
    }
}

class ArbolBinario {
    Scanner sc = new Scanner(System.in);

    NodoArbol crear() {
        System.out.print("Ingrese dato del nodo: ");
        int dato = sc.nextInt();
        NodoArbol nodo = new NodoArbol(dato);

        System.out.print("¿Agregar hijo izquierdo? (s/n): ");
        if (sc.next().equalsIgnoreCase("s")) {
            nodo.izquierdo = crear();
        }

        System.out.print("¿Agregar hijo derecho? (s/n): ");
        if (sc.next().equalsIgnoreCase("s")) {
            nodo.derecho = crear();
        }

        return nodo;
    }

    void preOrden(NodoArbol nodo) {
        if (nodo != null) {
            System.out.print(nodo.dato + " ");
            preOrden(nodo.izquierdo);
            preOrden(nodo.derecho);
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Pila pila = new Pila();
        Cola cola = new Cola();
        ArbolBinario arbol = new ArbolBinario();
        NodoArbol raiz = null;

        int opcion;

        do {
            System.out.println("\n====== MENU ======");
            System.out.println("1. Usar pila");
            System.out.println("2. Usar cola");
            System.out.println("3. Crear arbol ainario");
            System.out.println("4. Mostrar arbol (con preorden)");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    int opPila;
                    do {
                        System.out.println("\n--- PILA ---");
                        System.out.println("1. Insertar dato");
                        System.out.println("2. Eliminar ultimo dato");
                        System.out.println("3. Mostrar");
                        System.out.println("4. Volver");
                        System.out.print("Opción: ");
                        opPila = sc.nextInt();

                        switch (opPila) {
                            case 1:
                                System.out.print("Ingrese número: ");
                                pila.push(sc.nextInt());
                                break;
                            case 2:
                                pila.pop();
                                break;
                            case 3:
                                pila.mostrar();
                                break;
                        }

                    } while (opPila != 4);
                    break;

                case 2:
                    int opCola;
                    do {
                        System.out.println("\n--- COLA ---");
                        System.out.println("1. Insertar datos");
                        System.out.println("2. Eliminar ultimo dato");
                        System.out.println("3. Mostrar");
                        System.out.println("4. Volver");
                        System.out.print("Opción: ");
                        opCola = sc.nextInt();

                        switch (opCola) {
                            case 1:
                                System.out.print("Ingrese número: ");
                                cola.enqueue(sc.nextInt());
                                break;
                            case 2:
                                cola.dequeue();
                                break;
                            case 3:
                                cola.mostrar();
                                break;
                        }

                    } while (opCola != 4);
                    break;

                case 3:
                    System.out.println("\n--- CREAR ARBOL ---");
                    raiz = arbol.crear();
                    break;

                case 4:
                    System.out.println("\nRecorrido Preorden:");
                    arbol.preOrden(raiz);
                    System.out.println();
                    break;

                case 5:
                    System.out.println("Se acabo");
                    break;

                default:
                    System.out.println("Opción invalida.");
            }

        } while (opcion != 5);
    }
}