package Round13;

import java.util.Scanner;

public class ProblemB {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int T= scan.nextInt();
        while (T-->0){
            int n=scan.nextInt();
            long u= scan.nextLong(),v= scan.nextLong();
            boolean flag=false;
            boolean zero=false;
            int current= scan.nextInt();
            for (int i=1;i<n;i++){
                int next= scan.nextInt();
                if (Math.abs(current-next)>=2)
                    zero=true;
                if (current!= next)
                    flag=true;
                current=next;
            }
            if (zero)
                System.out.println(0);
            else if (flag)
                System.out.println(Math.min(u,v));
            else
                System.out.println(v+Math.min(u,v));


        }
    }
}
