package TP1.Ejercicio9;

import java.util.*;

public class TestBalanceo {

  private static boolean esBalanceado(String expr) {
    List<Character> cierre = new LinkedList<Character>();
    cierre.add(')');
    cierre.add(']');
    cierre.add('}');
    
    List<Character> apertura = new LinkedList<Character>();
    apertura.add('(');
    apertura.add('[');
    apertura.add('{');
    
    // Comprobaciones iniciales rápidas
    if (expr.length() % 2 != 0) {
      return false;  // Longitud impar significa desbalanceado
    }
    if (expr.length() > 0 && cierre.contains(expr.charAt(0))) {
      return false;  // Comenzar con símbolo de cierre es inválido
    }

    Stack<Character> pila = new Stack<Character>();
    for (int i = 0; i < expr.length(); i++) {
      Character actual = expr.charAt(i);
      
      if (apertura.contains(actual)) {
        // Si es símbolo de apertura, añadir a la pila
        pila.push(actual);
      } else if (cierre.contains(actual)) {
        // Si es símbolo de cierre, verificar coincidencia
        if (pila.isEmpty()) {
          return false;  // Símbolo de cierre con pila vacía es inválido
        }
        
        Character elem = pila.pop();
        if (apertura.indexOf(elem) != cierre.indexOf(actual)) {
          return false;  // Símbolos no coincidentes
        }
      }
      // Los caracteres que no son paréntesis o corchetes se ignoran
    }
    
    // Si la pila no está vacía, hay símbolos de apertura sin cerrar
    return pila.isEmpty();
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    System.out.print("Ingrese un string: ");
    String cadena = s.nextLine();
    s.close();
    System.out.println("La expresión [" + cadena + "]" + (esBalanceado(cadena) ? " sí " : " no ") + "está balanceada");
  }
}