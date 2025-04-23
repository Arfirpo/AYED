package Practica1.Ejercicio5;

public class Calculos {

  private static Datos d;

  public Calculos() {

  }

  public static Datos getDatos() {
      return d;
  }

  //metodos
  public static Datos porReturn(int[] a) {
    if (a != null) {
      int min = Integer.MAX_VALUE;
      int max = Integer.MIN_VALUE;
      double prom = 0;

      for (int i = 0; i < a.length; i++) {
        if(a[i] > max) max = a[i];
        if(a[i] < min) min = a[i];
        prom += a[i];
      }
      prom = prom / a.length;
      Datos d = new Datos(max, min, prom);
      return d; 
    }
    return null;
  }

  public static void porParametros(int[]a,Datos d){
    if(a.length > 0){
      int min = Integer.MAX_VALUE;
      int max = Integer.MIN_VALUE;
      double prom = 0;
      for (int i = 0; i < a.length; i++) {
        if(a[i] > max) max = a[i];
        if(a[i] < min) min = a[i];
        prom += a[i];
      }
      prom = prom / a.length;
      d.setMaximo(max);
      d.setMinimo(min);
      d.setPromedio(prom);
    } else {
      d = null;
    }
  }

  public static void porMetodoDeClase(int[] a){
    if(a != null){
      int min = Integer.MAX_VALUE;
      int max = Integer.MIN_VALUE;
      double prom = 0;
      for (int i = 0; i < a.length; i++) {
        if(a[i] > max) max = a[i];
        if(a[i] < min) min = a[i];
        prom += a[i];
      }
      prom = prom / a.length;
      d = new Datos(max, min, prom);
    }
  }
}
