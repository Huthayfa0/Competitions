package aprilFools2021

import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.sqrt

fun main() {
    var x= readLine()!!.toInt()
    while (x>9){
        var s=x%10
        x/=10
        while (x!=0){
            s+=x%10
            x/=10
        }
        x=s
    }
    println(x)
}