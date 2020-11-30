package testCase;

public class lc279 {
    public static int hIndex(int[] citations) {
        if (citations == null) return -1;
        if (citations.length ==1) {
            if(citations[0] !=0){
                return 1;
            }else{
                return 0;
            }
        }


        for(int i = 0; i < citations.length-1; i++){
            for (int j =i+1; j <citations.length ; j++) {
                if(citations[i]<citations[j]) {
                    int temp=citations[j];
                    citations[j]=citations[i];
                    citations[i]=temp;
                }
            }
        }
        for (int i = 0; i < citations.length; i++) {
            System.out.print("->"+citations[i]);
        }
        int res = -1;
        for(int i = 0; i < citations.length-1; i++){
            System.out.println();
            System.out.println("i="+i+"; "+citations[i]+" "+(i+1)+" "+citations[i+1]);
            if(citations[i]>=(i+1) && citations[i+1]<=(i+1)){
                res =i;
            }
            if((i+1) == (citations.length-1) && citations[i+1] >= i+2){
                res =i+1;
            }
        }
        return res+1;
    }

    public static void main(String[] args) {
        int[] array = {1,1};
        int a = hIndex(array);
        System.out.println();
        System.out.println(a);

    }
}
