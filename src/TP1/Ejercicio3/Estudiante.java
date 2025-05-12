package TP1.Ejercicio3;

public class Estudiante {

  // variables de instancia
  private String nombre;
  private String apellido;
  private String comision;
  private String email;
  private String direccion;

  public Estudiante() {
  }

  public Estudiante(String nom, String ape, String com, String email, String dir) {
    this.setNombre(nom);
    this.setApellido(ape);
    this.setComision(com);
    this.setEmail(email);
    this.setDireccion(dir);
  }

  // setters
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public void setComision(String comision) {
    this.comision = comision;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  // getters
  public String getNombre() {
    return nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public String getComision() {
    return comision;
  }

  public String getEmail() {
    return email;
  }

  public String getDireccion() {
    return direccion;
  }

  // toStirng
  public String tusDatos() {
    String aux = "**Estudiante**" + "\n";
    aux += "Nombre: " + getNombre() + " " + getApellido() + "\n"
        + "Comisión: " + getComision() + "\n"
        + "Email: " + getEmail() + "\n"
        + "Dirección: " + getDireccion() + "." + "\n";
    return aux;
  }
}
