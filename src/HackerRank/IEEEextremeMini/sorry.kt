import java.lang.Exception
import java.util.*
import kotlin.math.*

//RotateArray MergeSort FirstSearch ShoretestPath
//MinimumSpanningTree Primes Permutations
//Combinations BinarySearchTechs ComplexAndGeometry 
fun main() {
try{
    val (n,m,q)=readlnInts()
    val map= mutableMapOf<String,Int>()
    val lang= mutableMapOf<String,Int>()
    var count=1
    repeat(n){
        val (l,s)=readlnStrings()
        if (!lang.containsKey(l)){
            lang[l] = count
            count++
        }
        map.put(s,lang[l]?:0)
    }

    val edges=List(m){
        readlnStrings().map { lang[it]?:count++ }
    }
    val rank = IntArray(count+1)
    val parent = IntArray(count+1)
    fun getSet(i: Int, parent: IntArray): Int {

        return if (parent[i] == i) i else getSet(parent[i], parent).also { parent[i] = it }

    }

    fun kruskal(size: Int, edges: List<List<Int>>) {

        fun unionSets(i: Int, j: Int, ranks: IntArray, parent: IntArray): Boolean {
            val ii = getSet(i, parent)
            val jj = getSet(j, parent)
            if (ii != jj) {
                if (ranks[ii] > ranks[jj]) {
                    parent[jj] = ii
                } else if (ranks[jj] > ranks[ii]) {
                    parent[ii] = jj
                } else {
                    parent[ii] = jj
                    ranks[jj]++
                }
                return true
            }
            return false
        }


        for (i in 1 until size) {
            parent[i] = i
        }
        for (e in edges) {
            unionSets(e[0], e[1], rank, parent)
        }

    }
    kruskal(count,edges)

    repeat(q){
        val (l,s)=readlnStrings()
        val ll=lang[l]
        val ss=map[s]
        if (ss==null||ll==null)
            println("NO")
        else{
            if (getSet(ss,parent)==getSet(ll,parent))
                println("YES")
            else
                println("NO")
        }
    }
}catch (e:Exception){

}

}


//Scanner code, if wanted to read from file just change the first
private fun readln() = readLine()!!
private fun readlnInt() = readln().toInt()
private fun readlnLong() = readln().toLong()
private fun readlnDouble() = readln().toDouble()
private fun readlnBigInt(radix: Int = 10) = readln().toBigInteger(radix)
private fun readlnBigDecimal() = readln().toBigDecimal()
private fun lineSequence(limit: Int = Int.MAX_VALUE) = generateSequence { readLine() }.constrainOnce().take(limit)
private fun readlnStrings() = readln().split(' ')
private fun readlnInts() = readlnStrings().map { it.toInt() }
private fun readlnLongs() = readlnStrings().map { it.toLong() }
private fun readlnDoubles() = readlnStrings().map { it.toDouble() }
private fun readIntArray() = readlnStrings().run { IntArray(size) { get(it).toInt() } }
private fun readLongArray() = readlnStrings().run { LongArray(size) { get(it).toLong() } }
private fun readDoubleArray() = readlnStrings().run { DoubleArray(size) { get(it).toDouble() } }
private fun readlnIntArray(n: Int) = IntArray(n) { readlnInt() }
private fun readlnLongArray(n: Int) = LongArray(n) { readlnLong() }
private fun readlnDoubleArray(n: Int) = DoubleArray(n) { readlnDouble() }
private fun readLongArray2d(rows: Int, cols: Int) = Array(rows) { readLongArray().also { require(it.size == cols) } }
private fun readIntArray2d(rows: Int, cols: Int) = Array(rows) { readIntArray().also { require(it.size == cols) } }
private fun readDoubleArray2d(rows: Int, cols: Int) =
    Array(rows) { readDoubleArray().also { require(it.size == cols) } }

private fun isWhiteSpace(c: Char) = c in " \r\n\t"

// JVM-only targeting code follows next
// readString() via sequence is still slightly faster than Scanner
private fun readString() = generateSequence { System.`in`.read().toChar() }
    .dropWhile { isWhiteSpace(it) }.takeWhile { !isWhiteSpace(it) }.joinToString("")

private fun readInt() = readString().toInt()
private fun readLong() = readString().toLong()
private fun readDouble() = readString().toDouble()
private fun readBigInt(radix: Int = 10) = readString().toBigInteger(radix)
private fun readBigDecimal() = readString().toBigDecimal()
private fun readInts(n: Int) = generateSequence { readInt() }.take(n)
private fun readLongs(n: Int) = generateSequence { readLong() }.take(n)
private fun readDoubles(n: Int) = generateSequence { readDouble() }.take(n)
