package Round707

import kotlin.math.abs

fun main() {
    val t = readLine()!!.toInt()
    repeat(t) {
        val n = readLine()!!.toInt()
        val arr = readLine()!!.split(' ').map { it.toInt() }
        val drench = Array(n + 1) { 0 }
        for (i in 0 until n) {
            if (arr[i] > 0) {
                if (arr[i] - 1 > i) {
                    drench[i + 1]--
                    drench[0]++
                } else {
                    drench[i + 1]++
                    drench[i - arr[i] + 1]--
                }
            }
        }
        var z = drench[0]
        if (z<=0) print("0 ") else print("1 ")
        for (i in 1 until n) {
            z+=drench[i]


            if (z==0) {
                print("0 ")
            } else {
                print("1 ")
            }

        }
        println()
    }
}