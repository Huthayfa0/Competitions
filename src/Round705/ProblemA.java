package Round705;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemA {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int t= scan.nextInt();
        while (t-->0){
            int n= scan.nextInt(),k= scan.nextInt();
            int x=n-k/2-k%2;
            System.out.println(x);
            while (x-->0)
                if (n!=k)
                    System.out.print(n--+" ");
                else {x++;n--;}
            System.out.println();
        }
    }
}
