package com.test

import com.test.calculate.calculatepath
import com.test.myworld.worldgraph

fun main() {
    val wg = worldgraph()
    for (i in wg.getData().indices) {
        for (j in wg.getData().indices) {
            if (i == 0 || j == 0) {
                print(wg.getData()[i][j].padEnd(20, ' '))
            } else {
                val maxdata: String
                if (wg.matrix[i - 1][j - 1] == Integer.MAX_VALUE.toDouble()) {
                    maxdata = "MAX"
                } else {
                    maxdata = wg.matrix[i - 1][j - 1].toString()
                }
                print(maxdata.padEnd(20, ' '))
            }
        }
        print("\r\n\r\n")
    }
    println(calculatepath.shortestPathDijstra(wg.matrix, 2, 5)!!.cost)
}