import java.io.*
import java.util.*


fun main(args: Array<String>) {
    val T=readLine()!!.toInt()
    repeat(T){
        val (n,k)= readLine()!!.split(' ').map{it.toInt()}
        val arr= readLine()!!.split(' ').map { it.toInt() }
        val s=2*k+1
        var sum=0
        for (i in 0 until s){
            if (i>=n)
                break
            sum+=arr[i]
        }
        var max=sum
        for (i in s until n){
            sum+=arr[i]
            sum-=arr[i-s]
            max= kotlin.math.max(sum,max)
        }
        println(max)

    }

}