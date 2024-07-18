// public class word_Search_shit

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

public class word_Search_shit {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            char[][] board = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] s = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    board[i][j] = s[j].charAt(0);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(board, word);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends

class Coordinate {
    int row;
    int col;
    
    public Coordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Coordinate other = (Coordinate) obj;
        return row == other.row && col == other.col;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}

class Solution {
    public boolean isExist(char board[][], String word, int row, int col, int index, HashSet<Coordinate> path) {
        if (index == word.length()) return true;

        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length ||
            word.charAt(index) != board[row][col] || path.contains(new Coordinate(row, col))) {
            return false;
        }

        path.add(new Coordinate(row, col));

        boolean res = isExist(board, word, row + 1, col, index + 1, path) ||
                      isExist(board, word, row - 1, col, index + 1, path) ||
                      isExist(board, word, row, col + 1, index + 1, path) ||
                      isExist(board, word, row, col - 1, index + 1, path);

        path.remove(new Coordinate(row, col));
        return res;
    }

    public boolean isWordExist(char[][] board, String word) {
        int rows = board.length;
        int col = board[0].length;
        HashSet<Coordinate> path = new HashSet<>();

        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < col; y++) {
                if (isExist(board, word, x, y, 0, path)) return true;
            }
        }
        return false;
    }
}

