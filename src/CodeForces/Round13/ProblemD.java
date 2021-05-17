package Round13;

import java.util.Scanner;

public class ProblemD {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n= scan.nextInt();
        main:
        while (n-->0){
            int u= scan.nextInt();
            int v= scan.nextInt();
            if (u>v)
                System.out.println("NO");
            else if(u==v)
                System.out.println("YES");
            else {
                int countU=0,countV=0;
                for (int i=0;i<=30;i++) {
                    if ((u>>i)%2==1)
                        countU++;
                    if ((v>>i)%2==1)
                        countV++;
                    if (countU <countV ) {
                        System.out.println("NO");
                        continue main;
                    }
                }
                    System.out.println("YES");
            }

        }
    }

}
