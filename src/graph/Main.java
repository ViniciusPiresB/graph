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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean eDirecionado = true;

        TemporalGraph grafo = new TemporalGraph(eDirecionado);
        Vertice um = grafo.addVertice("1");
        Vertice dois = grafo.addVertice("2");
        Vertice tres = grafo.addVertice("3");
        Vertice quatro = grafo.addVertice("4");
        Vertice cinco = grafo.addVertice("5");

        grafo.addAresta(um, dois, 2);
        grafo.addAresta(um, dois, 3);
        grafo.addAresta(um, cinco, 6);
        grafo.addAresta(quatro, tres, 8);
        grafo.addAresta(tres, dois, 10);

        grafo.allPairsTemporalPaths();
    }

}
