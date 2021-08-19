public class Fraction {
    private int numerator;
    private int denomenator;

    public Fraction() {
    }

    public Fraction(int numerator, int denomenator) {
        this.numerator = numerator;
        this.denomenator = denomenator;
    }

    public void add(Fraction fraction) {
        this.numerator = this.numerator * fraction.denomenator + fraction.numerator * this.denomenator;
        this.denomenator *= fraction.denomenator;
        this.reduce();
    }

    public void add(int n) {
        this.numerator += n * this.denomenator;
        this.reduce();
    }

    public void divide(Fraction fraction) {
        int n = fraction.numerator;
        this.numerator = this.numerator * fraction.denomenator;
        this.denomenator *= n;
        this.reduce();
    }

    public void divide(int n) {
        this.denomenator *= n;
        this.reduce();
    }

    public void multiply(Fraction fraction) {
        this.numerator *= fraction.numerator;
        this.denomenator *= fraction.denomenator;
        this.reduce();
    }

    public void multiply(int n) {
        this.numerator *= n;
        this.reduce();
    }

    public void subtract(Fraction fraction) {
        this.numerator = this.numerator * fraction.denomenator - fraction.numerator * this.denomenator;
        this.denomenator *= fraction.denomenator;
        this.reduce();
    }

    public void subtract(int n) {
        this.numerator -= n * this.denomenator;
        this.reduce();
    }

    public void print() {
        this.reduce();
        System.out.println(this.toString());
    }

    public String toString() {
        String strFraction = Integer.toString(numerator) + "/" + Integer.toString(denomenator);
        return strFraction;
    }

    public void nextFraction() {
        this.numerator += 1;
        this.reduce();
    }

    private int getGCD(int a, int b) {
        int gcd = 0;
        for (int i = 1; i <= a && i <= b; i++) {
            if (a % i == 0 && b % i == 0) gcd = i;
        }
        return gcd;
    }

    private void reduce() {
        int gcd = getGCD(Math.abs(numerator), Math.abs(denomenator));
        if (gcd != 0) {
            numerator /= gcd;
            denomenator /= gcd;
        }
        if (denomenator < 0) {
            numerator *= -1;
            denomenator *= -1;
        }
    }
}



