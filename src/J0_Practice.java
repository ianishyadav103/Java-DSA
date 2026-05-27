public class J0_Practice {
    static void main() {
        int a =11;
        int bitscount;
        if(a==0){
            bitscount =1;
        }

        else {
            bitscount = (int) (Math.log(a)/Math.log(2)) +1;
        }
        String x = "";
        System.out.println(a>>1);
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(a<<1));
        System.out.println(bitscount);


    }}


