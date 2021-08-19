import java.util.Scanner;

public class Task3 {
    public static void Task3() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите N:");
        int n = in.nextInt();
        int [] arr1 = new int[n];
        System.out.println("Введите "+n+" элементов:");
        for (int i = 0; i<n; i++) {
            arr1[i] = in.nextInt();
        }
        System.out.println("Введите рост Пети:");
        int petr = in.nextInt();
        int pos = 1;
        for (int i = 0; i<n; i++) {
            if (petr<arr1[i]) pos = i+2;
        }
        System.out.println("Номер Пети в шеренге: "+pos);
    }
}
