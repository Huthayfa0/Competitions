import java.io.*
import java.util.*

fun main(args: Array<String>) {
    val t=readLine()!!.toInt()
    repeat(t){
        val n=readLine()!!.toInt()
        println(if(n>=60)"Danger" else "Fine")
    }
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. */
}