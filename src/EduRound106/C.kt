package EduRound106


fun main(){
    val t= readLine()!!.toInt()
    repeat(t){
        val n= readLine()!!.toInt()
        val arr= readLine()!!.split(" ").map { it.toLong() }
        val ups=LongArray((n+1)/2)
        val rights=LongArray(n/2)
        for (i in 0 until n/2 ){
            ups[i]=arr[i*2]
            rights[i]=arr[i*2+1]
        }
        if (n%2==1) ups[n/2]=arr[n-1]
        val upMin=min(ups)
        val upRight=min(rights)

    }
}

fun min(arr: LongArray): Pair<Long,Int> {
    var a=Pair(Long.MAX_VALUE,-1)
    for (i in arr.indices)
        if (arr[i]<a.first)
            a=Pair(arr[i],i)
    return a

}
