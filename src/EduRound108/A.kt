package EduRound108

import kotlin.math.*

fun main() {
val t= readLine()!!.toInt()
    repeat(t){
        val (r,b,d)= readLine()!!.split(' ').map { it.toInt() }
        val dif= abs(r - b)
        val m= min(r,b)
        println(if (dif/m>d||(dif/m==d&&dif%m>0))"No" else "Yes" )

    }
}