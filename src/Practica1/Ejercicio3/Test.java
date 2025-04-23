package Practica1.Ejercicio3;

import java.util.Scanner;

public class Test {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    Estudiante[] vEstudiante = new Estudiante[2];
    Profesor[] vProfesor = new Profesor[3];

    System.out.println("\n" + "Seleccione una opción:");
    System.out.println("1.-Carga por defecto (prueba con valores ya fijados)");
    System.out.println("2.-Cargar arrays manualmente");
    System.out.print("Opción elegida: ");
    int opc = s.nextInt();
    System.out.println();

    switch (opc) {
      case 1:
        vEstudiante[0] = new Estudiante("agustin", "firpo", "4", "agustin@hotmail.com", "8 n° 2889");
        vEstudiante[1] = new Estudiante("camila", "firpo", "2", "camila@hotmail.com", "8 n° 2889");
        vProfesor[0] = new Profesor("martin", "cirio", "elvio@lin", "4", "Instituto de Menores");
        vProfesor[1] = new Profesor("jorge", "martin", "jor@gito", "2", "ADISCA La Plata");
        vProfesor[2] = new Profesor("Esteban", "Lamothe", "carade@piedra", "1", "Instituto de Actuación de La Salada");
        break;

      case 2:
        // cargar array de estudiantes
        for (int i = 0; i < vEstudiante.length; i++) {
          vEstudiante[i] = new Estudiante();
          System.out.println("\n" + "Estudiante " + (i + 1) + "\n");
          System.out.print("Ingrese Nombre: ");
          vEstudiante[i].setNombre(s.nextLine());
          System.out.print("Ingrese Apellido: ");
          vEstudiante[i].setApellido(s.nextLine());
          System.out.print("Ingrese Comisión: ");
          vEstudiante[i].setComision(s.nextLine());
          System.out.print("Ingrese Dirección: ");
          vEstudiante[i].setDireccion(s.nextLine());
          System.out.print("Ingrese Email: ");
          vEstudiante[i].setEmail(s.nextLine());
        }

        // cargar array de profesores
        for (int i = 0; i < vProfesor.length; i++) {
          vProfesor[i] = new Profesor();
          System.out.println("\n" + "Profesor " + (i + 1) + "\n");
          System.out.print("Ingrese Nombre: ");
          vProfesor[i].setNombre(s.nextLine());
          System.out.print("Ingrese Apellido: ");
          vProfesor[i].setApellido(s.nextLine());
          System.out.print("Ingrese Email: ");
          vProfesor[i].setEmail(s.nextLine());
          System.out.print("Ingrese Facultad: ");
          vProfesor[i].setFacultad(s.nextLine());
          System.out.print("Ingrese Catedra: ");
          vProfesor[i].setCatedra(s.nextLine());

        }
        break;
    }

    // recorrer y mostrar array de profesores
    for (Profesor profesor : vProfesor) {
      System.out.println(profesor.tusDatos()); break;
    }

    // recorrer y mostrar array de estudiantes
    for (Estudiante estudiante : vEstudiante) {
      System.out.println(estudiante.tusDatos());break;
    }

    s.close();
  }
}
