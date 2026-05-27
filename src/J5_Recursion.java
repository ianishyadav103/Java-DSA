public class J5_Recursion {
    static void main(String[] args) {
        //Base Case + Recursive Call

        printnumbmer(5);

        System.out.println(fact(5));
        fact2(5,1);

        for (int i = 0; i < 5; i++) {
            System.out.println( "Fib at position: " + fibo1(i));
        }
        fibo2(5,0,1);
    }
    static void printnumbmer(int n){
        if(n<0){
            return;
        }
        System.out.println(n);
        printnumbmer(--n);;
    }

    //factorial
    static int fact(int n){
       if(n==1){
           return 1;
       }

       return n * fact(--n);

    }
    //factorial2: tail recursion i.e. no call stack build-up
    static void fact2(int n, int result){
       result = result * n;

        if(n==1 || n==0){
            System.out.println(result);
            return;
        }
  ;
        fact2(--n,result);


    }
    //Fibonacci number at nth index
    static int fibo1(int n){
        if(n<=1){
            return n;
        }
        return (fibo1(n-1) + fibo1(n-2));

    }
    //Fibonacci2
    static void fibo2(int n,int a, int b){
        if(n==0){
            return;
        }
        else {
            int c = a+b;
            System.out.println(c);
            a= b;

            b = c;
            fibo2(--n,a,b);
        }
    }
}
