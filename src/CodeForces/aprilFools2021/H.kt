package CodeForces.aprilFools2021

fun main() {
    do{
        val str= readLine()!!.split(' ').map { it.toInt(16).toChar() }
        println(str)
    }while (true)
}