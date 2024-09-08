import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {

        String str = scan.nextLine();
        int arr[] = new int[10];

        for(int i = 0; i < str.length(); i++) {
            int num = Integer.parseInt(str.substring(i, i+1));

            if(num == 9) arr[6]++;
            else arr[num]++;
        }

        if (arr[6] % 2 == 0) arr[6] = arr[6] / 2;
        else arr[6] = arr[6]/2+1;

        int max = 0;
        for(int i = 0; i < 9; i++) {
            max = Math.max(max, arr[i]);
        }

        System.out.println(max);
    }

}