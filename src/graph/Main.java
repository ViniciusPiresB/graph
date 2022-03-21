/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.List;

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

        grafo.addAresta(um, dois, 3);
        grafo.addAresta(um, dois, 6);
        grafo.addAresta(um, dois, 11);
        grafo.addAresta(dois, tres, 7);
        grafo.addAresta(dois, tres, 9);
        grafo.addAresta(dois, quatro, 12);
        grafo.addAresta(tres, quatro, 11);
        grafo.addAresta(tres, quatro, 12);

        grafo.allPairsTemporalPaths().forEach(tPath -> tPath.printPath());
    }

}
