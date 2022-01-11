package fraction;

public class FractionImpl implements Fraction {

    private int numerator;
    private int denominator;
    
    /**
     * Parameters are the <em>numerator</em> and the <em>denominator</em>.
     * Normalize the fraction as you create it.
     * For instance, if the parameters are <pre>(8, -12)</pre>, create a <pre>Fraction</pre> with numerator
     * <pre>-2</pre> and denominator <pre>3</pre>.
     *
     * The constructor should throw an <pre>ArithmeticException</pre> if the denominator is zero.
     *
     * @param numerator
     * @param denominator
     * @throws ArithmeticException if the denominator is zero
     */
    public FractionImpl(int numerator, int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Denominator cannot be zero");
        }
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        int gcd = getGCD(numerator, denominator);
        numerator = numerator / gcd;
        denominator = denominator / gcd;

        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * The parameter is the numerator and <pre>1</pre> is the implicit denominator.
     *
     * @param wholeNumber representing the numerator
     */
    public FractionImpl(int wholeNumber) {
        this.numerator = wholeNumber;
        this.denominator = 1;
    }

    /**
     * The parameter is a <pre>String</pre> containing either a whole number, such as `5` or `-3`, or a fraction,
     * such as "8/-12".
     * Allow blanks around (but not within) integers.
     * The constructor should throw an <pre>ArithmeticException</pre>
     * if given a string representing a fraction whose denominator is zero.
     * <p>
     * You may find it helpful to look at the available String API methods in the Java API.
     *
     * @param fraction the string representation of the fraction
     * @throws ArithmeticException if the denominator is zero
     */
    public FractionImpl(String fraction) {
        String[] split = fraction.split("/");
        if (split.length == 1) {
            this.numerator = Integer.parseInt(removeWhitespaces(split[0]));
            this.denominator = 1;
        } else {
            this.numerator = Integer.parseInt(removeWhitespaces(split[0]));
            this.denominator = Integer.parseInt(removeWhitespaces(split[1]));
        }
        if (denominator == 0) {
            throw new ArithmeticException("Denominator cannot be zero");
        }
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        int gcd = getGCD(numerator, denominator);
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }


    
    /**
    * Returns the greatest common divisor of two integers.
    *
    * @param a the first integer
    * @param b the second integer
    * @return the greatest common divisor of a and b
    */
    private int getGCD(int a, int b) {
        return b == 0 ? a : getGCD(b, a % b);
    }

    /**
     * Remove all whitespace characters from the given string.
     *
     * @param s the string to remove whitespace from
     * @return the string with all whitespace characters removed
     */
    private String removeWhitespaces(String s) {
        return s.replaceAll("\\s+", "");
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction add(Fraction f) {
        int newNumerator = this.numerator * f.getDenominator() + this.denominator * f.getNumerator();
        int newDenominator = this.denominator * f.getDenominator();
        return new FractionImpl(newNumerator, newDenominator);
    }

    

    /**
     * @inheritDoc
     */
    @Override
    public Fraction subtract(Fraction f) {
        int newNumerator = this.numerator * f.getDenominator() - this.denominator * f.getNumerator();
        int newDenominator = this.denominator * f.getDenominator();
        return new FractionImpl(newNumerator, newDenominator);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction multiply(Fraction f) {
        int newNumerator = this.numerator * f.getNumerator();
        int newDenominator = this.denominator * f.getDenominator();
        return new FractionImpl(newNumerator, newDenominator);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction divide(Fraction f) {
        int newNumerator = this.numerator * f.getDenominator();
        int newDenominator = this.denominator * f.getNumerator();
        return new FractionImpl(newNumerator, newDenominator);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction abs() {
        return new FractionImpl(Math.abs(numerator), denominator);
    }

    /**
     * @inheritDoc
     * 
     * @return a new fraction with the opposite signed numerator and the same denominator as this fraction
     */
    @Override
    public Fraction negate() {
        return new FractionImpl(-numerator, denominator);
    }

    /**
     * @inheritDoc
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * @inheritDoc
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /**
     * @inheritDoc
     * @throws CloneNotSupportedException if the object is not a FractionImpl
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * @inheritDoc
     * 
     * @return return a new fraction with inverted numerator and denominator
     */
    @Override
    public Fraction inverse() {
        return new FractionImpl(denominator, numerator);
    }

    /**
     * @inheritDoc
     */
    @Override
    public int compareTo(Fraction o) {
        return (numerator * o.getDenominator() - o.getNumerator() * denominator);
    }

    /**
     * @inheritDoc
     */
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    /**
     * @inheritDoc
     */
    @Override
    public int getNumerator() {
        return this.numerator;
    }

    /**
     * @inheritDoc
     */
    @Override
    public int getDenominator() {
        return this.denominator;
    }
}