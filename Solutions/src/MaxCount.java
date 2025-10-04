import java.util.Arrays;

public class MaxCount {

    public static void main(String[] args) {
        System.out.println(maxCount(new int[]{1,6,5},5, 6));
    }

    public static int maxCount(int[] banned, int n, int maxSum) {
        int cnt = 0;
        int maxSoFar = 0;
        Arrays.sort(banned);
        int i = 1;
        while(maxSoFar<maxSum && i<=n) {
            if(Arrays.binarySearch(banned, i) >= 0) {
                i++;
                continue;
            }
            if(maxSoFar+i>maxSum) break;
            maxSoFar += i;
            cnt++;
            i++;
        }
        return cnt;
    }
}
