class NodoB {
    int[] claves;
    int grado;
    NodoB[] hijos;
    int numClaves;
    boolean esHoja;

    public NodoB(int grado, boolean esHoja) {
        this.grado = grado;
        this.esHoja = esHoja;
        this.claves = new int[2 * grado - 1];
        this.hijos = new NodoB[2 * grado];
        this.numClaves = 0;
    }

    public NodoB buscar(int k) {
        int i = 0;
        while (i < numClaves && k > claves[i]) i++;
        if (i < numClaves && claves[i] == k) return this;
        if (esHoja) return null;
        return hijos[i].buscar(k);
    }
}