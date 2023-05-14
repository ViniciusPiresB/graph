/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vinicius
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws InterruptedException
     */

    public static void main(String[] args) throws InterruptedException {
        TextLoader textLoader = new TextLoader();

        List<String> textList = textLoader.readArrayOfText("/home/vinicius/Desktop/a.dat");

        List<String[]> allNodesArray = new ArrayList<>();

        for (String nodeDataStr : textList) {
            String[] nodeData = nodeDataStr.split("	");

            allNodesArray.add(nodeData);
        }

        boolean eDirecionado = true;
        TemporalGraph graph = new TemporalGraph(eDirecionado);

        List<Integer> vertices = new ArrayList<>();

        for (String[] nodeArray : allNodesArray) {
            int contactInterval = Integer.parseInt(nodeArray[0]);
            int firstNodeId = Integer.parseInt(nodeArray[1]);
            int secondNodeId = Integer.parseInt(nodeArray[2]);

            Vertice firstNode = null;
            Vertice secondNode = null;

            if (!vertices.contains(firstNodeId)) {
                firstNode = graph.addVertice(firstNodeId);
            } else {
                ArrayList<Vertice> verticesAtual = graph.getVertices();

                Vertice verticeAtualClone = new Vertice(firstNodeId);

                firstNode = verticesAtual.get(verticesAtual.indexOf(verticeAtualClone));
            }

            if (!vertices.contains(secondNodeId)) {
                secondNode = graph.addVertice(secondNodeId);
            } else {
                ArrayList<Vertice> verticesAtual = graph.getVertices();

                Vertice verticeAtualClone = new Vertice(firstNodeId);

                firstNode = verticesAtual.get(verticesAtual.indexOf(verticeAtualClone));
            }

            graph.addAresta(firstNode, secondNode, contactInterval);
        }

        ArrayList<Vertice> vs = graph.getVertices();
        vs.forEach(v -> System.out.println(v.getData()));

        /*
         * boolean eDirecionado = true;
         * 
         * TemporalGraph grafo = new TemporalGraph(eDirecionado);
         * 
         * Vertice um = grafo.addVertice("1");
         * Vertice dois = grafo.addVertice("2");
         * Vertice tres = grafo.addVertice("3");
         * Vertice quatro = grafo.addVertice("4");
         * 
         * grafo.addAresta(um, dois, 3);
         * grafo.addAresta(um, dois, 6);
         * grafo.addAresta(um, dois, 11);
         * grafo.addAresta(dois, tres, 7);
         * grafo.addAresta(dois, tres, 9);
         * grafo.addAresta(dois, quatro, 12);
         * grafo.addAresta(tres, quatro, 11);
         * grafo.addAresta(tres, quatro, 12);
         * 
         * List<TemporalPath> allPaths = grafo.allPairsTemporalPaths();
         * 
         * List<TemporalPath> tPaths = grafo.fastestPathOfEachVertex(allPaths);
         * 
         * tPaths.forEach(path -> path.printPath());
         * 
         * System.out.println(grafo.closeness(dois, tPaths));
         */
    }

}
