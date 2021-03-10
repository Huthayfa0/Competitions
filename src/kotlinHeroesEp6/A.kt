package kotlinHeroesEp6

fun main(){
var t= readLine()!!.toInt()
    while (t-->0){
        val (x,y)= readLine()!!.split(" ").map { it.toLong() }
        var n=y%x
        var c=y/x
        while (c>0){
            n+=c%10
            c/=10
        }
        println(n)

    }
}