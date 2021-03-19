package EduRound106


fun main(){
    val t= readLine()!!.toInt()
    repeat(t){
        val n= readLine()!!.toInt()
        val arr= readLine()!!.split(" ").map { it.toLong() }
        val ups=LongArray(n/2)
        val rights=LongArray(n/2)
        for (i in 0 until n/2 ){
            ups[i]=arr[i*2]
            rights[i]=arr[i*2+1]
        }

        val upMin=min(ups)
        val upRight=min(rights)
        var sum=0L
        for (i in 0..upMin.second){
            sum+=ups[i]
        }
        for (i in 0..upRight.second){
            //sum+=rightsre[i]
        }
    }
}

fun min(arr: LongArray): Pair<Long,Int> {
    var a=Pair(Long.MAX_VALUE,-1)
    for (i in arr.indices)
        if (arr[i]<a.first)
            a=Pair(arr[i],i)
    return a

}
