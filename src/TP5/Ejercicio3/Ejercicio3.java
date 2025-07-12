package TP5.Ejercicio3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import TP5.Ejercicio1.Edge;
import TP5.Ejercicio1.Graph;
import TP5.Ejercicio1.Vertex;
import TP5.Ejercicio1.adjList.AdjListGraph;

public class Ejercicio3 {

  private Graph<String> mapaCiudades;

  public Ejercicio3(Graph<String> mapa) {
    this.setMapaCiudades(mapa);
  }

  public void setMapaCiudades(Graph<String> mapaCiudades) {
    this.mapaCiudades = mapaCiudades;
  }

  public Graph<String> getMapaCiudades() {
    return mapaCiudades;
  }

  /*------------------------------------------------------------------ */

  public List<String> devolverCamino(String ciudad1, String ciudad2) {
    List<String> recorrido = new LinkedList<String>();
    if (!this.mapaCiudades.isEmpty()) {
      Vertex<String> origen = this.mapaCiudades.search(ciudad1);
      Vertex<String> destino = this.mapaCiudades.search(ciudad1);
      if (origen != null && destino != null) {
        devolverCamino(origen, destino, recorrido, new boolean[this.mapaCiudades.getSize()]);
      }
    }
    return recorrido;
  }

  private boolean devolverCamino(Vertex<String> origen, Vertex<String> destino, List<String> camino, boolean[] marca) {
    boolean encontre = false;

    marca[origen.getPosition()] = true;
    camino.add(origen.getData());

    if (origen == destino) {
      return true;
    }

    else {
      List<Edge<String>> adyacencias = this.mapaCiudades.getEdges(origen);
      Iterator<Edge<String>> it = adyacencias.iterator();
      while (!encontre && it.hasNext()) {
        Vertex<String> vertice = it.next().getTarget();
        int j = vertice.getPosition();
        if (!marca[j]) {
          encontre = devolverCamino(vertice, destino, camino, marca);
        }
      }
    }

    if (!encontre) {
      camino.remove(camino.size() - 1);
    }

    return encontre;
  }

  /*------------------------------------------------------------------ */

