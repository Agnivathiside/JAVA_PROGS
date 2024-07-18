// public class search_in_2darray_shit

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int rows = sc.nextInt();
            int columns = sc.nextInt();

            int matrix[][] = new int[rows][columns];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            int target = sc.nextInt();

            Solution x = new Solution();

            if (x.search(matrix, rows, columns, target))
                System.out.println(1);
            else
                System.out.println(0);
            t--;
        }
    }
}
// } Driver Code Ends

class Solution {
    // Function to search a given number in row-column sorted matrix.
    static boolean search(int matrix[][], int n, int m, int x) {
        // code here
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = m - 1;

        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                if (matrix[top][i] == x)
                    return true;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                if (matrix[i][right] == x)
                    return true;
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    if (matrix[bottom][i] == x)
                        return true;
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    if (matrix[i][top] == x)
                        return true;
                }
                left++;
            }
        }
        return false;
    }
}
