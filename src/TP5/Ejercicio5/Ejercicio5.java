package TP5.Ejercicio5;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import TP1.Ejercicio8.Queue;
import TP5.Ejercicio1.Edge;
import TP5.Ejercicio1.Graph;
import TP5.Ejercicio1.Vertex;
import TP5.Ejercicio1.adjList.AdjListGraph;

public class Ejercicio5 {

  public Ejercicio5() {

  }

  public List<Persona> jubiladosCerca(Graph<Persona> grafo, String nomEmpleado, int distanciaMax, int maxList) {
    List<Persona> jubilados = new LinkedList<Persona>();
    if (!grafo.isEmpty()) {
      Vertex<Persona> emp = this.buscarEmpleado(grafo, nomEmpleado);
      if (emp != null) {
        Queue<Vertex<Persona>> cola = new Queue<Vertex<Persona>>();
        boolean[] marca = new boolean[grafo.getSize()];
        marca[emp.getPosition()] = true;
        cola.enqueue(emp);
        cola.enqueue(null);
        while (!cola.isEmpty() && distanciaMax > 0 && jubilados.size() < maxList) {
          Vertex<Persona> verticeAct = cola.dequeue();
          if (verticeAct != null) {
            List<Edge<Persona>> adyacentes = grafo.getEdges(verticeAct);
            Iterator<Edge<Persona>> it = adyacentes.iterator();
            while (it.hasNext() && jubilados.size() < maxList) {
              Vertex<Persona> destino = it.next().getTarget();
              int posDest = destino.getPosition();
              if (!marca[posDest]) {
                marca[posDest] = true;
                cola.enqueue(destino);
                if (destino.getData().cumple()) {
                  Persona p = new Persona(destino.getData().getTipo(), destino.getData().getNombre(),
                      destino.getData().getDomicilio(),
                      destino.getData().getCobro());
                  jubilados.add(p);
                }
              }
            }
          } else if (!cola.isEmpty()) {
            distanciaMax--;
            cola.enqueue(null);
          }
        }
      }
    }
    return jubilados;
  }

  private Vertex<Persona> buscarEmpleado(Graph<Persona> grafo, String emp) {
    List<Vertex<Persona>> vertices = grafo.getVertices();
    Iterator<Vertex<Persona>> it = vertices.iterator();
    boolean sigo = true;
    Vertex<Persona> per = null;
    while (sigo && it.hasNext()) {
      Vertex<Persona> v = it.next();
      if (v.getData().getNombre().equals(emp)) {
        per = v;
        sigo = false;
      }
    }
    return per;
  }

  public static void main(String[] args) {
    Graph<Persona> grafo = new AdjListGraph<>();
    Vertex<Persona> v1 = grafo.createVertex(new Persona("Empleado", "Agustin", "AAA", true));
    Vertex<Persona> v2 = grafo.createVertex(new Persona("Jubilado", "Julian", "BBB", false));
    Vertex<Persona> v3 = grafo.createVertex(new Persona("Jubilado", "Francisco", "CCC", false));
    Vertex<Persona> v4 = grafo.createVertex(new Persona("Empleado", "Valentin", "DDD", true));
    Vertex<Persona> v5 = grafo.createVertex(new Persona("Jubilado", "Omar", "EEE", true));
    Vertex<Persona> v6 = grafo.createVertex(new Persona("Empleado", "Rosana", "FFF", true));
    Vertex<Persona> v7 = grafo.createVertex(new Persona("Jubilado", "Maria", "GGG", false));
    Vertex<Persona> v8 = grafo.createVertex(new Persona("Jubilado", "Sandra", "HHH", true));
    Vertex<Persona> v9 = grafo.createVertex(new Persona("Jubilado", "Matheo", "III", false));

    grafo.connect(v1, v2);
    grafo.connect(v2, v1);
    grafo.connect(v2, v3);
    grafo.connect(v3, v2);

    grafo.connect(v1, v9);
    grafo.connect(v9, v1);
    grafo.connect(v9, v8);
    grafo.connect(v8, v9);

    grafo.connect(v1, v4);
    grafo.connect(v4, v1);
    grafo.connect(v1, v6);
    grafo.connect(v6, v1);
    grafo.connect(v4, v5);
    grafo.connect(v5, v4);
    grafo.connect(v5, v7);
    grafo.connect(v7, v5);

    Ejercicio5 banco = new Ejercicio5();

    List<Persona> carteraJubilados = banco.jubiladosCerca(grafo, "Agustin", 5, 40);

    System.out.println("Cartera de jubilados de Agustin:");
    for (int i = 0; i < carteraJubilados.size(); i++) {
      System.out.print(carteraJubilados.get(i).getNombre() + (i < carteraJubilados.size() - 1 ? " ~ " : "."));
    }

    System.out.println();
    System.out.println();

    List<Persona> carteraJubilados2 = banco.jubiladosCerca(grafo, "Rosana", 3, 40);

    System.out.println("Cartera de jubilados de Valentin:");
    for (int i = 0; i < carteraJubilados2.size(); i++) {
      System.out.print(carteraJubilados2.get(i).getNombre() + (i < carteraJubilados2.size() - 1 ? " ~ " : "."));
    }
  }

}
