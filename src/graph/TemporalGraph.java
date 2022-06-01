package graph;

import java.util.*;

public class TemporalGraph {
    private final ArrayList<Vertice> vertices;
    private final boolean eDirecionado;

    public TemporalGraph(boolean eDirecionado) {
        this.vertices = new ArrayList<>();
        this.eDirecionado = eDirecionado;
    }

    private int retentionTime = 1;
    private int traversalTime = 0;

    public List<TemporalPath> allPairsTemporalPaths() {
        List<TemporalPath> P = new ArrayList<TemporalPath>();

        ArrayList<Aresta> arestas = new ArrayList<>();

        for (Vertice vertice : vertices) {
            arestas.addAll(vertice.getArestas());
        }

        for (Aresta aresta : arestas) {
            List<Aresta> init = new ArrayList<>();
            TemporalPath p = new TemporalPath(init, aresta.getStart(), aresta.getEnd(), 0, 1, aresta.getTempo(),
                    aresta.getTempo());
            p.edges.add(aresta);
            P.add(p);
        }

        int currentPathLength = 1;
        while (true) {
            List<TemporalPath> pTemp = new ArrayList<TemporalPath>();
            currentPathLength++;
            for (TemporalPath p : P) {
                for (TemporalPath q : P) {
                    if (!p.equals(q)) {
                        if ((p.getLength() + q.getLength()) == currentPathLength) {
                            if (p.getEnd().equals(q.getInit())) {
                                if (p.getEndTime() + retentionTime + traversalTime <= q.getInitTime()) {
                                    TemporalPath r = p.concatPath(q);
                                    pTemp.add(r);
                                }
                            }
                        }
                    }
                }
            }
            if (pTemp.isEmpty())
                break;
            else
                P.addAll(pTemp);

        }
        return P;

    }

    public List<TemporalPath> fastestPath(Vertice init, Vertice end, List<TemporalPath> allPaths) {
        List<TemporalPath> completePaths = new ArrayList<>();

        for (TemporalPath path : allPaths)
            if (path.getInit().equals(init) && path.getEnd().equals(end))
                completePaths.add(path);

        int duracaoMin = Integer.MAX_VALUE;

        List<TemporalPath> fastestPath = new ArrayList<>();

        for (TemporalPath path : completePaths) {
            int durationOfPath = path.getDuration();
            if (durationOfPath < duracaoMin) {
                fastestPath.clear();
                duracaoMin = durationOfPath;
                fastestPath.add(path);
            } else if (durationOfPath == duracaoMin)
                fastestPath.add(path);
        }
        return fastestPath;
    }

    public List<TemporalPath> fastestPathOfEachVertex(List<TemporalPath> allPaths) {
        List<TemporalPath> allFastestPaths = new ArrayList<TemporalPath>();
        List<Vertice> allVertex = this.vertices;

        for (Vertice v1 : allVertex)
            for (Vertice v2 : allVertex)
                if (!v1.equals(v2)) {
                    List<TemporalPath> pTemp = fastestPath(v1, v2, allPaths);
                    allFastestPaths.addAll(pTemp);
                }

        return allFastestPaths;
    }

    public float closeness(Vertice init, List<TemporalPath> allFastestPath) {
        float sum = 0;
        for (TemporalPath p : allFastestPath) {
            if (p.getInit().equals(init)) {
                int duration = p.getDuration();
                if (duration != 0)
                    sum = sum + (1 / duration);
            }
        }
        return sum;
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
