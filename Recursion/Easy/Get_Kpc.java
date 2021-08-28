/**
 1. You are given a string str. 
 The string str will contains numbers only, where each number stands 
 for a key pressed on a mobile phone.
2. The following list is the key to characters map :
    0 -> .;
    1 -> abc
    2 -> def
    3 -> ghi
    4 -> jkl
    5 -> mno
    6 -> pqrs
    7 -> tu
    8 -> vwx
    9 -> yz
3. Complete the body of getKPC function - without changing signature -
 to get the list of all words that could be produced by the keys in str.
Use sample input and output to take idea about output.

Note -> The online judge can't force you to write the function
 recursively but that is what the spirit of question is.
  Write recursive and not iterative logic. The purpose of the question is 
  to aid learning recursion and not test you.
Input Format
A string str
Output Format
Contents of the arraylist containing words as shown in sample output
Question Video

  COMMENTConstraints
0 <= str.length <= 10
str contains numbers only
Sample Input
78
Sample Output
[tv, tw, tx, uv, uw, ux]
 */
import java.util.*;

public class Get_Kpc {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        System.out.println(getKPC(str));
        scan.close();
    }

    public static ArrayList<String> getKPC(String str) {
        if (str.length() == 1) {
            String s = getKey(Integer.parseInt(str.substring(0, 1)));
            ArrayList<String> ans = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                ans.add(s.charAt(i) + "");
            }
            return ans;
        }
        ArrayList<String> rawAns = getKPC(str.substring(1));
        String p = getKey(Integer.parseInt(str.substring(0, 1)));
        int size = rawAns.size();
        int length = p.length();
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            char c = p.charAt(i);
            for (int j = 0; j < size; j++) {
                ans.add(c + rawAns.get(j));
            }
        }
        return ans;

    }

    public static String getKey(int i) {
        switch (i) {
            case 0:
                return ".;";
            case 1:
                return "abc";
            case 2:
                return "def";
            case 3:
                return "ghi";
            case 4:
                return "jkl";
            case 5:
                return "mno";
            case 6:
                return "pqrs";
            case 7:
                return "tu";
            case 8:
                return "vwx";
            case 9:
                return "yz";

            default:
                return "";
        }
    }

}