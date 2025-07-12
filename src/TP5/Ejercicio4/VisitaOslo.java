package TP5.Ejercicio4;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import TP5.Ejercicio1.Edge;
import TP5.Ejercicio1.Graph;
import TP5.Ejercicio1.Vertex;
import TP5.Ejercicio1.adjList.AdjListGraph;

public class VisitaOslo {

  public List<String> paseoEnBici(Graph<String> lugares, String destino, int maxTiempo,
      List<String> lugaresRestringidos) {
    List<String> camino = new LinkedList<String>();
    if (!lugares.isEmpty()) {
      Vertex<String> origen = lugares.search("Ayuntamiento");
      if (origen != null && (lugares.search(destino) != null)) {
        boolean[] marcas = new boolean[lugares.getSize()];
        marcarRestringidos(lugares, marcas, lugaresRestringidos);
        paseoEnBici(lugares, origen, destino, camino, marcas, maxTiempo);
      }
    }
    return camino;
  }

  private void marcarRestringidos(Graph<String> lugares, boolean[] marcas, List<String> restringidos) {
    for (String locacion : restringidos) {
      Vertex<String> v = lugares.search(locacion);
      if (v != null) {
        if (!marcas[v.getPosition()])
          marcas[v.getPosition()] = true;
      }
    }
  }

  private boolean paseoEnBici(Graph<String> lugares, Vertex<String> origen, String destino, List<String> camino,
      boolean[] marcas, int maxTiempo) {

    boolean encontre = false;
    marcas[origen.getPosition()] = true;
    camino.add(origen.getData());

    if (origen.getData().equals(destino))
      return true;

    else {
      List<Edge<String>> adyacentes = lugares.getEdges(origen);
      Iterator<Edge<String>> it = adyacentes.iterator();
      while (!encontre && it.hasNext()) {
        Edge<String> arista = it.next();
        int j = arista.getTarget().getPosition();
        if (!marcas[j]) {
          if (maxTiempo - arista.getWeight() >= 0) {
            encontre = paseoEnBici(lugares, arista.getTarget(), destino, camino, marcas,
                maxTiempo - arista.getWeight());
          }
        }
      }
    }
    if (!encontre) {
      camino.remove(camino.size() - 1);
      marcas[origen.getPosition()] = false;
    }
    return encontre;
  }

  public static void main(String[] args) {

    Graph<String> bicisendas = new AdjListGraph<String>();
    Vertex<String> v1 = bicisendas.createVertex("Ayuntamiento");
    Vertex<String> v2 = bicisendas.createVertex("El Tigre");
    Vertex<String> v3 = bicisendas.createVertex("La Opera");
    Vertex<String> v4 = bicisendas.createVertex("Fortaleza Akershus");
    Vertex<String> v5 = bicisendas.createVertex("Museo Munch");
    Vertex<String> v6 = bicisendas.createVertex("Parque Botanico");
    Vertex<String> v7 = bicisendas.createVertex("Galeria Nacional");
    Vertex<String> v8 = bicisendas.createVertex("Palacio Real");
    Vertex<String> v9 = bicisendas.createVertex("Akker Brigge");
    Vertex<String> v10 = bicisendas.createVertex("Holmenkollen");
    Vertex<String> v11 = bicisendas.createVertex("Parque Vigeland");
    Vertex<String> v12 = bicisendas.createVertex("FolkMuseum");
    Vertex<String> v13 = bicisendas.createVertex("Museo Fram");
    Vertex<String> v14 = bicisendas.createVertex("Museo del Barco Polar");
    Vertex<String> v15 = bicisendas.createVertex("Museo Vikingo");

    bicisendas.connect(v1, v2, 15);
    bicisendas.connect(v2, v1, 15);
    bicisendas.connect(v1, v6, 10);
    bicisendas.connect(v6, v1, 10);
    bicisendas.connect(v1, v8, 5);
    bicisendas.connect(v8, v1, 5);
    bicisendas.connect(v1, v9, 20);
    bicisendas.connect(v9, v1, 20);
    bicisendas.connect(v2, v5, 15);
    bicisendas.connect(v5, v2, 15);
    bicisendas.connect(v2, v3, 5);
    bicisendas.connect(v3, v2, 5);
    bicisendas.connect(v3, v4, 10);
    bicisendas.connect(v4, v3, 10);
    bicisendas.connect(v5, v6, 1);
    bicisendas.connect(v6, v5, 1);
    bicisendas.connect(v6, v7, 15);
    bicisendas.connect(v7, v6, 15);
    bicisendas.connect(v7, v11, 10);
    bicisendas.connect(v11, v7, 10);
    bicisendas.connect(v11, v10, 30);
    bicisendas.connect(v10, v11, 30);
    bicisendas.connect(v11, v12, 20);
    bicisendas.connect(v12, v11, 20);
    bicisendas.connect(v12, v8, 5);
    bicisendas.connect(v8, v12, 5);
    bicisendas.connect(v12, v9, 30);
    bicisendas.connect(v9, v12, 30);
    bicisendas.connect(v12, v13, 5);
    bicisendas.connect(v13, v12, 5);
    bicisendas.connect(v13, v14, 5);
    bicisendas.connect(v14, v13, 5);
    bicisendas.connect(v14, v15, 5);
    bicisendas.connect(v15, v14, 5);
    bicisendas.connect(v9, v15, 30);
    bicisendas.connect(v15, v9, 30);

    VisitaOslo v = new VisitaOslo();

    List<String> lugaresRestringidos = new LinkedList<>();
    lugaresRestringidos.add("Palacio Real");
    lugaresRestringidos.add("Akker Brigge");

    List<String> resultado = v.paseoEnBici(bicisendas, "Museo Vikingo", 120, lugaresRestringidos);

    for (int i = 0; i < resultado.size(); i++) {
      System.out.print(resultado.get(i) + (i < resultado.size() - 1 ? " ~ " : "."));
    }
  }
}
