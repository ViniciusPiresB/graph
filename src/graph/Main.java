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
        // TODO code application logic here
        boolean temGrau = true;
        boolean eDirecionado = true;

        Grafo grafo = new Grafo(temGrau, eDirecionado);
        Vertice um = grafo.addVertice("1");
        Vertice dois = grafo.addVertice("2");
        Vertice tres = grafo.addVertice("3");
        Vertice quatro = grafo.addVertice("4");
        Vertice cinco = grafo.addVertice("5");
        Vertice seis = grafo.addVertice("6");
        Vertice sete = grafo.addVertice("7");

        grafo.addAresta(um, dois, 5);
        grafo.addAresta(quatro, um, 3);
        grafo.addAresta(um, tres, 10);
        grafo.addAresta(dois, tres, 4);
        grafo.addAresta(tres, sete, 5);
        grafo.addAresta(seis, sete, 3);
        grafo.addAresta(cinco, quatro, 1);

        // Vertice buscado = grafo.getVerticePorValor("4");

        // System.out.println("\n\n");
        // grafo.printAllVertices();
        // grafo.printAdjListDeUmVertice(tres);
        // grafo.removeAresta(tres, dois);
        // System.out.println("Novos vertices: ");
        // grafo.printAdjListDeUmVertice(tres);
        // System.out.println("Busca em largura");
        // Grafo.buscaEmLargura(sete);

        // System.out.println(grafo.verificarAresta(cinco, quatro) + "\n\n\n\n\n\n");

        grafo.buscaDijkstra(cinco, sete);
    }

}
