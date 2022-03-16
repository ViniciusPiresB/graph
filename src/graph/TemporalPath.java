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
        System.out.println("Duração: " + this.duration + "\nTamanho: " + length + "\nTempo de inicio: " + initTime
                + "\nTempo final: " + endTime);
    }
}
