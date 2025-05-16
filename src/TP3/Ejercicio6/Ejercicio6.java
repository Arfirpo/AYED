package TP3.Ejercicio6;

import TP3.Ejercicio1y2.GeneralTree;
import java.lang.Character;

public class Ejercicio6 {

  public static void main(String[] args) {

    GeneralTree<Character> A = new GeneralTree<Character>('A');
    GeneralTree<Character> B = new GeneralTree<Character>('B');
    GeneralTree<Character> C = new GeneralTree<Character>('C');
    GeneralTree<Character> D = new GeneralTree<Character>('D');
    GeneralTree<Character> E = new GeneralTree<Character>('E');
    GeneralTree<Character> F = new GeneralTree<Character>('F');
    GeneralTree<Character> G = new GeneralTree<Character>('G');
    GeneralTree<Character> H = new GeneralTree<Character>('H');
    GeneralTree<Character> I = new GeneralTree<Character>('I');
    GeneralTree<Character> J = new GeneralTree<Character>('J');
    GeneralTree<Character> K = new GeneralTree<Character>('K');
    GeneralTree<Character> L = new GeneralTree<Character>('L');
    GeneralTree<Character> M = new GeneralTree<Character>('M');
    GeneralTree<Character> N = new GeneralTree<Character>('N');
    GeneralTree<Character> P = new GeneralTree<Character>('P');

    G.addChild(L);

    J.addChild(M);
    J.addChild(N);

    D.addChild(H);
    D.addChild(I);
    D.addChild(J);
    D.addChild(K);
    D.addChild(P);

    C.addChild(F);
    C.addChild(G);

    A.addChild(B);
    A.addChild(C);
    A.addChild(D);
    A.addChild(E);

    RedDeAguaPotable rdp = new RedDeAguaPotable(A);

    System.out.println("El caudal minimo de la red de agua potable es " + rdp.minimoCaudal(1000) + " ml.");

  }

}
