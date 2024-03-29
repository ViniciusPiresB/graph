/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.ArrayList;

/**
 *
 * @author Vinicius
 */
public class Vertice {

    private final int data;
    private final ArrayList<Aresta> arestas;

    public Vertice(int data) {
        this.data = data;
        this.arestas = new ArrayList<>();
    } //

    public void addAresta(Vertice verticeFinal, int grau) {
        this.arestas.add(new Aresta(this, verticeFinal, grau));
    }

    public void removeAresta(Vertice verticeFinal) {
        this.arestas.removeIf(aresta -> aresta.getEnd().equals(verticeFinal));
    }

    public ArrayList<Aresta> getArestas() {
        return this.arestas;
    }

    public int getData() {
        return this.data;
    }

    public void print() {
        System.out.println(data);
    }

}
