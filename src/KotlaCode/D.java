package KotlaCode;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int t= scan.nextInt();
        while(t-->0){
            int n= scan.nextInt();
            long k= scan.nextLong();
            long[] arr=new long[n];
            for (int i=0;i<n;i++){
                arr[i]= scan.nextLong();
            }
            for (int i=0;i<n;i++){
                int count=0;
                for (long x :arr)
                    if (Math.abs(arr[i]-x)<=k)
                        count++;
                System.out.print(count+" ");
            }
            System.out.println();

        }

    }
}
