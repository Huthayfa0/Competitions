package leetCodeBiweekly52

fun main() {
    println(sortSentence("is2 sentence4 This1 a3"))
}
fun sortSentence(s: String): String {
    val strings=s.split(" ").sortedBy { it.last() }
    return strings.joinToString(separator = " ") { it.substring(0,it.length-1) }
}