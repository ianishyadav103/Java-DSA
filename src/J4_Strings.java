import java.util.Scanner;

public class J4_Strings {
    public static void main() {
        String s1 = new String("Docker");  //created in both heap and string pool
        String s2 = "Unreal"; //created in string pool
        String s3 = "Docker"; //already exist in string pool hence only points to it


        System.out.println(s1==s3); //false: different memory location
        System.out.println(s1.equals(s3)); //true: compares content


        //traversal
        for (int i = 0; i < s1.length(); i++) {
            System.out.println(s1.charAt(i));
        }


        char[] arr = {'H','e','l','l','o'}; //Alo string

        //Input
        Scanner sc = new Scanner(System.in);
        String z = sc.nextLine();
        System.out.println("Input String: " + z);


        //String builder: for effieciently modifying string
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World");
        System.out.println(sb);

    }
}
