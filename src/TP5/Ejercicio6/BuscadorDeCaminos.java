package TP5.Ejercicio6;

import java.util.LinkedList;
import java.util.List;

import TP5.Ejercicio1.Graph;
import TP5.Ejercicio1.Vertex;
import TP5.Ejercicio1.adjList.AdjListGraph;

public class BuscadorDeCaminos {

  Graph<String> bosque;

  public BuscadorDeCaminos() {
  }

  public BuscadorDeCaminos(Graph<String> grafo) {
    this.setBosque(grafo);
  }

  public void setBosque(Graph<String> bosque) {
    this.bosque = bosque;
  }

  public Graph<String> getBosque() {
    return bosque;
  }

  public List<List<String>> recorridosMasSeguros() {
    List<List<String>> caminos = new LinkedList<List<String>>();
    if (!this.bosque.isEmpty()) {
      Vertex<String> origen = this.bosque.search("Casa Caperusita");
      Vertex<String> destino = this.bosque.search("Casa Abuelita");
      if (origen != null && destino != null) {
        recorridosMasSeguros(origen, destino, new boolean[this.bosque.getSize()], caminos, new LinkedList<String>());
      }
    }
    return caminos;
  }

  private void recorridosMasSeguros(Vertex<String> origen, Vertex<String> destino, boolean[] marca,
      List<List<String>> caminos, List<String> caminoAct) {

  }

  public static void main(String[] args) {
    Graph<String> bosque = new AdjListGraph<String>();
    Vertex<String> v1 = bosque.createVertex("Casa Caperucita");
    Vertex<String> v2 = bosque.createVertex("Claro 3");
    Vertex<String> v3 = bosque.createVertex("Claro 1");
    Vertex<String> v4 = bosque.createVertex("Claro 2");
    Vertex<String> v5 = bosque.createVertex("Claro 5");
    Vertex<String> v6 = bosque.createVertex("Claro 4");
    Vertex<String> v7 = bosque.createVertex("Casa Abuelita");

    bosque.connect(v1, v2, 4);
    bosque.connect(v2, v1, 4);

    bosque.connect(v1, v3, 3);
    bosque.connect(v3, v1, 3);

    bosque.connect(v1, v4, 4);
    bosque.connect(v4, v1, 4);

    bosque.connect(v2, v5, 15);
    bosque.connect(v5, v2, 15);

    bosque.connect(v3, v5, 3);
    bosque.connect(v5, v3, 3);

    bosque.connect(v3, v4, 4);
    bosque.connect(v4, v3, 4);

    bosque.connect(v4, v5, 11);
    bosque.connect(v5, v4, 11);

    bosque.connect(v4, v6, 10);
    bosque.connect(v6, v4, 10);

    bosque.connect(v6, v7, 9);
    bosque.connect(v7, v6, 9);

    bosque.connect(v5, v7, 4);
    bosque.connect(v7, v5, 4);

  }

}
