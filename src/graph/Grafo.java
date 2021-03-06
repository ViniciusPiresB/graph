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
    private final boolean temPeso;
    private final boolean eDirecionado;

    public Grafo(boolean temPeso, boolean eDirecionado) {
        this.vertices = new ArrayList<>();
        this.temPeso = temPeso;
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

        Map<Vertice, Vertice> vAnterior = new HashMap<Vertice, Vertice>(); // esse map deveria conter(cada aresta, um
                                                                           // antecessor e peso até ali)
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

            verticesAbertos.remove(minVertexValue);

            for (Aresta a : minVertexValue.getArestas()) { // relaxar todas arestas
                Vertice vAdjacente = a.getEnd();
                if (a.getTempo() < pesoAresta.get(vAdjacente)) {
                    vAnterior.put(vAdjacente, a.getStart()); // Insere o caminho no vertice
                    pesoAresta.put(vAdjacente, a.getTempo()); // Insere o peso até aquele vAdjacente
                }
            }
        }

        ArrayList<Vertice> caminhoMinimo = new ArrayList<Vertice>();
        caminhoMinimo.add(0, destino);

        Vertice anterior = vAnterior.get(destino);
        while (anterior != inicio) {
            caminhoMinimo.add(0, anterior);
            anterior = vAnterior.get(anterior);
        }
        caminhoMinimo.add(0, inicio);

        caminhoMinimo.forEach(v -> System.out.println("Caminho: " + v.getData()));
    }

    public Vertice addVertice(String info) {
        Vertice newVertice = new Vertice(info);
        this.vertices.add(newVertice);
        return newVertice;
    }

    public void addAresta(Vertice v1, Vertice v2, Integer Peso) {
        if (!this.temPeso) {
            Peso = null;
        }

        v1.addAresta(v2, Peso);

        if (!this.eDirecionado) {
            v2.addAresta(v1, Peso);
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

    public boolean temPeso() {
        return this.temPeso;
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
