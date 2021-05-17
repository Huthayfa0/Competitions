package GlopalRound14

fun main() {
    println(premit((1..4).toMutableList().toIntArray()).joinToString("\n"){it.joinToString()})

}
fun premit(arr:IntArray):ArrayList<ArrayList<Int>>{
    val x =ArrayList<ArrayList<Int>>()
    if (arr.size==1){
        x.add(arrayListOf(arr[0]))
        return x
    }
    for (i in arr.indices){
        premit(arr.sliceArray(arr.indices-i)).forEach { it.add(0,arr[i]);x.add(it) }
    }
    return x
}