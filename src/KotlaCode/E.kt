import java.io.*
import java.math.BigInteger
import java.util.*


fun main(args: Array<String>) {
    val T=readLine()!!.toInt()
    repeat(T){
        val n= readLine()!!.toInt()
        val str= readLine()!!.reversed().toCharArray()
        var t=0
        var g=0
        var l=0
        var c=0
        var sum=0
        for (i in 0 until n){
            if (str[i]=='T'){
                t++
                sum+=g*l*c
            } else if (str[i]=='C'){
                c++
                sum+=g*l*t
            } else if (str[i]=='G'){
                g++
                sum+=t*l*c
            } else{
                l++
                sum+=g*t*c
            }
        }

        println(sum)

    }

}