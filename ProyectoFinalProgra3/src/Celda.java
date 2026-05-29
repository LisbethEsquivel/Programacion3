public class Celda {
    private String formula;
    private double valor;

    public Celda() {
        this.formula = "";
        this.valor = 0.0;
    }

    public String getFormula() { return formula; }
    public void setFormula(String formula) { this.formula = formula; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }
}

