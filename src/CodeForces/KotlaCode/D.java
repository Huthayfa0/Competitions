package KotlaCode;

import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int t= scan.nextInt();
        while(t-->0){
            int n= scan.nextInt();
            long k= scan.nextLong();
            long[] arr=new long[n];
            long[] indices=new long[n];
            for (int i=0;i<n;i++){
                arr[i]= scan.nextLong();
                indices[i]= arr[i];
            }
            Arrays.sort(arr);

            for (int i=0;i<n;i++){
                int count=1;
                int l=Arrays.binarySearch(arr,indices[i]);
                int a=l-1;
                int b=l+1;
                while (a>=0) {
                    if (arr[l] - arr[a] >k) break;
                    a--;
                    count++;
                }
                while (b<n) {
                    if (arr[b] - arr[l] >k) break;
                    b++;
                    count++;
                }
                System.out.print(count+" ");
            }
            System.out.println();

        }

    }
}
