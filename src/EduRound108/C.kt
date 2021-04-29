package EduRound108

import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val t= readLine()!!.toInt()
    repeat(t){
        val n= readLine()!!.toInt()

        val U= readLine()!!.split(' ').map { it.toInt() }
        val S=readLine()!!.split(' ').map { it.toInt() }
        val arr=Array<ArrayList<Int>>(n+1) { ArrayList<Int>() }
        U.forEachIndexed { index, x -> arr[x].add(S[index]) }
        val queries=ArrayList<SumArrayQuerie>()
        arr.forEach { x-> if (x.size>0) {x.sort()
            queries.add(SumArrayQuerie(x))
        } }
        for (i in 1..n){
            var sum=0
            for (x in queries){
                sum+=x.sum(x.array.size%i)
            }
            print("$sum ")
        }
        println()
    }
}

class SumArrayQuerie(val array: ArrayList<Int>) {
    private var sumReady = false
    private val sumArray = IntArray(array.size)


    //O(n)
    private fun sumEvaluate() {
        var sum = 0
        for (i in array.indices) {
            sum += array[i]
            sumArray[i] = sum
        }
        sumReady = true
    }

    //O(1)
    fun sum(start: Int = 0, end: Int = array.size): Int {
        if (!sumReady) sumEvaluate()
        return when {
            start < 0 && end > array.size -> sum()
            start < 0 -> sum(end = end)
            end > array.size -> sum(start = start)
            end <= start -> 0
            start == 0 -> sumArray[end - 1]
            else -> sumArray[end - 1] - sumArray[start - 1]
        }
    }
}