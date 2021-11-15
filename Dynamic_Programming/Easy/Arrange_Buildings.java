
/**
 * 1. You are given a number n, which represents the length of a road. The road
 * has n plots on it's each side. 2. The road is to be so planned that there
 * should not be consecutive buildings on either side of the road. 3. You are
 * required to find and print the number of ways in which the buildings can be
 * built on both side of roads. Input Format A number n Output Format A number
 * representing the number of ways in which the buildings can be built on both
 * side of roads. Question Video
 * 
 * COMMENTConstraints 0 < n <= 45 Sample Input 6 Sample Output 441
 * 
 * 
 * Asked in Companies Related Topics
 */
import java.util.*;

public class Arrange_Buildings {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int spaceCount = 1;
        int buildingCount = 1;
        for (int i = 2; i <= n; i++) {
            int newSpaceCount = spaceCount + buildingCount;
            int newBuildingCount = spaceCount;
            spaceCount = newSpaceCount;
            buildingCount = newBuildingCount;
        }
        long ans = buildingCount + spaceCount;
        System.out.println(ans * ans);
        scan.close();
    }

}