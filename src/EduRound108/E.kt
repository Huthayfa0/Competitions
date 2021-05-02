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
    ans4(map,list,array)

    println(list.joinToString(prefix = "${list.size}\n",separator = ""){"${it.first+1} ${it.second+1}\n"})
}

fun ans2(
    list: java.util.ArrayList<Pair<Int, Int>>,
    array: Array<Pair<HashSet<Int>, HashSet<Int>>>
) {
    val sets=array.mapIndexed { index, pair -> Pair(index,pair) }.sortedBy { it.second.first.size+it.second.second.size }
    val visited=HashSet<Int>()
    for (set in sets){

        if (visited.contains(set.first))continue
        val iterator=set.second.first.union(set.second.second).sortedBy { array[it].first.size+array[it].second.size }.iterator()
        if (iterator.hasNext()){
            var y=iterator.next()

            while ((visited.contains(y)||set.first==y)&&iterator.hasNext()){
                y=iterator.next()
            }
            if (visited.contains(y)||set.first==y)continue
            list.add(Pair(y,set.first))
            visited.add(set.first)
            visited.add(y)
        }

    }
}

fun ans1(
    map: HashMap<Pair<Long, Long>, HashSet<Int>>,
    list: java.util.ArrayList<Pair<Int, Int>>,
    array: Array<Pair<HashSet<Int>, HashSet<Int>>>
) {
    val sets=map.values.sortedByDescending  { it.size }
    val visited=HashSet<Int>()
    for (set in sets){

        if (set.size<2)continue
        val iterator=set.sortedBy { array[it].first.size+array[it].second.size }.iterator()
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

fun ans4(
    map: HashMap<Pair<Long, Long>, HashSet<Int>>,
    list: java.util.ArrayList<Pair<Int, Int>>,
    array: Array<Pair<HashSet<Int>, HashSet<Int>>>
) {
    val sets=PriorityQueue(map.values)

    val visited=HashSet<Int>()
    for (set in sets){

        if (set.size<2)continue
        val iterator=set.sortedBy { array[it].first.size+array[it].second.size }.iterator()
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
            array[x].first.remove(x)
            array[x].second.remove(x)
            array[y].first.remove(y)
            array[y].second.remove(y)
        }

    }
}

fun ans3(
    list: java.util.ArrayList<Pair<Int, Int>>,
    array: Array<Pair<HashSet<Int>, HashSet<Int>>>
) {
    var v=0
    var vs=array[0].first.size+array[0].second.size
    while (vs<3){
        v++
        vs=array[v].first.size+array[v].second.size
    }
    for (i in v until array.size){
        val vss=array[i].first.size+array[i].second.size
        if (vss in 3 until vs){
            v=i
            vs=vss
        }
    }
    val visited=BooleanArray(array.size)
    val parent=IntArray(array.size){-1}
    val searchOrder=ArrayList<Int>()
    dfs(v,parent,searchOrder,visited,array)
    val searchTree=SearchTree(v,parent,searchOrder)
    searchTree.printTree()
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
 class SearchTree(
    /** Return the root of the tree  */
    val root // The root of the tree
    : Int, // Store the parent of each vertex
    private var parent: IntArray,
    val searchOrder: List<Int>
) {


    /** Return the parent of vertex v  */
    fun getParent(v: Int): Int {
        return parent[v]
    }

    /** Return number of vertices found  */
    fun getNumberOfVerticesFound(): Int {
        return searchOrder.size
    }

    /** Return the path of vertices from a vertex to the root  */
    fun getPath(index: Int): List<Int> {
        var i = index
        val path = java.util.ArrayList<Int>()
        do {
            path.add(i)
            i = parent[i]
        } while (i != -1)
        return path
    }

    /** Print a path from the root to vertex v  */
    fun printPath(index: Int) {
        val path = getPath(index)
        println(
            "A path from " + root + " to " +
                    root + ": " + path.reversed().joinToString()
        )

    }

    /** Print the whole tree  */
    fun printTree() {
        println("Root is: " + root)
        print("Edges: ")
        for (i in parent.indices) {
            if (parent[i] != -1) {
                // Display an edge
                print(
                    ("(" +parent[i]+ ", " +
                            i + ") ")
                )
            }
        }
        println()
    }

}
/*
 a = xa ,ya => a/b, c/d
 xs =xa+1, ya=> a/b+1,c/d
 ms=ya/xa+1
 ms = (c/d)/((a+b)/b)
ms = c*b/((a+b)*d)
{c*b,(a+b)*d}
3,4 , gcd=1 => 3,4
12,16 , gcd=4 => 3,4

 */
