package graph;

import java.util.*;

public class TemporalPath {
    List<Aresta> edges;
    private Vertice init, end;
    private int duration, length, initTime, endTime;

    public TemporalPath(List<Aresta> edges, Vertice init, Vertice end, int duration, int length, int initTime,
            int endTime) {
        this.edges = edges;
        this.init = init;
        this.end = end;
        this.duration = duration;
        this.length = length;
        this.initTime = initTime;
        this.endTime = endTime;
    }

    public void printPath() {
        System.out.println("|Todas as arestas do caminho|");
        edges.forEach(e -> System.out.println(e.getStart().getData() + " ==> " + e.getEnd().getData()));
        System.out.println("Começo do caminho: " + init.getData() + "     Fim do caminho: " + end.getData());

        System.out.println(
                "Duração: " + this.duration + "\nTamanho: " + this.length + "\nTempo de inicio: " + this.initTime
                        + "\nTempo final: " + this.endTime + "\n\n");

    }

    public TemporalPath concatPath(TemporalPath q) {
        List<Aresta> edges = new ArrayList<Aresta>();

        edges.addAll(this.edges);
        edges.addAll(q.getEdges());

        Aresta arestaInicial = edges.get(0);
        Aresta arestaFinal = edges.get(edges.size() - 1);

        int duration = arestaFinal.getTempo() - arestaInicial.getTempo();
        int length = edges.size();
        int initTime = arestaInicial.getTempo();
        int endTime = arestaFinal.getTempo();

        Vertice initV = arestaInicial.getStart();
        Vertice endV = arestaFinal.getEnd();

        TemporalPath r = new TemporalPath(edges, initV, endV, duration, length, initTime, endTime);

        return r;
    }

    public void setEdges(ArrayList<Aresta> edges) {
        this.edges = edges;
    }

    public void setInitVertice(Vertice v) {
        this.init = v;
    }

    public void setEndVertice(Vertice v) {
        this.init = v;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setInitTime(int time) {
        this.initTime = time;
    }

    public int getDuration() {
        return duration;
    }

    public void setEndTime(int time) {
        this.endTime = time;
    }

    public int getLength() {
        return length;
    }

    public Vertice getInit() {
        return init;
    }

    public Vertice getEnd() {
        return end;
    }

    public int getInitTime() {
        return initTime;
    }

    public int getEndTime() {
        return initTime;
    }

    public List<Aresta> getEdges() {
        return this.edges;
    }
}
