import java.util.*;

public class MaxRangeQuery {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n =scn.nextInt();
        int n1 = scn.nextInt();
        int[][] queries= new int[n1][2];
        for(int i=0;i<n1;i++){
            queries[i][0]=scn.nextInt();
            queries[i][1]=scn.nextInt();
        }
        int k =scn.nextInt();
        MaxRangeQuerySoluton(queries, n, k);
    }
    public static void MaxRangeQuerySoluton(int [][] queries, int n, int k){
        int[] arr = RangeAdditionFunction(n, queries);
        // k count arr
        int[] karr = new int[n];
        //k + 1 count arr
        int[] kp1arr = new int[n];
        int ksum=0;
        int kp1sum=0;
        for(int i=0;i<n;i++){
            if(arr[i]==k)ksum++;
            else if(arr[i]==k+1)kp1sum++;
            karr[i]=ksum;
            kp1arr[i]=kp1sum;
        }
        int []solLR = new int[2];
        int solQKCount = 0;
        for(int i=0;i<queries.length;i++){
            int l = queries[i][0];
            int r = queries[i][1];
            int krem = karr[r] -(l==0?0:karr[l-1]);
            int kp1rem = kp1arr[r] - (l==0?0:kp1arr[l-1]);
            int rem = ksum - krem + kp1rem;
            if(solQKCount<rem){
                solQKCount = rem;
                solLR[0]=l;
                solLR[1]=r;
            }
        }
        System.out.println(" Max query range: "+solLR[0]+"-"+solLR[1]);
        System.out.println("Max number of k: "+solQKCount);
    }
    public static int[] RangeAdditionFunction(int n,int[][] queries){
        int[] arr = new int[n];
        for(int i=0;i<queries.length;i++){
            arr[queries[i][0]]+=1;
            if(queries[i][1]+1<arr.length){
                arr[queries[i][1]+1]-=1;
            }
        }
        for(int i=1;i<n;i++){
            arr[i]+=arr[i-1];
        }
        return arr;
    }
}
