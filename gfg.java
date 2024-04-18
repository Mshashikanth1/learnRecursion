import java.util.*;

public class gfg {

    /**
     * Possible Paths in a Tree
     * HardAccuracy: 81.17%Submissions: 6K+Points: 8
     * Share your experience with the world! Submit your admission, interview, campus or any other experience and reach an audience of millions today!
     *
     * banner
     * Given a weighted tree with n nodes and (n-1) edges. You are given q queries. Each query contains a number x. For each query, find the number of paths in which the maximum edge weight is less than or equal to x.
     *
     * Note: Path from A to B and B to A are considered to be the same.
     *
     * Example 1:
     *
     * Input:
     * n = 3
     * edges {start, end, weight} = {{1, 2, 1}, {2, 3, 4}}
     * q = 1
     * queries[] = {3}
     * Output:
     * 1
     * Explanation:
     * Query 1: Path from 1 to 2
     * Example 2:
     *
     * Input:
     * n = 7
     * edges {start, end, weight} = {{1, 2, 3}, {2, 3, 1}, {2, 4, 9}, {3, 6, 7}, {3, 5, 8}, {5, 7, 4}}
     * q = 3
     * queries[] = {1, 3, 5}
     * Output:
     * 1 3 4
     * Explanation:
     * Query 1: Path from 2 to 3
     * Query 2: Path from 1 to 2, 1 to 3, and 2 to 3
     * Query 3: Path from 1 to 2, 1 to 3, 2 to 3, and 5 to 7
     * Your Task:
     * You don't need to read input or print anything. Complete the function maximumWeight()which takes integers n, list of edges where each edge is given by {start,end,weight}, an integer q and a list of q queries as input parameters and returns a list of integers denoting the number of possible paths for each query.
     *
     * Expected Time Complexity: O(nlogn + qlogn)
     * Expected Auxiliary Space: O(n)
     *
     * Constraints:
     * 2 ≤ n ≤ 104
     * 1 ≤ q ≤ 104
     * 1 ≤ edges[i][0], edges[i][1] ≤ n
     * edges[i][0] != edges[i][1]
     * 0 ≤ edges[i][2] ≤ 105
     * 0 ≤ queries[i] ≤ 105
    * */
    /*

    Sum of nodes on the longest path from root to leaf node
    MediumAccuracy: 52.39%Submissions: 77K+Points: 4
    Maximize your earnings for your published articles in Dev Scripter 2024! Gain recognition & extra compensation while elevating your tech profile.

    banner
    Given a binary tree having n nodes. Find the sum of all nodes on the longest path from root to any leaf node. If two or more paths compete for the longest path, then the path having maximum sum of nodes will be considered.

            Example 1:

    Input:
            4
            /  \
            2   5
            / \   /  \
            7  1 2  3
            /
            6
    Output:
            13
    Explanation:
            4
            /  \
            2   5
            / \   /  \
            7  1 2  3
            /
            6
    The highlighted nodes (4, 2, 1, 6) above are part of the longest root to leaf path having sum = (4 + 2 + 1 + 6) = 13
    Example 2:

    Input:
            1
            /   \
            2    3
            / \    /  \
            4   5 6   7
    Output:
            11
    Explanation:
    Use path 1->3->7, with sum 11.


     */

    public static boolean isAdditiveSequence(String n) {
        StringBuilder sb=new StringBuilder();
        int f=Integer.parseInt(n.substring(0,1)),  s=Integer.parseInt(n.substring(1,2));

        sb.append(f);
        sb.append(s);
        while(!(sb.length() > n.length())){
            int c=f+s;
            f=s;
            s=c;
            sb.append(c);
            if(sb.toString().equals(n)) return true;
        }
        return false;
    }

    /*
    * Kth common ancestor in BST
MediumAccuracy: 61.97%Submissions: 11K+Points: 4
Given a BST with n (n>=2) nodes, find the kth common ancestor of nodes x and y in the given tree. Return -1 if kth ancestor does not exist.

Nodes x and y will always be present in the input of a BST, and x != y.

Example 1:

Input:
Input tree

k = 2, x = 40, y = 60
Output:
30
Explanation:
Their 2nd common ancestor is 30.
Example 2:

Input:
Input tree

k = 2, x = 40, y = 60
Output:
-1
Explanation:
LCA of 40 and 60 is 50, which is root itself. There does not exists 2nd common ancestor in this case.
Your task :
You don't have to read input or print anything. Your task is to complete the function kthCommonAncestor() that takes the root of the tree, k, x and y as input and returns the kth common ancestor of x and y.

Expected Time Complexity: O(Height of the Tree)
Expected Space Complexity: O(Height of the Tree)

Your Task :
1 <= n, k <= 105
1 <= node->data, x, y <= 109
*
* ALGORITHM :
*
Start traversing the tree from the root.
While traversing, compare the values of the current node with the values of nodes x and y.
If the current node's value is greater than both x and y, move to the left subtree.
If the current node's value is less than both x and y, move to the right subtree.
If the current node's value lies between x and y (inclusive), the current node is a common ancestor. Store this node and continue traversal to find other common ancestors.
Keep track of the common ancestors encountered during traversal.
Once both x and y are found in the tree, return the kth common ancestor from the list of common ancestors. If the list doesn't have k elements, return -1.

    *
    * */


