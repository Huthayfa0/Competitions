package EduRound108

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

fun main() {
val n= readLine()!!.toInt()
    val points=Array(n){
        readLine()!!.split(" ").map { it.toLong() }
    }
    val array=Array<Pair<HashSet<Int>,HashSet<Int>>>(n){ Pair(HashSet(), HashSet()) }
    val map=HashMap<Pair<Long,Long>, HashSet<Int>>()
    for (i in points.indices){
        val (a,b,c,d)=points[i] //{a,b,c,d}
        var up=(a+b)*d
        var down=c*b
        var g= gcd(up,down)
        var p=Pair(up/g,down/g)
        map.putIfAbsent(p,HashSet())
        map[p]!!.add(i)
         val first=map[p]!!
        up=a*d
        down=(c+d)*b
        g= gcd(up,down)
        p=Pair(up/g,down/g)
        map.putIfAbsent(p,HashSet())
        map[p]!!.add(i)
        val second=map[p]!!
        array[i]=Pair(first,second)
    }

    val list=ArrayList<Pair<Int,Int>>()

    println(list.joinToString(prefix = "${list.size}\n",separator = ""){"${it.first+1} ${it.second+1}\n"})
}

fun dfs(v: Int, parent: IntArray, searchOrder: MutableList<Int>, isVisited: BooleanArray,neighbors:Array<Pair<HashSet<Int>, HashSet<Int>>>) {
    // Store the visited vertex
    searchOrder.add(v)
    isVisited[v] = true // Vertex v visited
    neighbors[v].first.union(neighbors[v].second)
        .forEach { e -> // Note that e.u is v
        if (!isVisited[e]) { // e.v is w in Listing 28.8
            parent[e] = v // The parent of w is v
            dfs(e, parent, searchOrder, isVisited,neighbors) // Recursive search
        }
    }
}
fun gcd(a: Long, b: Long): Long {
    return if (b == 0L) a else gcd(b, a % b)
}

