package GlopalRound14

fun main() {
    val t= readLine()!!.toInt()
    repeat(t) {
        val (n, x) = readLine()!!.split(" ").map { it.toInt() }
        val arr = readLine()!!.split(" ").map { it.toInt() }
        var sum = 0
        val ans=ArrayList<Int>()
        var i=0
        while (i <arr.size){
            if (sum+arr[i]==x){
                if (i+1==arr.size){
                    break
                }
                sum+=arr[i+1]
                ans.add(arr[i+1])
                sum+=arr[i]
                ans.add(arr[i])
                i+=2

            }else{
                sum+=arr[i]
                ans.add(arr[i])
                i++
            }
        }
        if (ans.size==arr.size){
            println("yes")
            println(ans.joinToString(separator = " "))
        }else
            println("No")
    }
}
