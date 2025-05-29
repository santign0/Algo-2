package aed;

import java.util.*;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2           5.compareTo(7) < 0 == true
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    private Nodo raiz;
    private int cardinal;

    private class Nodo {
        T valor;
        Nodo izq;
        Nodo der;
        Nodo padre;
        
        Nodo(T v) {this.valor = v;}
    }

    public ABB() {
        raiz = null;
        cardinal = 0;
    }

    public int cardinal() {
        return cardinal;
    }

    public T minimo(){
        Nodo actual = raiz;
        while (actual.izq != null) {
            actual = actual.izq;
        }return actual.valor;
    }

    public T maximo(){
        Nodo actual = raiz;
        while (actual.der != null) {
            actual = actual.der;
        }return actual.valor;
    }

    private Nodo buscarPadre(Nodo raiz , T e){
        Nodo actual = raiz;
        if (e.compareTo(actual.valor) > 0){
            if (actual.der == null){
                return actual;
            }else{
                actual = actual.der;
                return buscarPadre(actual, e);
            }
        }else if(e.compareTo(actual.valor) < 0){
            if (actual.izq == null){
                return actual;
            }else{
                actual = actual.izq;
                return buscarPadre(actual, e);
            }
        }else{
            return actual;
        }
    }
    public void insertar(T elem){
        Nodo e = new Nodo(elem);
        Nodo actual = raiz;
        if (raiz != null){
            if (buscarPadre(raiz, elem)== actual && elem.compareTo(actual.valor) < 0){
                actual.izq = e;
                e.padre = actual;
            }else if(buscarPadre(raiz, elem) == actual && elem.compareTo(actual.valor) > 0){
                actual.der = e;
                e.padre = actual;
            }cardinal ++;
        }
    }

    private boolean perteneceAux(Nodo n, T e){
        Nodo actual = n;
        

    public boolean pertenece(T elem){
        if (raiz.valor == null){
            return false;
        }
        else if (raiz.valor == elem){
            return true;
        }else{
            return perteneceAux( elem);
        }
    }

    public void eliminar(T elem){
        throw new UnsupportedOperationException("No implementada aun");
    }

    public String toString(){
        throw new UnsupportedOperationException("No implementada aun");
    }

    private class ABB_Iterador implements Iterador<T> {
        private Nodo _actual;

        public boolean haySiguiente() {            
            throw new UnsupportedOperationException("No implementada aun");
        }
    
        public T siguiente() {
            throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

}
