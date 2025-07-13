package TP5.Ejercicio5;

public class Persona {
  private String nombre;
  private String apellido;
  private boolean activo;

  public Persona() {

  }

  public Persona(String nom, String ape, boolean activo) {
    this.setNombre(nom);
    this.setApellido(ape);
    this.setActivo(activo);
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public void setActivo(boolean activo) {
    this.activo = activo;
  }

  public String getNombre() {
    return nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public boolean isActivo() {
    return activo;
  }

}
