import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        int num = 0;
        System.out.print("<");
        while(!list.isEmpty()) {
            num = (num + k - 1) % n;
            System.out.print(list.remove(num));
            n--;

            if(!list.isEmpty()) System.out.print(", ");
        }
        System.out.print(">");
    }
}