package TP1.Ejercicio8;

import java.util.ArrayList;
import java.util.List;

public class Queue<T> extends Secuence {

  protected List<T> data;

  public Queue() {
    this.data = new ArrayList<T>();
  }

  public void enqueue(T dato) {
    data.add(dato);
  }

  public T dequeue() {
    return data.remove(0);
  }

  public T head() {
    return data.get(0);
  }

  @Override
  public boolean isEmpty() {
    return data.isEmpty();
  }

  @Override
  public int size() {
    return data.size();
  }

  @Override
  public String toString() {
    String aux = "[";
    for (int i = 0; i < data.size(); i++) {
      if (i < data.size() - 1) {
        aux += data.get(i) + ",";
      } else {
        aux += data.get(i) + "]";
      }
    }
    return aux;
  }
}
