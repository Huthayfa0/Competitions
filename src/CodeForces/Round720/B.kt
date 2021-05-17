package Round720

fun main() {
    val t= readLine()!!.toInt()
    repeat(t){
        val n= readLine()!!.toInt()
        val arr=readLine()!!.split(" ").map { it.toInt() }
        for (i in 0 until arr.size-1){
            if (arr[i]<=arr[i+1]){
                if (gcd(arr[i],arr[i+1])!=1){
                    println("${i+1} ${i+2} ${arr[i]+1} ")
                }
            }
        }
    }
}
fun gcd(n1: Int, n2: Int):Int=
    if (n2 != 0)
         gcd(n2, n1 % n2)
    else
         n1