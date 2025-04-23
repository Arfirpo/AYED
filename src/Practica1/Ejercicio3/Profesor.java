package Practica1.Ejercicio3;

public class Profesor {
    // variables de instancia
    private String nombre;
    private String apellido;
    private String email;
    private String catedra;
    private String facultad;

    public Profesor() {
    }

    public Profesor(String nom, String ape, String em, String cat, String fac) {
        this.setNombre(nom);
        this.setApellido(ape);
        this.setEmail(em);
        this.setCatedra(cat);
        this.setFacultad(fac);
    }

    // setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCatedra(String catedra) {
        this.catedra = catedra;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    // getters
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getCatedra() {
        return catedra;
    }

    public String getFacultad() {
        return facultad;
    }

    // toStirng
    public String tusDatos() {
        String aux = "**Docente**" + "\n";
        aux += "Nombre: " + getNombre() + " " + getApellido() + "\n"
                + "Email: " + getEmail() + "\n"
                + "Catedra: " + getCatedra() + "\n"
                + "Facultad: " + getFacultad() + "\n";
        return aux;
    }
}
