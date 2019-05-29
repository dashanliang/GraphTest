package com.test.calculate;


import com.test.data.Node;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class calculateKpath {

    /*
    main logic
     */
    public List ck(double[][] data, int fromccy, int toccy, int k) {
        if (k <= 0) {
            return null;
        }

        Comparator<Node> queueComparator = new NodeComparator();
        PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>(128,
                queueComparator);

        List<Node> result = new ArrayList<Node>();
        //first path
        Node node = calculatepath.shortestPathDijstra(data, fromccy, toccy);

        priorityQueue.add(node);

        for(int i = 1 ; i <= k ; i ++){
            Node firstNode = priorityQueue.remove();
            result.add(firstNode);
            for(Node eachNode : getNextLevel(firstNode)){
                priorityQueue.add(calculatepath.shortestPathDijstra(eachNode.getDataGraph(), fromccy, toccy));
            }
        }

        return result;
    }

    class NodeComparator implements Comparator<Node> {


        public int compare(Node o1, Node o2) {
            if (Double.valueOf(o1.getCost()) < Double.valueOf(o2.getCost())){
                return -1 ;
            }
            if (Double.valueOf(o1.getCost()) > Double.valueOf(o2.getCost())){
                return 1 ;
            }
            return 0;
        }
    }

    public Node[] getNextLevel(Node node){
        return null;
    }

}