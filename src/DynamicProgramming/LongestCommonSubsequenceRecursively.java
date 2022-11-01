package DynamicProgramming;

public class LongestCommonSubsequenceRecursively {
    public  int lcshelper(String text1,String text2,int m, int n,int[][] dp) {
        if(m==0 || n == 0) {
             return dp[m][n];
        }
        if(dp[m][n] !=-1) {
            return dp[m][n];
        }
        if(text1.charAt(m)==text2.charAt(n)) {
            return dp[m][n] =1+lcshelper(text1,text2,m-1,n-1,dp);
        } else {
            return dp[m][n] = Math.max(lcshelper(text1,text2,m-1, n,dp),lcshelper(text1,text2,m,n-1,dp));
        }
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=1;i<=m;i++) {
            for(int j =1;j<=n;j++) {
                dp[i][j] = -1;
            }
        }
        lcshelper(text1,text2,m,n,dp);
        return dp[m][n];
    }

    public static void main(String[] args) {
        String text1="abcde";
        String text2 = "ace";
        LongestCommonSubsequenceRecursively lcs = new
                LongestCommonSubsequenceRecursively();
        int result = lcs.longestCommonSubsequence(text1,text2);
    }
}
