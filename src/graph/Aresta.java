/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

/**
 *
 * @author Vinicius
 */
public class Aresta {

    private final Vertice start;
    private final Vertice end;
    private final int grau;

    public Aresta(Vertice startVertice, Vertice endVertice, int grau) {
        this.start = startVertice;
        this.end = endVertice;
        this.grau = grau;
    }

    public Vertice getStart() {
        return this.start;
    }

    public Vertice getEnd() {
        return this.end;
    }

    public int getGrau() {
        return this.grau;
    }
}
