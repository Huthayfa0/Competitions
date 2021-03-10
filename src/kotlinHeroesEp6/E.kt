package kotlinHeroesEp6

fun main(){
    var t= readLine()!!.toInt()
    while (t-->0){
        val n=readLine()!!.toInt()
        val arr=readLine()!!.split(" ").map { it.toInt() }
        if (isPalindromic(arr))
            println(arr.size)
        else{

        }
    }
}
fun isPalindromic(arr: List<Int>): Boolean {
    for (i in 0..arr.size/2)
        if (arr[i]!=arr[arr.size-i-1])
            return false
    return true
}