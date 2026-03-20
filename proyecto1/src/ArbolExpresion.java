import java.util.*;

public class ArbolExpresion {

    void inorden(Nodo nodo) {
        if (nodo != null) {
            inorden(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            inorden(nodo.derecho);
        }
    }

    void preorden(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.valor + " ");
            preorden(nodo.izquierdo);
            preorden(nodo.derecho);
        }
    }

    void postorden(Nodo nodo) {
        if (nodo != null) {
            postorden(nodo.izquierdo);
            postorden(nodo.derecho);
            System.out.print(nodo.valor + " ");
        }
    }

    Nodo construirArbol(String[] postfija) {
        Stack<Nodo> pila = new Stack<>();
        for (String token : postfija) {
            if (token.matches("[a-zA-Z0-9]+")) {
                pila.push(new Nodo(token));
            } else {
                Nodo nodo = new Nodo(token);
                Nodo derecho = pila.pop();
                Nodo izquierdo = pila.pop();
                nodo.izquierdo = izquierdo;
                nodo.derecho = derecho;
                pila.push(nodo);
            }
        }
        return pila.pop();
    }

    double evaluarPostfija(String[] expresion, Map<String, Double> variables) {
        Stack<Double> pila = new Stack<>();
        for (String token : expresion) {
            if (token.matches("[0-9]+")) {
                pila.push(Double.parseDouble(token));
            } else if (variables.containsKey(token)) {
                pila.push(variables.get(token));
            } else {
                double b = pila.pop();
                double a = pila.pop();
                switch (token) {
                    case "+": pila.push(a + b); break;
                    case "-": pila.push(a - b); break;
                    case "*": pila.push(a * b); break;
                    case "/": pila.push(a / b); break;
                }
            }
        }
        return pila.pop();
    }

    void imprimirArbolHorizontal(Nodo nodo, String prefijo, boolean esDerecho) {
        if (nodo == null) return;

        System.out.println(prefijo + (esDerecho ? "└── " : "├── ") + nodo.valor);

        if (nodo.izquierdo != null || nodo.derecho != null) {
            if (nodo.izquierdo != null) {
                imprimirArbolHorizontal(nodo.izquierdo, prefijo + (esDerecho ? "    " : "│   "), false);
            }
            if (nodo.derecho != null) {
                imprimirArbolHorizontal(nodo.derecho, prefijo + (esDerecho ? "    " : "│   "), true);
            }
        }
    }
}