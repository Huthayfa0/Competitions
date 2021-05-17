package GlopalRound14

import kotlin.math.sqrt

fun main() {
    val t= readLine()!!.toInt()
    repeat(t){
        var n= readLine()!!.toInt()
        if (n and 1 ==1){
            println("No")
        }else {
            while (n and 1 == 0) {
                n = n shr 1
            }
            val x = sqrt(n.toDouble()).toInt()
            println(if (x * x == n) "Yes" else "No")
        }
    }
}