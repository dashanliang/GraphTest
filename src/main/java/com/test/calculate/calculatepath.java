package com.test.calculate;

import com.test.data.Node;

import java.util.ArrayList;
import java.util.List;

public class calculatepath {

    /**
     * 获取一个图的最短路径
     */
    public static Node shortestPathDijstra(double[][] dataGraph, Integer fromccy1, Integer toccy1) {
        Integer fromccy = fromccy1 - 1;
        Integer toccy = toccy1 - 1;

        List<List<String>> steps = new ArrayList<List<String>>();
        double shortTablePath[] = new double[dataGraph.length];// 记录的是v0到某顶点的最短路径和

        double min;
        int k = 0;// 记录下标
        boolean isgetPath[] = new boolean[dataGraph.length];
        for (int v = 0; v < dataGraph.length; v++) {
            shortTablePath[v] = dataGraph[fromccy][v];// 获取v0这一行的权值数组
            List<String> step = new ArrayList<String>();
            step.add(String.valueOf(v));
            steps.add(step);
        }
        shortTablePath[0] = 0;
        isgetPath[0] = true;
        for (int v = 1; v < dataGraph.length; v++) {
            min = Integer.MAX_VALUE;
            for (int w = 0; w < dataGraph.length; w++) {
                if (!isgetPath[w] && shortTablePath[w] < min) {
                    k = w;
                    min = shortTablePath[w];
                }
            }
            isgetPath[k] = true;
            for (int j = 0; j < dataGraph.length; j++) {
                if (!isgetPath[j] && (min + dataGraph[k][j] < shortTablePath[j])) {
                    steps.get(j).clear();
                    steps.get(j).addAll(steps.get(k));
                    steps.get(j).add(String.valueOf(j));
                    shortTablePath[j] = min + dataGraph[k][j];
                }
            }
        }
        if (shortTablePath[toccy] == Integer.MAX_VALUE) {
            return null;
        }
        Node data = new Node();
        String key = String.valueOf(fromccy);
        for (String ss : steps.get(toccy)) {
            key = key + "_" + ss;
        }
        data.setKey(key);
        data.setCost(String.valueOf(shortTablePath[toccy]));
        data.setDataGraph(dataGraph);
        return data;
    }
}
