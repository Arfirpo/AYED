package TP5.Ejercicio5;

import java.util.LinkedList;
import java.util.List;

import TP1.Ejercicio8.Queue;
import TP5.Ejercicio1.Edge;
import TP5.Ejercicio1.Graph;
import TP5.Ejercicio1.Vertex;

public class Ejercicio5 {

  public List<Persona> jubiladosCerca(Graph<Persona> grafo, Persona Empleado, int distanciaMax) {
    List<Persona> jubilados = new LinkedList<Persona>();
    if (!grafo.isEmpty()) {
      Vertex<Persona> empleado = grafo.search(Empleado);
      if (empleado != null) {
        bfs(grafo, empleado, jubilados, distanciaMax, new boolean[grafo.getSize()]);
      }
    }
    return jubilados;
  }

  private void bfs(Graph<Persona> grafo, Vertex<Persona> empleado, List<Persona> jubilados, int distanciaMax,
      boolean[] marca) {

    Queue<Vertex<Persona>> cola = new Queue<Vertex<Persona>>();
    cola.enqueue(empleado);
    marca[empleado.getPosition()] = true;
    while(!cola.isEmpty()){
      Vertex<Persona> verticeAct = cola.dequeue();
      List<Edge<Persona>> adyacentes = grafo.getEdges(verticeAct);
      
      if((!verticeAct.getData().isActivo() && distanciaMax - ))
        jubilados.add(verticeAct.getData());
    }

  }

  public static void main(String[] args) {

  }

}
