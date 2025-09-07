import java.util.Collections;
import java.util.PriorityQueue;
/*
Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

You must find a solution with a memory complexity better than O(n2).



Example 1:

Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
Output: 13
Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
Example 2:

Input: matrix = [[-5]], k = 1
Output: -5


Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 300
-109 <= matrix[i][j] <= 109
All the rows and columns of matrix are guaranteed to be sorted in non-decreasing order.
1 <= k <= n2

 */

public class KthSmallestElementInMatrix {
    public static int kthSmallestElement(int[][] matrix, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix.length;j++) {
                if(pq.size()<k) {
                    pq.offer(matrix[i][j]);
                } else {
                    if(matrix[i][j] < pq.peek()) {
                        pq.poll();
                        pq.offer(matrix[i][j]);
                    }
                }
            }
        }

        return pq.peek();

    }

    public static int kthSmallestElement2(int[][] matrix, int k) {
        // storing the number of rows in the matrix to use it in later
        int rowCount = matrix.length;
        // declaring a min-heap to keep track of smallest elements
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < Math.min(rowCount, k); i++) {
            // pushing the first element of each row in the min-heap
            // The offer() method pushes an element into an existing heap
            // in such a way that the heap property is maintained.
            minHeap.offer(new int[]{matrix[i][0], i, 0});
        }

        int numbersChecked = 0;
        int smallestElement = 0;
        // iterating over the elements pushed in our minHeap
        while (!minHeap.isEmpty()) {
            // get the smallest number from top of heap and its corresponding row and column
            int[] curr = minHeap.poll();
            smallestElement = curr[0];
            int rowIndex = curr[1];
            int colIndex = curr[2];
            numbersChecked++;
            // when numbersChecked equals k, we'll return smallestElement
            if (numbersChecked == k) {
                break;
            }
            // if the current element has a next element in its row,
            // add the next element of that row to the minHeap
            if (colIndex + 1 < matrix[rowIndex].length) {
                minHeap.offer(new int[]{matrix[rowIndex][colIndex + 1], rowIndex, colIndex + 1});
            }
        }
        // return the Kth smallest number found in the matrix
        return smallestElement;
    }
}
