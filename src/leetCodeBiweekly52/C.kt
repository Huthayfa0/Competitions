package leetCodeBiweekly52

fun main() {
println(rotateTheBox(
    arrayOf(charArrayOf('*','#','*','.','.','.','#','.','*','.'))
).joinToString (separator = "\n"){ it.joinToString() })
}
fun rotateTheBox(box: Array<CharArray>): Array<CharArray> {
    box.forEach {
        var count=0
        var countMove=0
        for (i in it.indices) {
            if (it[i]!='.'&&countMove>0&&count>0){
                it.fill('#',i-kotlin.math.min(count,countMove),i)
                it.fill('.',i-count-countMove,i-kotlin.math.max(count,countMove))
                countMove=0
            }
            when(it[i]){
                '#'-> {
                    count++
                    countMove=0
                }
                '*'-> {
                    count = 0
                    countMove=0
                }
                '.'->countMove++
            }
        }
        if (it[it.size - 1]=='.'&&countMove>0&&count>0) {
            it.fill('#', it.size - 1 - kotlin.math.min(count, countMove), it.size )
            it.fill('.', it.size - 1 - count - countMove, it.size  - kotlin.math.max(count, countMove))
        }
    }
    return Array(box[0].size) { CharArray(box.size) { t -> box[box.size - 1 - t][it] } }
}