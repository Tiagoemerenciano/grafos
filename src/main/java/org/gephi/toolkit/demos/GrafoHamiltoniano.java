package org.gephi.toolkit.demos;

import org.gephi.graph.api.DirectedGraph;
import org.gephi.graph.api.Edge;
import org.gephi.graph.api.GraphController;
import org.gephi.graph.api.GraphModel;
import org.gephi.graph.api.Node;
import org.gephi.project.api.ProjectController;
import org.gephi.project.api.Workspace;
import org.openide.util.Lookup;

public class GrafoHamiltoniano {
    
    // Verificação realizando a Condição de Dirac
    // Vértices maior ou igual a 3 e graus maiores ou iguais a n/2
    public static boolean verificaHamilton(DirectedGraph dg, Node v){
        int qtdVertices = dg.getEdgeCount();
        if (qtdVertices >= 3) {
            if (dg.getDegree(v) >= dg.getDegree(v)/2) {
                return true;
            }
        } else {
            return false;
        }
        return false;
    }
    
    public static void main (String[] args){
        
        //===== Configurações Obrigatórias de Projeto ==========================
        ProjectController pc = Lookup.getDefault().lookup(ProjectController.class);
        pc.newProject();
        Workspace workspace = pc.getCurrentWorkspace();
        //======================================================================
                
        GraphModel graphModel;
        graphModel = Lookup.getDefault().lookup(GraphController.class).getGraphModel();
        
        //Criando Vertice - n0
        Node v0 = graphModel.factory().newNode("v0");
        v0.setLabel("Vertice 0");
    
        //Criando Vertice - n1
        Node v1 = graphModel.factory().newNode("v1");
        v1.setLabel("Vertice 1");
        
        //Criando Vertice - n1
        Node v2 = graphModel.factory().newNode("v2");
        v2.setLabel("Vertice 2");
        
        //Criando Vertice - n1
        Node v3 = graphModel.factory().newNode("v3");
        v3.setLabel("Vertice 3");
        
        //Criando Vertice - n1
        Node v4 = graphModel.factory().newNode("v4");
        v4.setLabel("Vertice 4");

        //Criando uma Aresta
        Edge e1 = graphModel.factory().newEdge(v0, v3);
        
        //Criando uma Aresta
        Edge e2 = graphModel.factory().newEdge(v3, v4);
        
        //Criando uma Aresta
        Edge e3 = graphModel.factory().newEdge(v4, v0);
        
        //Criando uma Aresta
        Edge e4 = graphModel.factory().newEdge(v0, v2);
        
        //Criando uma Aresta
        Edge e5 = graphModel.factory().newEdge(v2, v1);
        
        //Criando uma Aresta
        Edge e6 = graphModel.factory().newEdge(v1, v0);

        //Criando um Grado Direcionado
        DirectedGraph directedGraph = graphModel.getDirectedGraph();
        
        //Adicionando Vertices ao Grafo
        directedGraph.addNode(v0);
        directedGraph.addNode(v1);
        directedGraph.addNode(v2);
        directedGraph.addNode(v3);
        directedGraph.addNode(v4);
        
        //Adicionando Arestas ao Grafo
        directedGraph.addEdge(e1);
        directedGraph.addEdge(e2);
        directedGraph.addEdge(e3);
        directedGraph.addEdge(e4);
        directedGraph.addEdge(e5);
        directedGraph.addEdge(e6);
        
        //Lendo propriedades do Grafo // Vertices e Arestas
        System.out.println("Vertices: " + directedGraph.getNodeCount()+
                           " Arestas: " + directedGraph.getEdgeCount());
        
        
        
        String retorno;
        if (!verificaHamilton(directedGraph, v0)) {
            retorno = "O grafo não é hamiltoniano.";
        } else if (!verificaHamilton(directedGraph, v1)) {
            retorno = "O grafo não é hamiltoniano.";
        } else if (!verificaHamilton(directedGraph, v2)) {
            retorno = "O grafo não é hamiltoniano.";
        } else if (!verificaHamilton(directedGraph, v3)) {
            retorno = "O grafo não é hamiltoniano.";
        } else if (!verificaHamilton(directedGraph, v4)) {
            retorno = "O grafo não é hamiltoniano.";
        } else {
            retorno = "\nO grafo é hamiltoniano.\n";
        }
        
        //Lendo o Grau de Saida do Vertice 0
        System.out.println("Grau de Saida do Vértice 0 => " + directedGraph.getOutDegree(v0));
        //Lendo o Grau de Entrada do Vertice 0
        System.out.println("Grau de Entrada do Vértice 0 => " + directedGraph.getInDegree(v0));
        
        //Lendo o Grau de Saida do Vertice 1
        System.out.println("Grau do Saida Vértice 1 => " + directedGraph.getOutDegree(v1));
        
        //Lendo o Grau de Entrada do Vertice 1
        System.out.println("Grau do Entrada Vértice 1 => " + directedGraph.getInDegree(v1));
        
        //Lendo o Grau de Saida do Vertice 2
        System.out.println("Grau de Saida do Vértice 2 => " + directedGraph.getOutDegree(v2));
        
        //Lendo o Grau de Entrada do Vertice 2
        System.out.println("Grau de Entrada do Vértice 2 => " + directedGraph.getInDegree(v2));
        
        //Lendo o Grau de Saida do Vertice 3
        System.out.println("Grau do Saida Vértice 3 => " + directedGraph.getOutDegree(v3));
        
        //Lendo o Grau de Entrada do Vertice 3
        System.out.println("Grau do Entrada Vértice 3 => " + directedGraph.getInDegree(v3));
        
        //Lendo o Grau de Saida do Vertice 4
        System.out.println("Grau do Saida Vértice 4 => " + directedGraph.getOutDegree(v4));
        
        //Lendo o Grau de Entrada do Vertice 4
        System.out.println("Grau do Entrada Vértice 4 => " + directedGraph.getInDegree(v4));
 
        //Percorrendo todas as Arestas
        System.out.println("\nCaminho do circuito percorrido:");
        for(Edge e : directedGraph.getEdges()) {
            System.out.println(e.getSource().getId()+ " -> " +e.getTarget().getId());
        }
    
        System.out.println(retorno);
    }
}
