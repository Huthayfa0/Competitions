package Round706

import java.util.Collections.max


fun main(){
    val t= readLine()!!.toInt()
    repeat(t){
        val (n,k)= readLine()!!.split(' ').map { it.toLong() }
        var count =n
        val lset= readLine()!!.split(' ').map { it.toLong() }.toMutableSet()
        var b= max(lset)
        var a=b+1
            for (i in 0..b)
                if (!lset.contains(i)){
                    a=i
                    break
                }

        for (z in 1..k){
            val x=(a+b)/2+(a+b)%2
            if (lset.add(x)){
                if (x>b) b=x
                if (x==a){
                for (i in (a+1)..b)
                    if (!lset.contains(i)){
                        a=i
                        break
                    }
                if (x==a) a=b+1}
                count++
            }


        }
        println(count)
    }
}