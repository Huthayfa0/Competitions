package Round708

import kotlin.math.ceil
import kotlin.math.sqrt

fun gcd(a: Long, b: Long): Long = if (b == 0L) a else gcd(b, a % b)

val primes= mutableListOf(3L)
var max=3L
fun prepare(n:Long){
    val l=ceil(sqrt(n.toDouble())).toLong()
   for (ma in max..l ) {
       var flag=true
       primes.forEach {if (ma%it==0L)
           flag=false}
       if (flag)primes.add(ma)
}
    if (l>max) max= l
    if (n>max) {


    var flag=true
    primes.forEach {if (n%it==0L)
        flag=false}
    if (flag)primes.add(n)}


}
fun main(){
    val x=HashMap<Long,List<Long>>()
    val t= readLine()!!.toInt()
    repeat(t) {
        val (n, k) = readLine()!!.split(' ').map { it.toLong() }
        prepare(n)

        for (ma in primes.size-1 downTo 0)
            if (n% primes[ma]==0L){
                if (x[primes[ma]]==null){
                    val f= primes[ma]
                    if (f>=k){
                val set= mutableListOf<Long>()
       big@
       for (i in (f+1)/2-1 downTo 1){
           for (j in f-i-1 downTo 1){
               val gc1=j*(f-i-j)/gcd(j,f-i-j)
               val gc2=i*gc1/gcd(i,gc1)
               if (gc2<=f/2){
                   set.add(i)
                   set.add(j)
                   set.add(f-i-j)
                   break@big
           }}

       }
       x[f] = set
       }
                }
                val s=n/ primes[ma]
                x[primes[ma]]!!.forEach { print("${it*s} ") }
                println()
            }

    }
}