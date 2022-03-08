// minimum steps to make a number k with power of 2 and 3
public class MinStepsToMakeANumK{
    public static void main(String[] args){
        System.out.println(minNum(36));
    }
    public static int minNum(int N){
        int count=0,sum=0;
        while(sum<=N){
            if(sum==N)return count;
            int rem = N-sum;
            int log2 = (int)Math.floor(Math.log(rem)/Math.log(2));
            int log3 = (int)Math.floor(Math.log(rem)/Math.log(3));
            int pow3 = (int)Math.pow(3, log3);
            int pow2 = (int)Math.pow(2, log2);
            if(pow3>pow2){
                sum+=pow3;
                System.out.println(pow3);
            }else{
                sum+=pow2;
                System.out.println(pow2);
            }
            count++;
        }
        return -1;
    }
}
