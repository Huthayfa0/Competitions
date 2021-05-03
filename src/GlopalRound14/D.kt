package GlopalRound14

import java.util.*
import kotlin.math.abs


fun main() {
    repeat(readLine()!!.toInt()){
        val (n,l,r)= readLine()!!.split(" ").map { it.toInt() }
        val socks=readLine()!!.split(" ").map { it.toInt() }
        val colors=IntArray(n+1)
        for (i in 0 until l)
            colors[socks[i]]++
        for (i in l until n)
            colors[socks[i]]--
        val pr=PriorityQueue<Int>()
        if (l>r){
            for (i in colors.indices){

                pr.add(-colors[i])
            }
        }else{
            for (i in colors.indices){
                pr.add(colors[i])
            }
        }

        repeat(abs(r-l)/2){
            pr.add(pr.poll()+2)
        }

        println(abs(r-l)/2+ pr.sumBy { abs(it) } /2)
    }
}