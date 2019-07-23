package com.mattcarp12.algorithms.DP;

class EditDistace {
    public static int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] D = new int[n1 + 1][n2 + 1];
        for(int i = 0; i <= n1; i++) D[i][0] = i;
        for(int i = 0; i <= n2; i++) D[0][i] = i;

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                int cost = (word1.charAt(i - 1) == word2.charAt(j - 1)) ? 0 : 1;
                D[i][j] = min(D[i - 1][j] + 1, D[i][j - 1] + 1, D[i - 1][j - 1] + cost);
            }
        }
        return D[n1][n2];
    }

    public static int min(int i, int j, int k) {
        int min1 = Integer.min(i,j);
        return Integer.min(min1, k);

    }

    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ros";
        int editDist = minDistance(s1, s2);
        System.out.print(editDist);  // prints 3
    }
}
