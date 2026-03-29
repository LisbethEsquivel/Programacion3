class ArbolB {
    NodoB raiz;
    int grado;

    public ArbolB(int grado) {
        this.grado = grado;
        this.raiz = new NodoB(grado, true);
    }

    public void insertar(int k) {
        NodoB r = raiz;
        if (r.numClaves == 2 * grado - 1) {
            NodoB nuevo = new NodoB(grado, false);
            nuevo.hijos[0] = r;
            raiz = nuevo;
            dividirHijo(nuevo, 0, r);
            insertarNoLleno(nuevo, k);
        } else {
            insertarNoLleno(r, k);
        }
    }

    private void insertarNoLleno(NodoB x, int k) {
        int i = x.numClaves - 1;
        if (x.esHoja) {
            while (i >= 0 && k < x.claves[i]) {
                x.claves[i + 1] = x.claves[i];
                i--;
            }
            x.claves[i + 1] = k;
            x.numClaves++;
        } else {
            while (i >= 0 && k < x.claves[i]) i--;
            i++;
            if (x.hijos[i].numClaves == 2 * grado - 1) {
                dividirHijo(x, i, x.hijos[i]);
                if (k > x.claves[i]) i++;
            }
            insertarNoLleno(x.hijos[i], k);
        }
    }

    private void dividirHijo(NodoB x, int i, NodoB y) {
        NodoB z = new NodoB(grado, y.esHoja);
        z.numClaves = grado - 1;
        for (int j = 0; j < grado - 1; j++) z.claves[j] = y.claves[j + grado];
        if (!y.esHoja) {
            for (int j = 0; j < grado; j++) z.hijos[j] = y.hijos[j + grado];
        }
        y.numClaves = grado - 1;
        for (int j = x.numClaves; j >= i + 1; j--) x.hijos[j + 1] = x.hijos[j];
        x.hijos[i + 1] = z;
        for (int j = x.numClaves - 1; j >= i; j--) x.claves[j + 1] = x.claves[j];
        x.claves[i] = y.claves[grado - 1];
        x.numClaves++;
    }

    public NodoB buscar(int k) {
        return raiz.buscar(k);
    }

    public void imprimir(NodoB nodo) {
        if (nodo != null) {
            int i;
            for (i = 0; i < nodo.numClaves; i++) {
                if (!nodo.esHoja) imprimir(nodo.hijos[i]);
                System.out.print(nodo.claves[i] + " ");
            }
            if (!nodo.esHoja) imprimir(nodo.hijos[i]);
        }
    }
}