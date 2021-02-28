package Round13;

import java.util.Scanner;

public class ProblemD {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n= scan.nextInt();
        while (n-->0){
            int u= scan.nextInt(),v= scan.nextInt();
            if (u>v)
                System.out.println("NO");
            else if(u==v)
                System.out.println("YES");
            else {
                double x=Math.log(v/u)/Math.log(2);
                if (x==(int)x){
                    System.out.println("YES");
                    continue;
                }
                if (countSetBits(u)>=countSetBits(v))
                    System.out.println("YES");
                else
                    System.out.println("NO");

            }
        }
    }
    static int countSetBits(int n)
    {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }
}
