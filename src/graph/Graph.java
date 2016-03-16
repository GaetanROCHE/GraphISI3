/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author gaetan
 */
public class Graph implements IDirectedGraph{
    
    private final ArrayList<Node> nodes;
    private final ArrayList<Arc> arcs;
    
    public Graph(){
        this.nodes = new ArrayList<>();
        this.arcs = new ArrayList<>();
    }
    
    @Override
    public boolean hasArc(Node _n1, Node _n2) {
        for (Arc arc : arcs) {
            if((arc.getSource().getID() == _n1.getID() && arc.getDestination().getID() ==_n2.getID()) || (arc.getSource().getID() == _n2.getID() && arc.getDestination().getID() == _n1.getID()))
                return true;
        }
        return false;
    }

    @Override
    public void addArc(Arc _edge) {
        arcs.add(_edge);
    }

    @Override
    public List<Arc> getArc(Node _n) {
        ArrayList<Arc> res;
        res = new ArrayList<>();
        for (Arc arc : arcs) {
            if(arc.getSource().getID() == _n.getID())
                res.add(arc);
        }
        return res;
    }

    @Override
    public void addNode(Node _node) {
        nodes.add(_node);
    }

    @Override
    public List<Node> getAllNodes() {
        return nodes;
    }

    @Override
    public int getNbNodes() {
        return nodes.size();
    }

    @Override
    public List<Node> getAdjNodes(Node _n) {
        ArrayList<Node> res;
        res = new ArrayList<>();
        for (Arc arc : arcs) {
            if(arc.getSource().getID() == _n.getID())
                res.add(arc.getDestination());
        }
        return res;
    }
    
    
    @Override
    public String toString(){
        String s = new String();
        for(Node node : nodes) {
            s += "[noeud=" + node.toString() + " : [";
            for(Arc a : this.getArc(node)) {
                s += a.toString() + ", ";
            }
            s += "]" + "\n";
        }
        return s;
    }

    @Override
    public Iterator<Node> creerBFSIterator(Node n) {
        BFSIterator iterator = new BFSIterator(n, this);
        return iterator;
    }

    @Override
    public Iterator<Node> creerDFSIterator(Node n) {
        DFSIterator iterator = new DFSIterator(n, this);
        return iterator;
    }
    
}
