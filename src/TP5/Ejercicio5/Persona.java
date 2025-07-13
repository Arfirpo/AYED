package TP5.Ejercicio5;

public class Persona {
  private String tipo;
  private String nombre;
  private String domicilio;
  private boolean cobro;

  public Persona() {

  }

  public Persona(String nom, String dom, String tipo) {
    this.setNombre(nom);
    this.setDomicilio(dom);
    this.setTipo(tipo);
  }

  public Persona(String tipo, String nom, String dom, boolean cobro) {
    this.setNombre(nom);
    this.setDomicilio(dom);
    this.setTipo(tipo);
    this.setCobro(cobro);
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setDomicilio(String domicilio) {
    this.domicilio = domicilio;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public void setCobro(boolean cobro) {
    this.cobro = cobro;
  }

  public String getNombre() {
    return nombre;
  }

  public String getDomicilio() {
    return domicilio;
  }

  public String getTipo() {
    return tipo;
  }

  public boolean getCobro() {
    return cobro;
  }

  public boolean cumple() {
    return (this.tipo.equals("Jubilado") && !this.cobro) ? true : false;
  }

}
