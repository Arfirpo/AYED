package TP5.Ejercicio2;

import java.util.LinkedList;
import java.util.List;

import TP5.Ejercicio1.Graph;
import TP5.Ejercicio1.Vertex;
import TP5.Ejercicio1.Edge;

public class Recorridos<T> {


  public List<T> dfs(Graph<T> grafo){

    boolean[] marca = new boolean[grafo.getSize()];
    List<T> lista = new LinkedList<T>();
    for (int i = 0; i < marca.length; i++) {
      if(!marca[i]) {
        dfs(i,grafo,lista,marca);
      }
    }
    return lista;
  }

  private void dfs(int i, Graph<T> grafo, List<T> lista, boolean[] marca){
    marca[i] = true;
    Vertex<T> v = grafo.getVertex(i);
    lista.add(v.getData());
    List<Edge<T>> adyacentes = grafo.getEdges(v);
    for (Edge<T> e: adyacentes) {
      int j = e.getTarget().getPosition();
      if(!marca[j]){
        dfs(j, grafo, lista, marca);
      }
    }
  }

}
