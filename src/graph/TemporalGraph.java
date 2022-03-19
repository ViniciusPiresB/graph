package graph;

import java.util.*;

public class TemporalGraph {
    private final ArrayList<Vertice> vertices;
    private final boolean eDirecionado;

    public TemporalGraph(boolean eDirecionado) {
        this.vertices = new ArrayList<>();
        this.eDirecionado = eDirecionado;
    }

    private int R = 1;
    private int T = 0;

    public List<TemporalPath> allPairsTemporalPaths() {
        List<TemporalPath> P = new ArrayList<TemporalPath>();

        for (Vertice vertice : vertices) {

            ArrayList<Aresta> arestas = vertice.getArestas();

            for (Aresta aresta : arestas) {
                List<Aresta> init = new ArrayList<>();
                TemporalPath p = new TemporalPath(init, aresta.getStart(), aresta.getEnd(), 0, 1, 0, 0);
                p.edges.add(aresta);
                P.add(p);
            }

            int currentPathLength = 1;
            while (true) {
                TemporalPath pTemp = null;
                currentPathLength++;
                for (TemporalPath p : P) {
                    for (TemporalPath q : P) {
                        if (!p.equals(q)) {
                            if ((p.getLength() + q.getLength()) == currentPathLength) {
                                if (p.getEnd() == p.getInit()) {
                                    if (p.getEndTime() + R + T <= q.getInitTime()) {
                                        // r recebe p + q
                                        // pTemp recebe r
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }

        return P;
    }

    public Vertice addVertice(String info) {
        Vertice newVertice = new Vertice(info);
        this.vertices.add(newVertice);
        return newVertice;
    }

    public void addAresta(Vertice v1, Vertice v2, Integer tempo) {
        v1.addAresta(v2, tempo);

        if (!this.eDirecionado) {
            v2.addAresta(v1, tempo);
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

    public boolean eDirecionado() {
        return this.eDirecionado;
    }

    public void printAllVertices() {
        for (Vertice v : this.vertices) {
            v.print();
        }
    }

    public boolean verificarAresta(Vertice v1, Vertice v2) {
        ArrayList<Aresta> arestas = v1.getArestas();
        for (Aresta a : arestas)
            if (a.getEnd() == v2)
                return true;
        return false;
    }

    public void printAdjListDeUmVertice(Vertice v) {
        for (Aresta a : v.getArestas()) {
            System.out.println(a.getStart().getData() + "==>" + a.getEnd().getData() + "  |  Tempo: " + a.getTempo());
        }
    }

}
