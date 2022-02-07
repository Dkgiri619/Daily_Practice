import java.util.*;
public class RangeAddition {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        int[][] queries = new int[k][3];
        for(int i=0;i<k;i++){
            queries[i][0]=scn.nextInt();
            queries[i][1]=scn.nextInt();
            queries[i][2]=scn.nextInt();
        }
        int ans[] = RangeAdditionFunction(n, queries);
        for(int i=0;i<n;i++){
            System.out.print(ans[i]+" ");
        }
    }
    public static int[] RangeAdditionFunction(int n,int[][] queries){
        int[] arr = new int[n];
        for(int i=0;i<queries.length;i++){
            arr[queries[i][0]]+=queries[i][2];
            if(queries[i][1]+1<arr.length){
                arr[queries[i][1]+1]-=queries[i][2];
            }
        }
        for(int i=1;i<n;i++){
            arr[i]+=arr[i-1];
        }
        return arr;
    }
}
