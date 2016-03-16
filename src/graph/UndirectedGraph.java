/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author gaetan
 */
public class UndirectedGraph implements IUndirectedGraph {

    private final Graph graph;
    
    public UndirectedGraph(){
        graph = new Graph();
    }
    
    @Override
    public void addEdge(Node _node1, Node _node2) {
        graph.addArc(new Arc(_node1, _node2, null));
    }

    @Override
    public boolean hasEdge(Node _node1, Node _node2) {
        return graph.hasArc(_node1, _node2);
    }

    @Override
    public void addNode(Node _node) {
        graph.addNode(_node);
    }

    @Override
    public List<Node> getAllNodes() {
        return graph.getAllNodes();
    }

    @Override
    public int getNbNodes() {
        return graph.getNbNodes();
    }

    @Override
    public List<Node> getAdjNodes(Node _n) {
        return graph.getAdjNodes(_n);
    }

    @Override
    public Iterator<Node> creerBFSIterator(Node n) {
        BFSIterator iterator = new BFSIterator(n, this);
        return iterator;
    }
    
    @Override
    public String toString(){
        String s = new String();
        for(Node node : graph.getAllNodes()) {
            s += "[noeud=" + node.toString() + " : [";
            for(Arc a : graph.getArc(node)) {
                s += a.toString() + ", ";
            }
            s += "]" + "\n";
        }
        return s;
    }

    @Override
    public Iterator<Node> creerDFSIterator(Node n) {
        DFSIterator iterator = new DFSIterator(n, this);
        return iterator;
    }
    
}
