package Round13;

import java.util.Scanner;

public class ProblemC {
    public static void main(String[] args) {
        /*
        This solution works but consumes time
        in order to solve this in O(n) instead of O(n^2)
        you can change each step effect to it derivative using signals equations
        for help enter : https://codeforces.com/contest/1491/submission/108749687
         */
        Scanner scan=new Scanner(System.in);
        int T= scan.nextInt();
        while (T-->0){
            int n= scan.nextInt();
            long[] trampolines=new long[n];
            for (int i=0;i<n;i++)
                trampolines[i]= scan.nextLong();
            System.out.println(solve(trampolines));
        }
    }

    private static long solve(long[] trampolines) {
        long count=0;
        for (int i=0;i<trampolines.length;){
            if (trampolines[i]==1){
                i++;
                continue;
            }
            count++;
            long current=trampolines[i];
            trampolines[i]--;
            int j= (int) (i+current);
            while (j<trampolines.length){
                current=trampolines[j];
                if (trampolines[j]!=1)
                    trampolines[j]--;
                j= (int)(current + j);
            }
        }
        return count;
    }
}
