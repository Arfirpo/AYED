package TP5.Ejercicio1.adjList;

import TP5.Ejercicio1.Edge;
import TP5.Ejercicio1.Vertex;

public class AdjListEdge<T> implements Edge<T> {
	private TP5.Ejercicio1.Vertex<T> target;
	private int weight;
	
	/**
	 * Crea una arista.  Se invoca desde AdjListGraph.
	 */
	AdjListEdge(TP5.Ejercicio1.Vertex<T> target, int weight){
		this.target = target;
		this.weight = weight;
	}
	
	@Override
	public Vertex<T> getTarget() {
		return target;
	}

	@Override
	public int getWeight() {
		return weight;
	}
}
