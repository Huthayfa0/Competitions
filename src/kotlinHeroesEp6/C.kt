package kotlinHeroesEp6

import kotlin.math.max
import kotlin.math.min

fun main(){
    var t= readLine()!!.toInt()
    while (t-->0){
        var (n,x,y)= readLine()!!.split(" ").map { it.toInt() }
        if (x>y) x=y.also { y=x }
        val delta= y-x-1
        if (delta==0) println(max(n-y,x-1))
        else{
            var k=Int.MAX_VALUE
            for (i in 0..delta)
                k= min(k,max(n-y+i+ min(n-y,i),x-1+delta-i+ min(x-1,delta-i)))
            println(k)
        }

    }
}