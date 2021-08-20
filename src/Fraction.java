import java.util.InputMismatchException;
import java.util.Scanner;

public class Fraction {
    private int numerator;
    private int denomenator;

    public Fraction() throws EnterTypeException, ZeroDivException {
        Scanner in = new Scanner(System.in);
        try {
            System.out.println("Введите числитель:");
            numerator = in.nextInt();
            System.out.println("Введите знаменатель:");
            denomenator = in.nextInt();
        } catch (InputMismatchException e) {
            throw new EnterTypeException();
        }
        if (denomenator == 0) throw new ZeroDivException();
    }

    public Fraction(int numerator, int denomenator) throws ZeroDivException {
        this.numerator = numerator;
        this.denomenator = denomenator;
        if (this.denomenator == 0) throw new ZeroDivException();
    }

    public void add(Fraction fraction) throws ZeroDivException, TypeOverflowException {
        long checkMax;
        checkMax = (long) this.numerator * fraction.denomenator + (long) fraction.numerator * this.denomenator;
        if (checkMax > Integer.MAX_VALUE || checkMax < Integer.MIN_VALUE)
            throw new TypeOverflowException(String.valueOf(checkMax));
        this.numerator = this.numerator * fraction.denomenator + fraction.numerator * this.denomenator;
        checkMax = (long) this.denomenator * fraction.denomenator;
        if (checkMax > Integer.MAX_VALUE || checkMax < Integer.MIN_VALUE)
            throw new TypeOverflowException(String.valueOf(checkMax));
        this.denomenator *= fraction.denomenator;
        this.reduce();
    }

    public void add(int n) throws ZeroDivException, TypeOverflowException {
        long checkMax;
        checkMax = (long) this.numerator + (long) n * this.denomenator;
        if (checkMax > Integer.MAX_VALUE || checkMax < Integer.MIN_VALUE)
            throw new TypeOverflowException(String.valueOf(checkMax));
        this.numerator += n * this.denomenator;
        this.reduce();
    }

    public void divide(Fraction fraction) throws ZeroDivException, TypeOverflowException {
        long checkMax;
        checkMax = (long) this.numerator * fraction.denomenator;
        if (checkMax > Integer.MAX_VALUE || checkMax < Integer.MIN_VALUE)
            throw new TypeOverflowException(String.valueOf(checkMax));
        int n = fraction.numerator;
        this.numerator = this.numerator * fraction.denomenator;
        checkMax = (long) this.denomenator * n;
        if (checkMax > Integer.MAX_VALUE || checkMax < Integer.MIN_VALUE)
            throw new TypeOverflowException(String.valueOf(checkMax));
        this.denomenator *= n;
        this.reduce();
    }

    public void divide(int n) throws ZeroDivException, TypeOverflowException {
        long checkMax;
        checkMax = (long) this.denomenator * n;
        if (checkMax > Integer.MAX_VALUE || checkMax < Integer.MIN_VALUE)
            throw new TypeOverflowException(String.valueOf(checkMax));
        this.denomenator *= n;
        this.reduce();
    }

    public void multiply(Fraction fraction) throws ZeroDivException, TypeOverflowException {
        long checkMax;
        checkMax = (long) this.numerator * fraction.numerator;
        if (checkMax > Integer.MAX_VALUE || checkMax < Integer.MIN_VALUE)
            throw new TypeOverflowException(String.valueOf(checkMax));
        this.numerator *= fraction.numerator;
        checkMax = (long) this.denomenator * fraction.denomenator;
        if (checkMax > Integer.MAX_VALUE || checkMax < Integer.MIN_VALUE)
            throw new TypeOverflowException(String.valueOf(checkMax));
        this.denomenator *= fraction.denomenator;
        this.reduce();
    }

    public void multiply(int n) throws ZeroDivException, TypeOverflowException {
        long checkMax;
        checkMax = (long) this.numerator * n;
        if (checkMax > Integer.MAX_VALUE || checkMax < Integer.MIN_VALUE)
            throw new TypeOverflowException(String.valueOf(checkMax));
        this.numerator *= n;
        this.reduce();
    }

    public void subtract(Fraction fraction) throws ZeroDivException, TypeOverflowException {
        long checkMax;
        checkMax = (long) this.numerator * fraction.denomenator - (long) fraction.numerator * this.denomenator;
        if (checkMax > Integer.MAX_VALUE || checkMax < Integer.MIN_VALUE)
            throw new TypeOverflowException(String.valueOf(checkMax));
        this.numerator = this.numerator * fraction.denomenator - fraction.numerator * this.denomenator;

        checkMax = (long) this.denomenator * fraction.denomenator;
        if (checkMax > Integer.MAX_VALUE || checkMax < Integer.MIN_VALUE)
            throw new TypeOverflowException(String.valueOf(checkMax));
        this.denomenator *= fraction.denomenator;
        this.reduce();
    }

    public void subtract(int n) throws ZeroDivException, TypeOverflowException {
        long checkMax;
        checkMax = (long) this.numerator - (long) n * this.denomenator;
        if (checkMax > Integer.MAX_VALUE || checkMax < Integer.MIN_VALUE)
            throw new TypeOverflowException(String.valueOf(checkMax));
        this.numerator -= n * this.denomenator;
        this.reduce();
    }

    public void print() throws ZeroDivException {
        this.reduce();
        System.out.println(this.toString());
    }

    public String toString() {
        String strFraction = Integer.toString(numerator) + "/" + Integer.toString(denomenator);
        return strFraction;
    }

    public void nextFraction() throws ZeroDivException {
        this.numerator += 1;
        this.reduce();
    }

    private int getGCD(int a, int b) {
        int gcd = 1;
        for (int i = 1; i <= a && i <= b; i++) {
            if (a % i == 0 && b % i == 0) gcd = i;
        }
        return gcd;
    }

    private void reduce() throws ZeroDivException {
        int gcd = getGCD(Math.abs(numerator), Math.abs(denomenator));
        try {
            numerator /= gcd;
            denomenator /= gcd;
        } catch (ArithmeticException e) {
            throw new ZeroDivException(e.getMessage());
        }
        if (denomenator < 0) {
            numerator *= -1;
            denomenator *= -1;
        }
        if (denomenator == 0) throw new ZeroDivException();
    }

    public static class ZeroDivException extends Exception {
        public ZeroDivException() {
            super("Ошибка деления на 0!");
        }

        public ZeroDivException(String msg) {
            super(msg);
        }
    }

    public static class TypeOverflowException extends Exception {
        public TypeOverflowException() {
            super("Ошибка обработки значения!");
        }

        public TypeOverflowException(String msg) {
            super("Ошибка обработки значения (" + msg + ")!");
        }
    }

    public static class EnterTypeException extends Exception {
        public EnterTypeException() {
            super("Ошибка при вводе значения!");
        }
    }
}