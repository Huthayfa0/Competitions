package EduRound108

import java.math.BigInteger

fun main() {
    val n= readLine()!!.toInt()
    val change= readLine()!!.split(" ").map { it.toLong() }
    val arr=readLine()!!.split(" ").map { it.toLong() }
    println(solve(change,arr).max(solve(change.reversed(),arr.reversed())))
}

fun solve(change: List<Long>, arr: List<Long>): BigInteger {
 val fixed=Array<BigInteger>( arr.size){ BigInteger.ZERO}
    fixed[0]= BigInteger.valueOf(change[0]).multiply(BigInteger.valueOf(arr[0]))
 for (i in 1 until arr.size){
     fixed[i]=BigInteger.valueOf(change[i]).multiply(BigInteger.valueOf(arr[i])).add(fixed[i-1])
 }
    var maximum=fixed[arr.size-1]
    val after=Array(arr.size){
        val x=Array<BigInteger>( it+1){ BigInteger.ZERO}
        x[0]= BigInteger.valueOf(change[it]).multiply(BigInteger.valueOf(arr[0]))
        for (i in 1..it){
            x[i]=BigInteger.valueOf(change[it-i]).multiply(BigInteger.valueOf(arr[i])).add(x[i-1])
        }
        return@Array x
    }
    after.forEach {
        for (i in 0 until it.size/2){
            val ch=fixed[fixed.size-1].subtract(fixed[it.size-i-1]).add(if (i!=0)fixed[i-1]else  BigInteger.ZERO)
                .add(it[it.size-i-1]).subtract(if (i!=0||it.size-i-1==i)it[i-1]else BigInteger.ZERO)
            maximum=maximum.max(ch)
        }
    }
    return maximum
}
