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
    private final int tempo;

    public Aresta(Vertice startVertice, Vertice endVertice, int tempo) {
        this.start = startVertice;
        this.end = endVertice;
        this.tempo = tempo;
    }

    public Vertice getStart() {
        return this.start;
    }

    public Vertice getEnd() {
        return this.end;
    }

    public int getGrau() {
        return this.tempo;
    }
}
