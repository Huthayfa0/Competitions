package GlopalRound14

import java.util.*
import kotlin.math.abs
import kotlin.math.min as minI

fun main() {
    val t= readLine()!!.toInt()
    repeat(t) {
        val (n, m, x)= readLine()!!.split(" ").map { it.toInt() }
        val h=readLine()!!.split(" ").map { it.toInt() }
        val priorityQueue=PriorityQueue<Array<Int>>(compareBy { it[1] })
        priorityQueue.addAll(List(m){ arrayOf(it+1,0)})
        println("Yes")
        for (i in h.indices){
            val z=priorityQueue.poll()
            z[1]+=h[i]
            print("${z[0]} ")
            priorityQueue.add(z)
        }
        println()
    }
}



