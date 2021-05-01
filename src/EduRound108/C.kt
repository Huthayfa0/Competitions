package EduRound108

import kotlin.collections.ArrayList

fun main() {
    val t= readLine()!!.toInt()
    repeat(t){
        val n= readLine()!!.toInt()

        val U= readLine()!!.split(' ').map { it.toInt() }
        val S=readLine()!!.split(' ').map { it.toLong() }
        val arr=Array(n+1) { ArrayList<Long>() }
        U.forEachIndexed { index, x -> arr[x].add(S[index]) }

        val queries=ArrayList<SumArrayQuerie>()
        arr.forEach { x-> if (x.size>0) {x.sort()
            queries.add(SumArrayQuerie(x))
        } }
        queries.sortByDescending { t->t.array.size }
        val sum=LongArray(n+1)
        for (i in 1..n){
            for (x in queries){
                if (x.array.size<i)break;
                sum[i]+=x.sum(x.array.size%i)
            }
            if (sum[i]==0L)break

        }
        println(sum.drop(1).joinToString(separator = " "))
    }
}

class SumArrayQuerie(val array: ArrayList<Long>) {
    private var sumReady = false
    private val sumArray = LongArray(array.size+1)


    //O(n)
    private fun sumEvaluate() {
        var sum = 0L
        for (i in array.indices) {
            sum += array[i]
            sumArray[i+1] = sum
        }
        sumReady = true
    }

    //O(1)
    fun sum(start: Int = 0, end: Int = array.size): Long {
        if (!sumReady) sumEvaluate()
        return  sumArray[end ] - sumArray[start ]

    }
}