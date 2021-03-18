package EduRound106

import java.lang.Integer.max
import kotlin.math.abs
import kotlin.math.min

fun main(){
    val t= readLine()!!.toInt()
    repeat(t){
        val (n,k1,k2)= readLine()!!.split(' ').map { it.toInt() }
        val (w,b)= readLine()!!.split(' ').map { it.toInt() }
        val placeAbleW= min(k1,k2)+(abs(k1-k2)/2)
        val placeAbleB= n-max(k1,k2)+(abs(k1-k2)/2)
        println(if (placeAbleB>=b &&placeAbleW>=w)"Yes" else "No" )
    }
}