package kotlinHeroesEp6

fun main(){
    val n= readLine()!!.toInt()
    val cost= readLine()!!.split(' ').map { it.toInt() }
    val q= readLine()!!.toInt()
    repeat(q-1){
        val (l,r)= readLine()!!.split(" ").map { it.toInt() }
        print(solve(l-1,r-1,cost))
        print(' ')
    }
    val (l,r)= readLine()!!.split(" ").map { it.toInt() }
    println(solve(l-1,r-1,cost))
}

fun solve(l: Int, r: Int, cost: List<Int>): Int {
    var max=cost[r]
    var count=1
    var sum=0
    for (i in r-1 downTo l){
        if (cost[i]>max){
            sum+=count*max
            count=1
            max=cost[i]
        }
        else
            count++
    }
    sum+=count*max
    return sum

}
