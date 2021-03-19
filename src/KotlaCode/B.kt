import java.io.*
import java.util.*
import kotlin.collections.HashSet

fun main(args: Array<String>) {
    val t=readLine()!!.toInt()
    val set=HashSet<Long>(160)
    var x=1L
    while (x<1e10){
        val s=HashSet<Long>(set)
        for (y in s){
            set.add(y+x)
        }
        set.add(x)
        x*=5L
    }
    repeat(t){
        val n=readLine()!!.toLong()
        println(if (set.contains(n)) "YES" else "NO")
    }
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. */
}