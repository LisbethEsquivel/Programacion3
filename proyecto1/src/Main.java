import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String expresion = "a+b-(c-b)+e";
        System.out.println("Ecuacion: " + expresion);

        String[] postfija = {"a","b","+","c","b","-","-","e","+"};

        ArbolExpresion arbol = new ArbolExpresion();
        Nodo raiz = arbol.construirArbol(postfija);

        Map<String, Double> variables = new HashMap<>();
        for (String token : postfija) {
            if (token.matches("[a-zA-Z]") && !variables.containsKey(token)) {
                System.out.print("Ingrese valor para " + token + ": ");
                variables.put(token, sc.nextDouble());
            }
        }

        System.out.println("\nRecorrido inorden:");
        arbol.inorden(raiz);

        System.out.println("\nRecorrido preorden:");
        arbol.preorden(raiz);

        System.out.println("\nRecorrido postorden:");
        arbol.postorden(raiz);

        System.out.println("\n\nÁrbol gráfico (horizontal con líneas):");
        arbol.imprimirArbolHorizontal(raiz, "", true);

        double resultado = arbol.evaluarPostfija(postfija, variables);
        System.out.println("\nResultado: " + resultado);
    }
}