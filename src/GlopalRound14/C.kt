package GlopalRound14

import kotlin.math.abs
import kotlin.math.min as minI

fun main() {
    val t= readLine()!!.toInt()
    repeat(t) {
        val (n, m, x)= readLine()!!.split(" ").map { it.toInt() }
        val h=readLine()!!.split(" ").map { it.toInt() }
        val ans=IntArray(n)
        val br=IntArray(m)
        val segment=SegmentTree(br)
        for (i in h.indices){
            val vv=segment.min()
            var v=0
            for (ii in br.indices){
                if (br[ii]==vv){
                    v=ii
                    break
                }
            }
            segment.update(v,br[v]+h[i])
            ans[i]=v
        }
        var bool=false
        for (i in 1 until br.size){
            if (abs(br[i]-br[i-1])>x){
                bool=true
                break
            }
        }
        if (bool) println("No")
        else{
            println("Yes")
            println(ans.joinToString(separator = " "){z->return@joinToString ((z+1).toString())})
        }
    }
}

/**
 * A segment tree is a binary tree such that the nodes on the bottom level of the
tree correspond to the array elements, and the other nodes contain information
needed for processing range queries.
 */
class SegmentTree(var array: IntArray) {
    private var minReady = false
    private var maxReady = false
    private lateinit var minTree: IntArray
    private lateinit var maxTree: IntArray
    private var halfSize = 0

    init {
        var x = array.size
        x--
        x = x or (x shr 1)
        x = x or (x shr 2)
        x = x or (x shr 4)
        x = x or (x shr 8)
        x = x or (x shr 16)
        x++
        halfSize = x

    }

    private fun minEvaluate() {
        minTree = IntArray(halfSize * 2)
        for (i in array.indices) {
            minTree[i + halfSize] = array[i]
        }
        for (i in halfSize - 1 downTo 0) {
            minTree[i] = minI(minTree[i * 2], minTree[i * 2 + 1])
        }
        minReady=true
    }

    fun min(start: Int = 0, end: Int = array.size-1): Int {
        if (!minReady) minEvaluate()

        var l = start + halfSize
        var r = end + halfSize
        var ans = Int.MAX_VALUE
        while (l <= r) {
            if (l and 1 == 1) ans = minI(ans, minTree[l++])
            if (r and 1 == 0) ans = minI(ans, minTree[r--])
            l = l shr 1
            r = r shr 1
        }
        return ans

    }

    fun update(k: Int, x: Int) {

            if (maxReady) {
                var index = k + halfSize
                maxTree[index] = x
                index = index shr 1
                while (maxTree[index] < x) {
                    maxTree[index] = x
                    index = index shr 1
                    if (index == 0) break
                }
            }
            array[k] = x

            if (minReady) {
                var index = k + halfSize
                minTree[index] = x
                index = index shr 1
                while (true) {
                    minTree[index] = minI(minTree[index*2 ],minTree[index*2 +1])
                    index = index shr 1
                    if (index == 0) break
                }
            }
            array[k] = x
        }


}
