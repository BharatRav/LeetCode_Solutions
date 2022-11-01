package DynamicProgramming;

public class LongestCommonSubsequenceItarativeBestMethod {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] str1 =text1.toCharArray();
        char[] str2 =text2.toCharArray();
        int str1len =str1.length;
        int str2len =str2.length;

        int[][] dp = new int[str1len+1][str2len+1];
        for(int i=1;i<=str1len;i++) {
            for(int j=1;j<=str2len;j++) {
                if(str1[i-1] == str2[j-1]) {
                    dp[i][j] =1+dp[i-1][j-1];
                } else {
                    dp[i][j] =Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[str1len][str2len];
    }
}
