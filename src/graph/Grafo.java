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
import java.util.*;

public class Grafo {

    private final ArrayList<Vertice> vertices;
    private final boolean temGrau;
    private final boolean eDirecionado;

    public Grafo(boolean temGrau, boolean eDirecionado) {
        this.vertices = new ArrayList<>();
        this.temGrau = temGrau;
        this.eDirecionado = eDirecionado;
    }

    public static void buscaEmLargura(Vertice inicio) {
        ArrayList<Vertice> verticesVisitados = new ArrayList<>();

        verticesVisitados.add(inicio);

        Queue<Vertice> filaVisita = new LinkedList<>();
        filaVisita.add(inicio);

        while (!filaVisita.isEmpty()) {
            Object verticeAtual = filaVisita.remove();
            System.out.println(
                    ((Vertice) verticeAtual).getData());

            for (Aresta a : ((Vertice) verticeAtual).getArestas()) {
                Vertice vizinho = a.getEnd();
                if (!verticesVisitados.contains(vizinho)) {
                    verticesVisitados.add(vizinho);
                    filaVisita.add(vizinho);
                }
            }

        }

    }

    public void buscaDijkstra(Vertice inicio, Vertice destino) {
        ArrayList<Vertice> verticesAbertos = new ArrayList<>();

        Map<Vertice, Vertice> vAnterior = new HashMap<Vertice, Vertice>(); // esse map deveria conter(cada aresta, um //
                                                                           // // antecessor e peso até ali)
        Map<Vertice, Integer> pesoAresta = new HashMap<Vertice, Integer>();
        Vertice initialize = null;

        vertices.forEach(vertice -> vAnterior.put(vertice, initialize)); // inicializo cada vertice
        vertices.forEach(vertice -> pesoAresta.put(vertice, Integer.MAX_VALUE)); // inicializo cada vertice
        vAnterior.put(inicio, inicio);
        pesoAresta.put(inicio, 0);
        vertices.forEach(vertice -> verticesAbertos.add(vertice));

        while (!verticesAbertos.isEmpty()) {
            int minValueOfVertice = Integer.MAX_VALUE;
            Vertice minVertexValue = null;

            for (Vertice v : verticesAbertos) {
                if (pesoAresta.get(v) < minValueOfVertice) {
                    minValueOfVertice = pesoAresta.get(v);
                    minVertexValue = v;
                }
            }
            if (minVertexValue == null)
                break;

            System.out.println("Vertice com valor minimo: " + minVertexValue.getData());

            verticesAbertos.remove(minVertexValue);

            for (Aresta a : minVertexValue.getArestas()) {
                Vertice vAdjacente = a.getEnd();
                if (a.getGrau() < pesoAresta.get(vAdjacente)) {
                    vAnterior.put(vAdjacente, a.getStart()); // Insere o caminho no vertice
                    pesoAresta.put(vAdjacente, a.getGrau()); // Insere o peso até aquele vAdjacente
                }
            }
        }
        Vertice anterior = vAnterior.get(destino);
        System.out.println(destino.getData());
        System.out.println(anterior.getData());
        System.out.println(vAnterior.get(anterior).getData());
    }

    public Vertice addVertice(String info) {
        Vertice newVertice = new Vertice(info);
        this.vertices.add(newVertice);
        return newVertice;
    }

    public void addAresta(Vertice v1, Vertice v2, Integer grau) {
        if (!this.temGrau) {
            grau = null;
        }

        v1.addAresta(v2, grau);

        if (!this.eDirecionado) {
            v2.addAresta(v1, grau);
        }
    }

    public void removeAresta(Vertice v1, Vertice v2) {
        v1.removeAresta(v2);

        if (!this.eDirecionado) {
            v2.removeAresta(v1);
        }
    }

    public void removeVertice(Vertice v) {
        this.vertices.remove(v);
    }

    public ArrayList<Vertice> getVertices() {
        return this.vertices;
    }

    public boolean temGrau() {
        return this.temGrau;
    }

    public boolean eDirecionado() {
        return this.eDirecionado;
    }

    public void printAllVertices() {
        for (Vertice v : this.vertices) {
            v.print();
        }
    }

    public Vertice getVerticePorValor(String valor) {
        for (Vertice v : this.vertices) {
            if (v.getData() == valor) {
                return v;
            }
        }
        return null;
    }

    public void printAdjListDeUmVertice(Vertice v) {
        for (Aresta a : v.getArestas()) {
            System.out.println(a.getStart().getData() + "==>" + a.getEnd().getData());
        }
    }

    public boolean verificarAresta(Vertice v1, Vertice v2) {
        ArrayList<Aresta> arestas = v1.getArestas();
        for (Aresta a : arestas)
            if (a.getEnd() == v2)
                return true;
        return false;
    }

}
