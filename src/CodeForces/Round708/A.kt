package Round708

fun main(){
    val t= readLine()!!.toInt()
    repeat(t){
        val n= readLine()!!.toInt()
        val arr= readLine()!!.split(" ").map { it.toInt() }
        val x=IntArray(101){0}
        arr.forEach { x[it]++ }
        for (i in 0..100)
            if (x[i]>0)
                print("$i ")
        for (i in 0..100)
            while (x[i]>1){
                print("$i ")
                x[i]--
            }
        println()
    }
}