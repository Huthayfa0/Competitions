package EduRound108

import kotlin.math.abs
import kotlin.math.min

fun main() {
    val t= readLine()!!.toInt()
    repeat(t){
        val (a,b,k)= readLine()!!.split(' ').map { it.toInt() }
        val kk=a-1+a*(b-1)
        println(if (kk!=k)"No" else "Yes" )

    }
}