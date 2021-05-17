package KotlaCode;

import java.util.Arrays;
import java.util.Scanner;

public class G {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int t= scan.nextInt();
        while(t-->0){
            int n= scan.nextInt();
            int k= scan.nextInt();
            int[] arr=new int[n];
            int sum=0;
            int s=2*k+1;

            for (int i=0;i<n;i++){
                arr[i]= scan.nextInt();
            }
            for (int i=0;i<s;i++){
                if (i>=n)
                    break;
                sum+=arr[i];
            }
            int max=sum;
            for (int i=s;i<n;i++){
                sum+=arr[i];
                sum-=arr[i-s];
                max= Math.max(sum,max);
            }
            System.out.println(max);

        }

    }
}
