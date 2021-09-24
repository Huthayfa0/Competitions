package CodeForces.EduRound114;

import java.util.Arrays;
import java.util.Scanner;

public class M {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        long[] arr=new long[n];
        long sum=0;
        for (int i = 0; i < n; i++) {
            arr[i]= scanner.nextLong();
            sum+=arr[i];
        }
        Arrays.sort(arr);
        int t=scanner.nextInt();
        long x,y;
        int s,e,i;
        while (t-->0){
             x=scanner.nextLong();
            y=scanner.nextLong();
             s=0;
             e=n-1;
            while (s < e) {
                int mid = s + (e - s) / 2;
                if (arr[mid] < x) s = mid + 1;
                else e = mid;
            }
             i= (arr[s]>=x)?s:e;
            if (x==arr[i]){
                System.out.println(Math.max(y-(sum-x),0));
            }else{
                if (i==0)
                    System.out.println(Math.max(y-(sum-arr[0]),0));
                else
                    System.out.println(Math.min(Math.max(y-(sum-arr[i]),0)+Math.max(x-arr[i],0),Math.max(y-(sum-arr[i-1]),0)+Math.max(x-arr[i-1],0)));
            }
        }
    }
}
