package TP5.Ejercicio2;

import java.util.LinkedList;
import java.util.List;
import TP1.Ejercicio8.Queue;

import TP5.Ejercicio1.Graph;
import TP5.Ejercicio1.Vertex;
import TP5.Ejercicio1.adjList.AdjListGraph;
import TP5.Ejercicio1.Edge;

public class Recorridos<T> {

  // El orden de ambos algoritmos es O(V+E): donde v es la cantidad de vertices y
  // E la cantidad de aristas, ambas pertenecientes a un grafo.

  // Deep First Search (Recorrido en profundidad).
  public List<T> dfs(Graph<T> grafo) {

    boolean[] marca = new boolean[grafo.getSize()];
    List<T> lista = new LinkedList<T>();
    for (int i = 0; i < grafo.getSize(); i++) {
      if (!marca[i]) {
        dfs(i, grafo, lista, marca);
      }
    }
    return lista;
  }

  private void dfs(int i, Graph<T> grafo, List<T> lista, boolean[] marca) {
    marca[i] = true;
    Vertex<T> v = grafo.getVertex(i);
    lista.add(v.getData());
    List<Edge<T>> adyacentes = grafo.getEdges(v);
    for (Edge<T> e : adyacentes) {
      int j = e.getTarget().getPosition();
      if (!marca[j]) {
        dfs(j, grafo, lista, marca);
      }
    }
  }

  // Breath First Search (recorrido en amplitud).
  public List<T> bfs(Graph<T> grafo) {
    boolean[] marca = new boolean[grafo.getSize()];
    List<T> lista = new LinkedList<T>();
    for (int i = 0; i < grafo.getSize(); i++) {
      if (!marca[i]) {
        bfs(i, grafo, lista, marca);
      }
    }
    return lista;
  }

  private void bfs(int i, Graph<T> grafo, List<T> lista, boolean[] marca) {
    Queue<Vertex<T>> cola = new Queue<Vertex<T>>();
    cola.enqueue(grafo.getVertex(i));
    marca[i] = true;
    while (!cola.isEmpty()) {
      Vertex<T> verticeActual = cola.dequeue();
      lista.add(verticeActual.getData());
      List<Edge<T>> adyacentes = grafo.getEdges(verticeActual);
      for (Edge<T> e : adyacentes) {
        int j = e.getTarget().getPosition();
        if (!marca[j]) {
          marca[j] = true;
          cola.enqueue(e.getTarget());
        }
      }
    }
  }

  public static void main(String[] args) {

    Graph<String> ciudades = new AdjListGraph<String>();
    Recorridos<String> rec = new Recorridos<String>();
    Vertex<String> v1 = ciudades.createVertex("Buenos Aires");
    Vertex<String> v2 = ciudades.createVertex("Santiago");
    Vertex<String> v3 = ciudades.createVertex("Asunción");
    Vertex<String> v4 = ciudades.createVertex("Tokio");
    Vertex<String> v5 = ciudades.createVertex("Roma");
    Vertex<String> v6 = ciudades.createVertex("Paris");
    Vertex<String> v7 = ciudades.createVertex("Madrid");
    Vertex<String> v8 = ciudades.createVertex("Caracas");
    ciudades.connect(v1, v2);
    ciudades.connect(v1, v3);
    ciudades.connect(v2, v5);
    ciudades.connect(v3, v7);
    ciudades.connect(v3, v8);
    ciudades.connect(v8, v7);
    ciudades.connect(v8, v4);
    ciudades.connect(v5, v4);
    ciudades.connect(v7, v4);
    ciudades.connect(v6, v5);
    ciudades.connect(v6, v7);
    ciudades.connect(v6, v4);
    ciudades.connect(v4, v1);

    List<String> lisDFS = rec.dfs(ciudades);
    List<String> lisBFS = rec.bfs(ciudades);

    System.out.println();

    System.out.println("Lista DFS:");
    for (int i = 0; i < lisDFS.size(); i++) {
      System.out.print(lisDFS.get(i) + (i < lisDFS.size() - 1 ? " ~ " : "."));
    }

    System.out.println();
    System.out.println();

    System.out.println("Lista BFS:");
    for (int i = 0; i < lisBFS.size(); i++) {
      System.out.print(lisBFS.get(i) + (i < lisDFS.size() - 1 ? " ~ " : "."));
    }
    System.out.println();
    System.out.println();
  }
}