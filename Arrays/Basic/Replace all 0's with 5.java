import java.util.Scanner;
import java.lang.Math;

class Convert_To_Five {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int N = sc.nextInt();
            System.out.println(new GfG().convertfive(N));
            T--;
        }
    }
}// } Driver Code Ends


class GfG {
    int convertfive(int n) {
        String s=""+n;
        String st="";
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='0'){
                c='5';
            }
            st=st+c;
            
        }
        n=Integer.parseInt(st);
        return n;
    }
}