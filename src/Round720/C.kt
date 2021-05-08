package Round720

fun main() {
    val T=readLine()!!.toInt()
    repeat(T){
        val n= readLine()!!.toInt()
        val arr=IntArray(n)
        var i=1
        var j=2
        var x=1
        var t=2
        var ans:Int=0
        while (j<=n){
            println("? $t $i $j $x")
            System.out.flush()
            ans= readLine()!!.toInt()
            if (ans==-1)return
            if (ans==1){
                arr[i-1]=1
                break
            }else if (ans==2){
                x=j
                j=i
                i=x
                x=1
                println("? $t $i $j $x")
                System.out.flush()
                ans= readLine()!!.toInt()
                if (ans==-1)return
                if (ans==1) {
                    arr[i - 1] = 1
                    break
                }
                x=j
                j=i
                i=x
                x=1
            }
            i+=2
            j+=2
        }
        if (ans!=1){
            arr[n-1]=1
            i=n
        }
        t=1
        x=n-1
        for (index in 1..n){
            if (i==index)continue
            println("? $t $i $index $x")
            System.out.flush()
            ans= readLine()!!.toInt()
            if (ans==-1)return
            arr[index-1]=ans
        }
        println(arr.joinToString (separator = " ",prefix = "! "))
    }
}