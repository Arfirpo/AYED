package TP3.Ejercicio4;

public class AreaEmpresa {
  private String area;
  private int retardo;

  public AreaEmpresa(String nom, int retardo) {
    this.area = nom;
    this.retardo = retardo;
  }

  public AreaEmpresa() {

  }

  public void setArea(String area) {
    this.area = area;
  }

  public String getArea() {
    return area;
  }

  public void setRetardo(Integer retardo) {
    this.retardo = retardo;
  }

  public Integer getRetardo() {
    return retardo;
  }

  @Override
  public String toString() {
    String aux = "";
    aux += "Area: " + this.getArea() + "\n";
    aux += "Retardo: " + this.getRetardo() + "\n";
    return aux;
  }
}
