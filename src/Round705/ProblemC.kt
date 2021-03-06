package Round705


fun main(){
    var t= readlnInt()
    while (t-->0) {
        val arr = readIntArray()
        val n=arr[0]
        val k=arr[1]

    }
}
private fun readln() = readLine()!!
private fun readlnInt() = readln().toInt()
private fun readlnStrings() = readln().split(' ')
private fun readIntArray() = readlnStrings().run { IntArray(size) { get(it).toInt() } }
