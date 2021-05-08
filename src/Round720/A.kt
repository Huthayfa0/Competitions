package Round720

fun main() {
    val t= readLine()!!.toInt()
    repeat(t){
        val (a,b)= readLine()!!.split(" ").map { it.toLong() }
        if (b==1L) println("No")
        else if (b==2L){
            println("Yes")
            println("$a ${a*3} ${a*4}")
        }
        else{
            println("Yes")
            println("$a ${a*(b-1)} ${a*b}")
        }
    }
}