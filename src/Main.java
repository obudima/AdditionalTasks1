import com.sun.source.tree.TryTree;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        try {
            Fraction fraction0 = new Fraction(500, 0);
            fraction0.print();
        }
        catch (Fraction.ZeroDivException e)
        {
            System.out.println("Ошибка деления на ноль!");
            e.printStackTrace();
        }

        try {
            Fraction fraction1 = new Fraction(0, 1);
            Fraction fraction2 = new Fraction(0, 1);
            Fraction fraction3 = new Fraction(99999999, 9999999);
            Fraction fraction4 = new Fraction(99999999, 99999999);

            fraction1.add(1);
            fraction1.print();
            fraction2.print();
            fraction1.multiply(fraction2);
            fraction1.print();
            fraction1.subtract(1);
            fraction1.print();
            fraction3.multiply(fraction4);
            fraction3.print();
            fraction1.divide(fraction2);
            fraction1.print();
        } catch (Fraction.ZeroDivException e) {
            System.out.println("Ошибка деления на ноль!");
            e.printStackTrace();
        }
        catch (Fraction.TypeOverflowException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        try {
            Fraction fraction5 = new Fraction();
            fraction5.print();
        }
        catch (Fraction.ZeroDivException e) {
            System.out.println("Ошибка деления на ноль!");
            e.printStackTrace();
        }
        catch (Fraction.EnterTypeException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}
