import java.io.*
import java.math.BigInteger
import java.util.*


fun main(args: Array<String>) {
    val t=readLine()!!.toInt()
    repeat(t){
        val (n,a)= readLine()!!.split(' ').map { it.toLong() }
        //println(n-n%a)
       var b=a
        var min=Long.MAX_VALUE
        for (i in n downTo  a){
            val l=gcdThing(i,a)
            if (a*i/l>a*b/min){
                min=l
                b=i
            }
            if (l==1L)
                break

        }
        println(b)


    }

}
private fun gcdThing(a: Long, b: Long): Long {
    val b1 = BigInteger.valueOf(a)
    val b2 = BigInteger.valueOf(b)
    val gcd = b1.gcd(b2)
    return gcd.toLong()
}