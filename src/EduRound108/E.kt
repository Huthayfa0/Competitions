package EduRound108

fun main() {
val n= readLine()!!.toInt()
    val points=Array(n){
        readLine()!!.split(" ").map { it.toLong() }
    }

    val map=HashMap<Pair<Long,Long>, HashSet<Int>>()
    for (i in points.indices){
        val (a,b,c,d)=points[i]
        var up=(a+b)*d
        var down=c*b
        var g= gcd(up,down)
        var p=Pair(up/g,down/g)
        map.putIfAbsent(p,HashSet())
        map[p]!!.add(i)
        up=a*d
        down=(c+d)*b
        g= gcd(up,down)
        p=Pair(up/g,down/g)
        map.putIfAbsent(p,HashSet())
        map[p]!!.add(i)
    }

    val list=ArrayList<Pair<Int,Int>>()
    ans(map,list)
    println(list.joinToString(prefix = "${list.size}\n",separator = ""){"${it.first+1} ${it.second+1}\n"})
}

fun ans(map: HashMap<Pair<Long,Long>, HashSet<Int>>, list: java.util.ArrayList<Pair<Int, Int>>) {
    val sets=map.values.sortedByDescending  { it.size }
    val visited=HashSet<Int>()
    for (set in sets){
        if (set.size<2)continue
        val iterator=set.iterator()
        while (iterator.hasNext()){
            val x=iterator.next()
            if (visited.contains(x))continue
            if (!iterator.hasNext())break
            var y=iterator.next()
            while (visited.contains(y)&&iterator.hasNext()){
                y=iterator.next()
            }
            if (visited.contains(y))break
            list.add(Pair(x,y))
            visited.add(x)
            visited.add(y)
        }

    }
}
fun gcd(a: Long, b: Long): Long {
    return if (b == 0L) a else gcd(b, a % b)
}


