package fraction;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FractionTest {

    Fraction testFraction = new FractionImpl(2, 4);

    @Test                                               
    @DisplayName("Test the Constructor with numerator and denominator")   
    public void testConstructor1() {    
        Fraction f = new FractionImpl(1, 2);

        // Assert basic implementation of the constructor
        assertEquals(1, f.getNumerator());
        assertEquals(2, f.getDenominator());
        assertThrows(ArithmeticException.class, () -> {
            new FractionImpl(1, 0);
        });

        // Assert that the constructor is able to normalize the fraction and manage negative numbers
        Fraction f3 = new FractionImpl(-3,3);
        assertEquals(-1, f3.getNumerator());
        assertEquals(1, f3.getDenominator());


        assertEquals(1, testFraction.getNumerator());
        assertEquals(2, testFraction.getDenominator());
    }

    @Test                                  
    @DisplayName("Test the Constructor with the whole number")
    public void testConstructor2() {
        Fraction f = new FractionImpl(2);
        assertEquals(2, f.getNumerator());
        assertEquals(1, f.getDenominator());

        // assert that the constructor is able to manage negative numbers
        Fraction f2 = new FractionImpl(-2);
        assertEquals(-2, f2.getNumerator());
        assertEquals(1, f2.getDenominator());

        assertEquals(1, testFraction.getNumerator());
        assertEquals(2, testFraction.getDenominator());
        
    }

    @Test
    @DisplayName(" Test the constructor with the string")
    public void testConstructor3() {
        Fraction f = new FractionImpl("1/2");
        assertEquals(1, f.getNumerator());
        assertEquals(2, f.getDenominator());

        assertEquals(1, testFraction.getNumerator());
        assertEquals(2, testFraction.getDenominator());

        // assert that the whitespaces are ignored
        Fraction f3 = new FractionImpl("1 /2 ");
        assertEquals(1, f3.getNumerator());
        assertEquals(2, f3.getDenominator());

    }

    @Test
    @DisplayName("Test the add method")
    public void testAdd() {
        Fraction f = new FractionImpl(1, 2);
        Fraction f2 = new FractionImpl(1, 2);
        Fraction f3 = f.add(f2);
        assertEquals(1, f3.getNumerator());
        assertEquals(1, f3.getDenominator());

        // assert that the constructor is able to manage negative numbers
        Fraction f4 = new FractionImpl(-1, 2);
        Fraction f5 = new FractionImpl(1, 2);
        Fraction f6 = f4.add(f5);
        assertEquals(0, f6.getNumerator());
        assertEquals(1, f6.getDenominator());
    }

    @Test
    @DisplayName("Test the subtract method")
    public void testSubtract() {
        Fraction f = new FractionImpl(1, 2);
        Fraction f2 = new FractionImpl(1, 2);
        Fraction f3 = f.subtract(f2);
        assertEquals(0, f3.getNumerator());
        assertEquals(1, f3.getDenominator());
    }

    @Test
    @DisplayName("Test the multiply method")
    public void testMultiply() {
        Fraction f = new FractionImpl(1, 2);
        Fraction f2 = new FractionImpl(1, 2);
        Fraction f3 = f.multiply(f2);
        assertEquals(1, f3.getNumerator());
        assertEquals(4, f3.getDenominator());
    }

    @Test
    @DisplayName("Test the divide method")
    public void testDivide() {
        Fraction f = new FractionImpl(1, 2);
        Fraction f2 = new FractionImpl(1, 2);
        Fraction f3 = f.divide(f2);
        assertEquals(1, f3.getNumerator());
        assertEquals(1, f3.getDenominator());

        // assert that the constructor is able to manage negative numbers
        Fraction f4 = new FractionImpl(-1, 2);
        Fraction f5 = new FractionImpl(1, 2);
        Fraction f6 = f4.divide(f5);
        assertEquals(-1, f6.getNumerator());
        assertEquals(1, f6.getDenominator());
    }

    @Test
    @DisplayName("Test the toString method")
    public void testToString() {
        Fraction f = new FractionImpl(1, 2);
        assertEquals("1/2", f.toString());

        // assert that the constructor is able to manage negative numbers
        Fraction f2 = new FractionImpl(-1, 2);
        assertEquals("1/-2", f2.toString());
    }

    @Test
    @DisplayName("Test the equals method")
    public void testEquals() {
        Fraction f = new FractionImpl(1, 2);
        Fraction f2 = new FractionImpl(1, 2);
        Fraction f3 = new FractionImpl(2, 3);
        assertFalse(f.equals(f2));
        assertFalse(f.equals(f3));
    }

    @Test
    @DisplayName("Test the hashCode method")
    public void testHashCode() {
        Fraction f = new FractionImpl(1, 2);
        Fraction f2 = new FractionImpl(1, 2);
        Fraction f3 = new FractionImpl(2, 3);
        assertNotEquals(f.hashCode(), f2.hashCode());
        assertNotEquals(f.hashCode(), f3.hashCode());
    }
    
    @Test
    @DisplayName("Test the compareTo method")
    public void testCompareTo() {
        Fraction f = new FractionImpl(1, 2);
        Fraction f2 = new FractionImpl(1, 2);
        Fraction f3 = new FractionImpl(2, 3);
        assertEquals(0, f.compareTo(f2));
        assertEquals(-1, f.compareTo(f3));
        assertEquals(1, f3.compareTo(f));
    }

    @Test
    @DisplayName("Test the equals method with the string")
    public void testEquals2() {
        Fraction f = new FractionImpl("1/2");
        Fraction f2 = new FractionImpl("1/2");
        Fraction f3 = new FractionImpl("2/3");
        assertFalse(f.equals(f2));
        assertFalse(f.equals(f3));
    }

    @Test
    @DisplayName("Test the hashCode method with the string")
    public void testHashCode2() {
        Fraction f = new FractionImpl("1/2");
        Fraction f2 = new FractionImpl("1/2");
        Fraction f3 = new FractionImpl("2/3");
        assertNotEquals(f.hashCode(), f2.hashCode());
        assertNotEquals(f.hashCode(), f3.hashCode());
    }

    @Test
    @DisplayName("Test the compareTo method with the string")
    public void testCompareTo2() {
        Fraction f = new FractionImpl("1/2");
        Fraction f2 = new FractionImpl("1/2");
        Fraction f3 = new FractionImpl("2/3");
        assertEquals(0, f.compareTo(f2));
        assertEquals(-1, f.compareTo(f3));
        assertEquals(1, f3.compareTo(f));
    }

    @Test
    @DisplayName("Test the equals method with the string")
    public void testEquals3() {
        Fraction f = new FractionImpl("1/2");
        Fraction f2 = new FractionImpl("1/2");
        Fraction f3 = new FractionImpl("2/3");
        assertFalse(f.equals(f2));
        assertFalse(f.equals(f3));
    }


}