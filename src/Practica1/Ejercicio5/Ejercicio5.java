package Practica1.Ejercicio5;

public class Ejercicio5 {

  public static void main(String[] args) {
    int[] arrayEnteros1 = {15,32,97,43,95};
    int[] arrayEnteros2 = {51,23,79,34,59};
    int[] arrayEnteros3 = {41,13,69,24,49};

    //Con return.
    Datos d1 = Calculos.porReturn(arrayEnteros1);
    System.out.println(d1.toString());
    //con parametros.
    Datos d2 = new Datos();
    Calculos.porParametros(arrayEnteros2, d2);
    System.out.println(d2.toString());
    //Sin return ni parametros (variable de instancia).
    Calculos.porMetodoDeClase(arrayEnteros3);
    System.out.println(Calculos.getDatos());
  }
}
