/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author gaetan
 */
public class DFSIterator implements Iterator{

    private ArrayList<Node> covered;
    private ArrayList<Node> nodes;
    private IGraph graph;
    
    public DFSIterator(Node node, IGraph graph){
        nodes = new ArrayList<>();
        nodes.add(node);
        covered = new ArrayList<>();
        covered.add(node);
        this.graph = graph;
    }
    
    @Override
    public boolean hasNext() {
        return !nodes.isEmpty();
    }

    @Override
    public Object next() {
        Node next = nodes.remove(nodes.size()-1);
        for(Node n : graph.getAdjNodes(next)){
            if(!covered.contains(n)){
                nodes.add(n);
                covered.add(n);
            }
        }
        return next;        
    }
    
}
