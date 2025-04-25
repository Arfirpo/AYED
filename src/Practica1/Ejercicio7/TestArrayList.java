package Practica1.Ejercicio7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Practica1.Ejercicio3.Estudiante;

public class TestArrayList {


  public static void ejercicio7D(){
    List<Estudiante> listaEstudiantes = new LinkedList<Estudiante>();

    listaEstudiantes.add(new Estudiante("agustin","firpo", "2", "agustin_firpo@outlook.com", "8 N° 2889"));
    listaEstudiantes.add(new Estudiante("martin","giugovaz", "5", "martin@outlook.com", "7 N° 1587"));
    listaEstudiantes.add(new Estudiante("paula","ballon", "4", "pau@outlook.com", "523 N° 719"));

    List<Estudiante> listaEstudiantes_copia1 = new LinkedList<Estudiante>(listaEstudiantes);
  }


  public static void main(String[] args) {

    int[] secuencia = { 1, 56, 84, 97, 25, 36, 12 };

    List<Integer> arrayNumeros = new ArrayList<Integer>();
    List<Integer> listaNumeros = new LinkedList<Integer>();

    for (int i = 0; i < secuencia.length; i++) {
      arrayNumeros.add(secuencia[i]);
      listaNumeros.add(secuencia[i]);
    }

    for (Integer integer : arrayNumeros) {
      System.out.println(integer);
    }

    //una forma de recorrer con forEach.
    for (Integer integer : listaNumeros) {
      System.out.println(integer);
    }

    //forEach con expresion lambda.
    arrayNumeros.forEach(numero -> System.out.println(numero));


/** 7.c

 * Existen múltiples formas de recorrer un ArrayList en Java. A continuación, se
 * describen las tres opciones más comunes:
 * 
 * 1. Bucle for-each (Enhanced for loop):
 *    Es la opción más simple y legible para recorrer elementos de una colección.
 *    No proporciona acceso al índice y no permite modificar la colección durante
 *    la iteración.
 *    
 *    Ejemplo:
 *    for (Integer elemento : listaNumeros) {
 *        System.out.println(elemento);
 *    }
 * 
 * 2. Bucle for tradicional con índice:
 *    Permite acceder a los elementos mediante su posición. Útil cuando necesitamos
 *    conocer el índice durante la iteración o para modificar elementos.
 *    Es eficiente para ArrayList gracias al acceso aleatorio en O(1).
 *    
 *    Ejemplo:
 *    for (int i = 0; i < listaNumeros.size(); i++) {
 *        System.out.println(listaNumeros.get(i));
 *    }
 * 
 * 3. Iterador explícito:
 *    Provee una manera segura de recorrer y modificar colecciones durante la
 *    iteración. Es la única forma segura de eliminar elementos durante el recorrido.
 *    
 *    Ejemplo:
 *    Iterator<Integer> it = listaNumeros.iterator();
 *    while (it.hasNext()) {
 *        Integer numero = it.next();
 *        System.out.println(numero);
 *        // Para eliminar el elemento actual de forma segura:
 *        // it.remove();
 *    }
 */

  }
}
