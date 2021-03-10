package kotlinHeroesEp6

fun main(){
    var t= readLine()!!.toInt()
    while (t-->0){
        var (n,k)= readLine()!!.split(" ").map { it.toInt() }
        val str= readLine()!!
        var count=1
        var c=1
        for (i in 1 until n){
            if (str[i]=='('){
                if (c==0){
                    count++
                    c++
                }else{
                    if (k>0){k--
                    count++
                    }
                    c++
                }
            }else
                c--

        }
        println(count)
    }
}
