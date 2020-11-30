package testCase;


public class lc277 {
    public int findCelebrity(int n ){
        if ( n < 2 ) return -1;

        int possible = 0;

        for (int i = 0; i < n; i++) {
            if(knows(possible,i)){
                possible = i;
            }
        }

        for(int i = 0; i < n ; i++){
            if (possible != i && (knows(possible,i)  || !knows(i,possible)) ){
                return -1;
            }
        }
        return possible;

    }


    public int solution2(int n){
        int res = 0;

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                 if(j == i){
                     continue;
                 }
                 if (knows(j,i)){
                     nums[i]++;
                 }
            }
        }

        for (int k = 0; k < n; k++) {
            if (nums[k] == n-1){
                res=k;
                break;
            }
        }
        return res;

    }

    public boolean knows(int a , int b){
        return true;
    }
}
