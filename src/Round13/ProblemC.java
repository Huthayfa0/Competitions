package Round13;

import java.util.Scanner;

public class ProblemC {
    public static void main(String[] args) {
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
        int count=0;
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
