import java.util.Scanner;

public class Task1 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите N:");
        int n = in.nextInt();
        int [] arr1 = new int[n];
        System.out.println("Введите "+n+" элементов:");
        for (int i = 0; i<n; i++) {
            arr1[i] = in.nextInt();
        }
        for (int i : arr1) if (i%2==0) System.out.print(i+" ");
    }
}