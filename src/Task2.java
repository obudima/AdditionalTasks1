import com.sun.source.tree.IfTree;

import java.util.Scanner;

public class Task2 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите N:");
        int n = in.nextInt();
        int[] arr1 = new int[n];
        System.out.println("Ввести " + n + " элементов с клавиатуры? (Y-ввод с клавиатуры. N-создание случайных чисел):");
        String answer = new String(in.next());
        if (answer.toLowerCase().equals("y")) {
            System.out.println("Введите " + n + " элементов:");
            for (int i = 0; i < n; i++) {
                arr1[i] = in.nextInt();
            }
        } else {
            for (int i = 0; i < n; i++) arr1[i] = (int) (Math.random() * 2001 - 1000);
            System.out.println("Массив:");
            for (int i : arr1) System.out.print(i + " ");
            System.out.println();
        }
        System.out.println("Результат:");
        boolean currElement = false;
        boolean prevElement = false;
        boolean success = false;
        for (int i = 1; i < n; i++) {
            if (arr1[i]<0) currElement = false; else currElement = true;
            if (arr1[i-1]<0) prevElement = false; else prevElement = true;
            if (currElement == prevElement) success = true;
        }
        if (success) System.out.println("YES"); else System.out.println("NO");
    }
}