  public List<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, List<String> ciudades) {
    List<String> camino = new LinkedList<String>();
    if (!this.mapaCiudades.isEmpty()) {
      Vertex<String> origen = this.mapaCiudades.search(ciudad1);
      Vertex<String> destino = this.mapaCiudades.search(ciudad2);
      if (origen != null && destino != null) {
        boolean[] marca = new boolean[this.mapaCiudades.getSize()];
        marcarRestringidos(ciudades, marca);
        devolverCamino(origen, destino, camino, marca);
      }
    }
    return camino;
  }

  private void marcarRestringidos(List<String> ciudades, boolean[] marca) {
    for (String ciudad : ciudades) {
      Vertex<String> v = this.mapaCiudades.search(ciudad);
      if (v != null)
        marca[v.getPosition()] = true;
    }
  }

  /*------------------------------------------------------------------ */

  public List<String> caminoMasCorto(String ciudad1, String ciudad2) {
    List<String> camino = new LinkedList<String>();
    if (!this.mapaCiudades.isEmpty()) {
      Vertex<String> origen = this.mapaCiudades.search(ciudad1);
      Vertex<String> destino = this.mapaCiudades.search(ciudad2);
      if (origen != null && destino != null) {
        caminoMasCorto(origen, destino, camino, new LinkedList<String>(), new boolean[this.mapaCiudades.getSize()], 0,
            Integer.MAX_VALUE);
      }
    }
    return camino;
  }

  private int caminoMasCorto(Vertex<String> origen, Vertex<String> destino, List<String> minCamino,
      List<String> caminoAct, boolean[] marca,
      int total, int min) {
    marca[origen.getPosition()] = true;
    caminoAct.add(origen.getData());
    if (origen == destino && total < min) {
      min = total;
      minCamino.removeAll(minCamino);
      minCamino.addAll(caminoAct);
    } else {
      List<Edge<String>> adyacentes = this.mapaCiudades.getEdges(origen);
      Iterator<Edge<String>> it = adyacentes.iterator();
      while (it.hasNext() && total < min) {
        Edge<String> arista = it.next();
        int j = arista.getTarget().getPosition();
        total += arista.getWeight();
        if (!marca[j]) {
          min = caminoMasCorto(arista.getTarget(), destino, minCamino, caminoAct, marca, total, min);
        }
      }
    }
    marca[origen.getPosition()] = false;
    caminoAct.remove(caminoAct.size() - 1);
    return min;
  }

  /*------------------------------------------------------------------ */

  public List<String> CaminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
    List<String> camino = new LinkedList<String>();
    if (!this.mapaCiudades.isEmpty()) {
      Vertex<String> origen = this.mapaCiudades.search(ciudad1);
      Vertex<String> destino = this.mapaCiudades.search(ciudad2);
      if (origen != null && destino != null) {
        caminoSinCargarCombustible(origen, destino, camino, new boolean[this.getMapaCiudades().getSize()], tanqueAuto);
      }
    }
    return camino;
  }

  private boolean caminoSinCargarCombustible(Vertex<String> origen, Vertex<String> destino,
      List<String> caminoSinCombustible, boolean[] marca, int tanqueAuto) {

    boolean encontre = false;
    marca[origen.getPosition()] = true;
    caminoSinCombustible.add(origen.getData());
    if (origen == destino) {
      return true;
    } else {
      List<Edge<String>> adyacentes = this.getMapaCiudades().getEdges(origen);
      Iterator<Edge<String>> it = adyacentes.iterator();
      while (!encontre && it.hasNext()) {
        Edge<String> arista = it.next();
        int j = arista.getTarget().getPosition();
        if (!marca[j] && tanqueAuto - arista.getWeight() > 0) {
          encontre = caminoSinCargarCombustible(arista.getTarget(), destino, caminoSinCombustible, marca,
              (tanqueAuto - arista.getWeight()));
        }
      }
    }
    if (!encontre) {
      caminoSinCombustible.remove(caminoSinCombustible.size() - 1);
    }
    marca[origen.getPosition()] = false;
    return encontre;
  }

  /*------------------------------------------------------------------ */
  public List<String> caminoConMenorCargaDeCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
    List<String> camino = new LinkedList<String>();
    if (!this.getMapaCiudades().isEmpty()) {
      Vertex<String> origen = this.getMapaCiudades().search(ciudad1);
      Vertex<String> destino = this.getMapaCiudades().search(ciudad2);
      if (origen != null && destino != null) {
        caminoConMenorCargaDeCombustible(origen, destino, camino, new LinkedList<String>(),
            new boolean[this.getMapaCiudades().getSize()], tanqueAuto, 0, Integer.MAX_VALUE);
      }
    }
    return camino;
  }

  private int caminoConMenorCargaDeCombustible(Vertex<String> origen, Vertex<String> destino, List<String> caminoMin,
      List<String> caminoAct, boolean[] marca, int tanqueAct, int tanque, int min) {

    return min;
  }

  /*------------------------------------------------------------------ */
  public static void main(String[] args) {

    // Grafo - Versión: lista de adjacencias.
    Graph<String> mapaCiudades = new AdjListGraph<String>();

    // Vertices
    Vertex<String> v1 = mapaCiudades.createVertex("La Plata");
    Vertex<String> v2 = mapaCiudades.createVertex("Berisso");
    Vertex<String> v3 = mapaCiudades.createVertex("Ensenada");
    Vertex<String> v4 = mapaCiudades.createVertex("Berazategui");
    Vertex<String> v5 = mapaCiudades.createVertex("CABA");
    Vertex<String> v6 = mapaCiudades.createVertex("Dolores");
    Vertex<String> v7 = mapaCiudades.createVertex("Chacabuco");

    // Aristas
    mapaCiudades.connect(v1, v2, 4);
    mapaCiudades.connect(v2, v1, 4);
    mapaCiudades.connect(v1, v3, 3);
    mapaCiudades.connect(v3, v1, 3);
    mapaCiudades.connect(v1, v4, 4);
    mapaCiudades.connect(v4, v1, 4);
    mapaCiudades.connect(v2, v5, 15);
    mapaCiudades.connect(v5, v2, 15);
    mapaCiudades.connect(v3, v5, 3);
    mapaCiudades.connect(v5, v3, 3);
    mapaCiudades.connect(v4, v3, 4);
    mapaCiudades.connect(v3, v4, 4);
    mapaCiudades.connect(v4, v5, 11);
    mapaCiudades.connect(v5, v4, 11);
    mapaCiudades.connect(v4, v6, 10);
    mapaCiudades.connect(v6, v4, 10);
    mapaCiudades.connect(v4, v3, 4);
    mapaCiudades.connect(v3, v4, 4);
    mapaCiudades.connect(v5, v7, 4);
    mapaCiudades.connect(v7, v5, 4);
    mapaCiudades.connect(v6, v7, 9);
    mapaCiudades.connect(v7, v6, 9);

  }

}
