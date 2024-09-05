import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {

        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        int result = a*b*c;
        boolean line = false;
        int digit = 0;

        //result는 7~9자리 수
        int arr[] = new int[10];
        for(int i=8; i>=0; i--) {
            arr[i] = result / (int)(Math.pow(10, i));
            result -= arr[i] * (int)(Math.pow(10, i));
            System.out.println("arr[" + i + "] : " + arr[i]);
            System.out.println("result : " + result);
            System.out.println();
            if (arr[i] != 0 && !line) {
                digit = i;
                line = true;
            }
        }
        System.out.println("digit : " + digit);

        for (int i = 0; i < 10; i++) {
            int count = 0;
            for (int j = 0; j <= digit; j++) {
                if(arr[j] == i) {
                    count++;
                }
            }
            System.out.println(count);
        }

    }
}