    public int kthCommonAncestor(Node root, int k, int x, int y) {
        List<Integer> comAncestors=new ArrayList<>();
        traverseBST(root,x,y,comAncestors);
        return comAncestors.isEmpty()? -1:comAncestors.get(k);
    }

    public void traverseBST(Node root, int x, int y, List<Integer> comAncestors){
        if(root==null) return;
        if(root.data>x && root.data>y) traverseBST(root.left,x,y, comAncestors); //curr data is greater than both x,y then move to left subtree
        if(root.data<x && root.data<y) traverseBST(root.right,x,y, comAncestors); //curr data is lesser than both x,y then move to right subtree
        else {
            comAncestors.add(root.data);
            traverseBST(root.left, x, y, comAncestors);
            traverseBST(root.right, x, y, comAncestors);
        }
    }

    /*
    * Sum of Products
MediumAccuracy: 50.93%Submissions: 11K+Points: 4
Given an array arr[] of size n.
Calculate the sum of Bitwise ANDs ie:
calculate sum of arr[i] & arr[j]
for all the pairs in the given array arr[] where i < j.

Example 1:

Input:
n = 3
arr = {5, 10, 15}
Output:
15
Explanation:
The bitwise Ands of all pairs where i<j are (5&10) = 0, (5&15) = 5 and (10&15) = 10.
Therefore, the total sum = (0+5+10) = 15.
Example 2:

Input:
n = 4
arr = {10, 20, 30, 40}
Output:
46
Explanation:
The sum of bitwise Ands
of all pairs = (0+10+8+20+0+8) = 46.
Your Task:
You don't need to read input or print anything.
Your Task is to complete the function pairAndSum() which takes an Integer n and an array arr[]
of size n as input parameters and returns the sum of bitwise Ands of all pairs.

Expected Time Complexity:O(n)
Expected Auxillary Space:O(1)

Constraints:
1 <= n <= 105
1 <= arr[i] <= 108

    *
    * */

    static long pairAndSum1(int n, long arr[]) {
        // code here
        long ans=0;
        for(int i=0; i<n-1; i++) {
            for(int j=i+1; j<n; j++){
                ans+=(arr[j] & arr[i]);
            }
        }
        return ans;
    }

    static long pairAndSum(int n, long arr[]) {
        // code here
        long ans=0;
        for(int i=0;i<32;i++){

            int bitMask =(1 << i);
            int setBits =0;
            for(long j: arr){
                if(((int)j & bitMask )!=0) setBits++;
            }
            ans+= (long) setBits *(setBits-1)/2 * bitMask;
        }
        return ans;
    }


    public static int minimizeDifference2(int n, int k, int[] arr) {


        //find the max, min element in original array
        int max=Integer.MIN_VALUE, min=Integer.MAX_VALUE;
        for(int i:arr) {
            max=Math.max(max,i);
            min=Math.min(min,i);
        }
        int minDiff=max-min;

        int i=0,j=k-1;

        while(j<n){

            //remove one sub array & find max, min elements in remaining array
            max=Integer.MIN_VALUE; min=Integer.MAX_VALUE;
            for( k=0;k<n;k++){
                if( k < i || k > j){
                    max=Math.max(max,arr[k]);
                    min=Math.min(min,arr[k]);
                }
            }
            System.out.println(min +","+max );
            minDiff=Math.min(max-min, minDiff);

            i++;
            j++;
        }

        return minDiff;
    }
    public static int minimizeDifference(int n, int k, int[] arr) {

        String dlm=",";
        Queue<String> minHeap=new PriorityQueue<>( (String a,String b)->  Integer.valueOf(a.split(",")[0]) -  Integer.valueOf(b.split(",")[0]));
        Queue<String> maxHeap=new PriorityQueue<>( (String a,String b)->  Integer.valueOf(b.split(",")[0]) -  Integer.valueOf(a.split(",")[0]));

        for(int i=0;i<n;i++){
            minHeap.add(arr[i]+dlm+i);
            maxHeap.add(arr[i]+dlm+i);
        }

        int minDiff= Integer.valueOf(maxHeap.peek().split(dlm)[0])-Integer.valueOf(minHeap.peek().split(dlm)[0]);
        for(int i=0;i<k;i++){
            minHeap.remove(arr[i]+dlm+i);
            maxHeap.remove(arr[i]+dlm+i);
        }

        System.out.println(minHeap.peek().split(dlm)[0]+","+maxHeap.peek().split(dlm)[0]);

        int i=0,j=k;

        while(j<n){
            maxHeap.remove(arr[j]+dlm+j);
            maxHeap.add(arr[i]+dlm+i);

            minHeap.remove(arr[j]+dlm+j);
            minHeap.add(arr[i]+dlm+i);

            minDiff= Math.min(Integer.valueOf(maxHeap.peek().split(dlm)[0])-Integer.valueOf(minHeap.peek().split(dlm)[0]), minDiff);
            System.out.println(minHeap.peek().split(dlm)[0]+","+maxHeap.peek().split(dlm)[0]);

            i++;
            j++;
        }
        return minDiff;
    }


