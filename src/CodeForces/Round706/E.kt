package Round706


fun main(){
    val t= readLine()!!.toInt()
    repeat(t){
        val (n,m)= readLine()!!.split(' ').map { it.toInt() }
        val arr=Array(n){
            readLine()!!
        }
        val fill=Array(n){
            if (it%2==0) Array(m){'X'}
            else Array(m){ o -> if (o!=m-1)'.' else 'X'}
        }
        arr.forEachIndexed { i,l->
            run {
                if (i % 2 == 1) {
                    if (i!=n-1)
                        l.forEachIndexed { x, y -> if (y == 'X' && x!=m-1) {
                            if (x==m-2){ fill[i][x] = 'X'; fill[i ][x + 1] = '.'}
                            fill[i][x] = 'X'; fill[i + 1][x + 1] = '.'
                        } }
                    else
                        l.forEachIndexed { x, y -> if (y == 'X' && x!=m-1) {
                            fill[i][x] = 'X'
                        } }
                }
            }
        }
        fill.forEach { println(it.joinToString("")) }

    }
}