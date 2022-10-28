package DynamicProgramming;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;    //row length
        int n = obstacleGrid[0].length; // column length

        int[][] pathDP = new int[m][n];

        for(int i=0;i<n;i++) {      //for all the first row element
            if(obstacleGrid[0][i] == 1) {
                pathDP[0][i] = 0;
                break;
            }
            pathDP[0][i] =1;
        }

        for(int i=0;i<m;i++) {      //for all the first column element
            if(obstacleGrid[i][0] == 1) {
                pathDP[i][0] = 0;
                break;
            }
            pathDP[i][0] =1;
        }

        for(int i=1;i<m;i++) {
            for(int j =1;j<n;j++) {
                if(obstacleGrid[i][j] == 1) {
                    pathDP[i][j] =0;
                } else  {
                    pathDP[i][j] = pathDP[i-1][j] +pathDP[i][j-1];
                }
            }
        }
        return pathDP[m-1][n-1];
    }
}
