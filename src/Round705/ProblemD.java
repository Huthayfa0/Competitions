package Round705;

import java.util.Scanner;

public class ProblemD {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n= Integer.parseInt(s.nextLine());
        String ll=s.nextLine();
        String rr=s.nextLine();
        int l=Integer.parseInt(ll,2);
        int r=Integer.parseInt(rr,2);
        if (l>>1>r)
            System.out.println(Integer.toBinaryString((1<<rr.length())-1));
        else {

        }
    }
}
