import java.io.File
import java.io.PrintWriter
import java.util.*

//RotateArray MergeSort FirstSearch ShoretestPath
//MinimumSpanningTree Primes Permutations
//Combinations BinarySearchTechs ComplexAndGeometry
private val scanner=Scanner(File("src/main/kotlin/weak_typing_chapter_2_input.txt"))
private val out=PrintWriter(File("src/main/kotlin/weak_typing_chapter_2_output.txt"))
private fun pt(str:String)=out.println(str)
fun main() {
    val t=readlnInt()
    repeat(t){
        val n=readlnInt()
        val str=readln()
        val be=IntArray(n)
        var count=0
        while (str[count]=='F'){
            be[count]=-1
            count++
            if (count==n)
                break
        }
        if (count==n) {
            pt("Case #${it+1}: 0")
            return@repeat
        }
        val arr=IntArray(n)
        var x=count
        be[x]=x
        var cur=str[count]=='O'
        count++
        while (count<n){
            if (str[count]!='F'){
                x=count
            }
            be[count]=x
            arr[count]=arr[count-1]
            if (str[count]=='X'&&cur){
                arr[count]++
                cur=false
            }
            if (str[count]=='O'&&!cur){
                arr[count]++
                cur=true
            }
            count++
        }
        val af=IntArray(n)
        count=-1
        for (i in (n-1) downTo 0){
            if (str[i]!='F'){
                count=i
            }
            af[i]=count
        }
        fun cal (i:Int,j:Int):Long{
            if (af[i] == -1)
                return arr[j].toLong()-arr[i]
            else
                return if (af[i]>j) 0 else arr[j].toLong()-arr[af[i]]

        }
        val mod=1000000007
        var ans=0L
        for (i in 0 until (n-1)){
            for (j in (i+1) until n){
                ans+=cal(i,j)
            }
        }
        pt("Case #${it+1}: ${ans%mod}")
    }
    out.close()
}

//Scanner code, if wanted to read from file just change the first
private fun readln() = scanner.nextLine()
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
