package EduRound108

import java.math.BigInteger
import kotlin.math.max

fun main() {
    val n= readLine()!!.toInt()
    val change= readLine()!!.split(" ").map { it.toLong() }
    val arr=readLine()!!.split(" ").map { it.toLong() }
    println(max(solve(change,arr),(solve(change.reversed(),arr.reversed()))))
}

fun solve(change: List<Long>, arr: List<Long>): Long {
 val fixed=LongArray( arr.size)
    fixed[0]= change[0]*arr[0]
 for (i in 1 until arr.size){
     fixed[i]=change[i]*arr[i]+fixed[i-1]
 }
    var maximum=fixed[arr.size-1]
    val after=Array(arr.size){
        val x=LongArray( it+1)
        x[0]= change[it]*arr[0]
        for (i in 1..it){
            x[i]=change[it-i]*arr[i]+x[i-1]
        }
        return@Array x
    }
    after.forEach {
        for (i in 0 until it.size/2){
            val ch=fixed[fixed.size-1]-fixed[it.size-i-1]+(if (i!=0)fixed[i-1]else  0L)+
                it[it.size-i-1]-(if (i==0||it.size-i-1==i)0L else it[i-1])
            maximum= max(ch,maximum)
        }
    }
    return maximum
}
