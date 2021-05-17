package Round13;

import java.util.Scanner;

public class ProblemA {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        //String[] line=scan.nextLine().split(" ");
        int n= scan.nextInt(),q=scan.nextInt();
        int[] arr=new int[n];
        int onesCount=0;

        for (int i=0;i<n;i++){
            arr[i]=scan.nextInt();
            if (arr[i]==1)
                onesCount++;
        }
        for (int i=0;i<q;i++){

            int a=scan.nextInt(),b=scan.nextInt()-1;
            if (a==1){
                if (arr[b]==0){
                    arr[b]=1;
                    onesCount++;
                }else {
                    arr[b]=0;
                    onesCount--;
                }

            }else if (a==2){
                if (b>=onesCount)
                    System.out.println(0);
                else
                    System.out.println(1);

            }

        }
    }
}
