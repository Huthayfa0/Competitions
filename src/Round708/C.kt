package Round708

fun main(){

    val t= readLine()!!.toInt()
    repeat(t) {
        var (n, k) = readLine()!!.split(' ').map { it.toLong() }
        while (k>3){
            print("1 ")
            k--
            n--
        }
        if (n%2==1L){
            println("1 ${n/2} ${n/2}")
        }else{
            if (n%4==0L){
                println("${n/2} ${n/4} ${n/4}")
            }else{
                println("2 ${(n/4)*2} ${(n/4)*2}")
            }

        }


    }
}