    public static int minimizeDifference3(int n, int k, int[] arr) {
        TreeSet<Integer> minSet = new TreeSet<>(); // Min-heap (sorted in ascending order)
        TreeSet<Integer> maxSet = new TreeSet<>((a, b) -> Integer.compare(b, a)); // Max-heap (sorted in descending order)

        // Initialize the first window of size k
        for (int i = 0; i < k; i++) {
            minSet.add(arr[i]);
            maxSet.add(arr[i]);
        }

        int minDiff = maxSet.first() - minSet.first();

        // Slide the window across the array
        for (int i = 1; i <= n - k; i++) {
            // Add the new element to the window
            minSet.add(arr[i + k - 1]);
            maxSet.add(arr[i + k - 1]);

            // Remove the outgoing element from the window
            minSet.remove(arr[i - 1]);
            maxSet.remove(arr[i - 1]);

            // Update the minimum difference
            minDiff = Math.min(minDiff, maxSet.first() - minSet.first());
        }

        return minDiff;
    }


    public static int minimizeDifference4(int n, int k, int[] arr) {

        Queue<Integer> minHeap=new PriorityQueue<>( (a,b)-> a-b);
        Queue<Integer> maxHeap=new PriorityQueue<>( (a,b)-> b-a);

        for(int i=0;i<n;i++){
            minHeap.add(arr[i]);
            maxHeap.add(arr[i]);
        }

        int minDiff= maxHeap.peek()-minHeap.peek();
        for(int i=0;i<k;i++){
            minHeap.remove(arr[i]);
            maxHeap.remove(arr[i]);
        }


        int i=0,j=k;
        while(j<n){
            maxHeap.remove(arr[j]);
            maxHeap.add(arr[i]);

            minHeap.remove(arr[j]);
            minHeap.add(arr[i]);

            minDiff= Math.min(maxHeap.peek()-minHeap.peek(),minDiff);

            i++;
            j++;
        }
        return minDiff;
    }


    public static int minimizeDifference5(int n, int k, int[] arr) {
        int post_max[] = new int[n];
        int post_min[] = new int[n];

        post_max[n - 1] = post_min[n - 1] = arr[n - 1];

        for(int i = n - 2; i >= 0; i--) {
            post_max[i] = Math.max(arr[i], post_max[i + 1]);
            post_min[i] = Math.min(arr[i], post_min[i + 1]);
        }

        int mini = arr[0], maxi = arr[0], res = post_max[k] - post_min[k];

        for(int i = 1; i < n - k; i++) {
            res = Math.min(res, Math.max(maxi, post_max[i + k]) - Math.min(mini, post_min[i + k]));
            mini = Math.min(mini, arr[i]);
            maxi = Math.max(maxi, arr[i]);
        }

        res = Math.min(res, maxi - mini);

        return res;
    }


    public static int[] twoRepeated1(int arr[], int n)
    {
        // Your code here
        int[] ans=new int[2], frq=new int[n];
        int j=0;

        for(int i=0; i<n+2; i++){
            frq[arr[i]-1]++;
            if (frq[arr[i]-1]==2) ans[j++]=arr[i];
        }
        return ans;
    }

    public static int[] twoRepeated(int arr[], int n){
        int y=0;
        int[] nums= new int[3];

        for(int i=0; i<arr.length; i++){
            int k=Math.abs(arr[i]);

            if (arr[k] < 0) nums[y++]=k;
            else arr[k]*=-1;
        }
        return nums;
    }


    /*
    * 6
3
            2  3 1  7 6 4
               i    j
    min = 6,   min=min(i-1,j+1) = 2
    max = 7,   max=max(i-1, j+1)= 6
    * */
}

class Node{
    int data;  Node left, right;
    public Node(int d){
        data=d; left=null; right=null;
    }
}
