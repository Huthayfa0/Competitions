package Round705;
import java.util.Arrays;
import java.util.Scanner;

public class ProblemB {
    static int []arr={0, 1, 2, 5, 8,10,11,12,15,18,20,21,22,25,28,50,51,52,55,58,80,81,82,85,88,0};
    static int []rev={0,10,50,20,80, 1,11,51,21,81,5 ,15,55,25,85,2 ,12,52,22,82, 8,18,58,28,88,0};
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int t= scan.nextInt();
        while (t-->0){
            int h= scan.nextInt(),m= scan.nextInt();
            int[] time = Arrays.stream(scan.next().split(":")).mapToInt(Integer::parseInt).toArray();
            getNext(time,h,m);
            System.out.printf("%02d:%02d\n",time[0],time[1]);

        }
    }
    static void getNext(int[] time, int h, int m){
        for (int i=0;i<arr.length;i++){
            if (arr[i]>=m||i== arr.length-1){
                time[1]=0;
                time[0]++;
                break;
            }
            if (time[1]<=arr[i]&&rev[i]<h){
                time[1]=arr[i];
                break;
            }
        }
        int b=time[0];
        for (int i=0;i<arr.length;i++){
            if (arr[i]>=h||i== arr.length-1){
                time[0]=0;
                break;
            }
            if (time[0]<=arr[i]&&rev[i]<m){
                time[0]=arr[i];
                break;
            }
        }
        if (b!=time[0]) time[1]=0;
    }
}
