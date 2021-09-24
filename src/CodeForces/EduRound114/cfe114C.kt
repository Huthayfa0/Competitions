import java.util.*
import kotlin.math.*

//RotateArray MergeSort FirstSearch ShoretestPath
//MinimumSpanningTree Primes Permutations
//Combinations BinarySearchTechs ComplexAndGeometry 
fun main() {
    val n=readlnInt()
    val arr=mergeSort(readlnLongs())

    val sum=arr.sum()
    val t=readlnInt()
    val pairs=Array(t){
        readlnLongs()
    }
    repeat(t){
        val (x,y)=pairs[it]
        val i=BSfindFirst(0,n-1,x){t->arr[t]}
        if (x==arr[i]){
            println(max(y-(sum-x),0))
        }else{
            if (i==0)
                println(max(y-(sum-arr[0]),0))
            else
                println(min(max(y-(sum-arr[i]),0)+max(x-arr[i],0),max(y-(sum-arr[i-1]),0)+max(x-arr[i-1],0)))
        }
    }
}
private fun mergeSort(list: List<Long>): List<Long> {
    fun merge(left: List<Long>, right: List<Long>): List<Long> {
        var indexLeft = 0
        var indexRight = 0
        val newList: MutableList<Long> = mutableListOf()
        while (indexLeft < left.count() && indexRight < right.count()) {
            if (left[indexLeft] <= right[indexRight]) {
                newList.add(left[indexLeft])
                indexLeft++
            } else {
                newList.add(right[indexRight])
                indexRight++
            }
        }
        while (indexLeft < left.size) {
            newList.add(left[indexLeft])
            indexLeft++
        }
        while (indexRight < right.size) {
            newList.add(right[indexRight])
            indexRight++
        }
        return newList
    }
    if (list.size <= 1) {
        return list
    }
    val middle = list.size / 2
    val left = list.subList(0, middle)
    val right = list.subList(middle, list.size)
    return merge(mergeSort(left), mergeSort(right))
}

private fun BSfindFirst(start: Int, end: Int, x: Long, f: (Int) -> Long): Int {
    var s = start
    var e = end
    while (s+1 < e) {
        val mid = s + (e - s) / 2
        if (f(mid) < x) s = mid + 1
        else e = mid
    }
    return if (f(s)>=x) s else e
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
