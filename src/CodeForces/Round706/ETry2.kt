package Round706


fun main(){
    val t= readLine()!!.toInt()
    repeat(t){
        val (n,m)= readLine()!!.split(' ').map { it.toInt() }
        val arr=Array(n){
            readLine()!!
        }
        val fill=Array(n){
            if (it%3==0) Array(m){'X'}
            else Array(m){ o -> if (o!=m-1)'.' else 'X'}
        }
        if(n==3){
            fill[2]=Array(m){'X'}
        }
        if(n==1){
            fill[0]=Array(m){'X'}
        }
        else
        arr.forEachIndexed { i,l->
            run {
                if (i % 3 != 0) {
                        l.forEachIndexed { x, y -> if (y == 'X' && x!=m-1) {
                            if (x==m-2) fill[i ][x + 1] = '.'
                            fill[i][x] = 'X'
                        } }
                }
            }
        }
        fill.forEach { println(it.joinToString("")) }

    }
}