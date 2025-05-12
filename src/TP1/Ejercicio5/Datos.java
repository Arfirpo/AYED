package TP1.Ejercicio5;

public class Datos {
  private int maximo;
  private int minimo;
  private double promedio;

  public Datos() {
  }

  public Datos(int max, int min, double prom) {
    this.setMaximo(max);
    this.setMinimo(min);
    this.setPromedio(prom);
  }

  public void setMaximo(int maximo) {
    this.maximo = maximo;
  }

  public void setMinimo(int minimo) {
    this.minimo = minimo;
  }

  public void setPromedio(double promedio) {
    this.promedio = promedio;
  }

  public int getMaximo() {
    return maximo;
  }

  public int getMinimo() {
    return minimo;
  }

  public double getPromedio() {
    return promedio;
  }

  @Override
  public String toString() {
    String aux = "";
    aux += "**RESULTADOS**" + "\n" 
         + "Valor Maximo: " + getMaximo() + ".\n"
         + "Valor Minimo: " + getMinimo() + ".\n"
         + "Promedio: " + getPromedio() + ".\n";
    return aux;
  }
}
