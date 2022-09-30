import project01.Vector3D;

import static org.junit.Assert.assertEquals;

/**
 * This is the class test for the Vector3D class.
 */
public class Vector3DTest {
    private Vector3D vector1, vector2, otherVector, zeroVector, negativeVector1;

    /**
     * Setting up some objects of type Vector3D.
     */
    @org.junit.Before
    public void setUp() throws Exception {
        this.vector1 = new Vector3D(2.0001,4.0001,5.0009);
        this.vector2 = new Vector3D(-1.45f,7.25f,5);
        this.negativeVector1 = new Vector3D(-1.56f,-12,-5.28f);
        this.otherVector = new Vector3D(-6.54f,4.34f,-4.28f);
        this.zeroVector = new Vector3D(0,0,0);
    }

    /**
     * Instance of Vector3D to test the get X method
     */
    @org.junit.Test
    public void getX() {
        assertEquals(2, vector1.getX(), 0.001);
        assertEquals(-1.45f, vector2.getX(), 0.001);
        assertEquals(-1.56f, negativeVector1.getX(), 0.001);
        assertEquals(-6.54f, otherVector.getX(), 0.001);
        assertEquals(0, zeroVector.getX(), 0.001);
    }

    /**
     * Instance of Vector3D to test the get Y method
     */
    @org.junit.Test
    public void getY() {
        assertEquals(4, vector1.getY(), 0.001);
        assertEquals(7.25f, vector2.getY(), 0.001);
        assertEquals(-12, negativeVector1.getY(), 0.001);
        assertEquals(4.34f, otherVector.getY(), 0.001);
        assertEquals(0, zeroVector.getY(), 0.001);
    }

    /**
     * Instance of Vector3D to test the get Z method
     */
    @org.junit.Test
    public void getZ() {
        assertEquals(5, vector1.getZ(), 0.001);
        assertEquals(5, vector2.getZ(), 0.001);
        assertEquals(-5.28f, negativeVector1.getZ(), 0.001);
        assertEquals(-4.28f, otherVector.getZ(), 0.001);
        assertEquals(0, zeroVector.getZ(), 0.001);
    }

    /**
     * Computing the magnitude of each initial object to verify getMagnitude is working
     */
    @org.junit.Test
    public void getMagnitude() {
        assertEquals(6.7082, vector1.getMagnitude(), 0.001);
        assertEquals(8.9255, vector2.getMagnitude(), 0.001);
        assertEquals(13.2027, negativeVector1.getMagnitude(), 0.001);
        assertEquals(8.9401, otherVector.getMagnitude(), 0.001);
        assertEquals(0, zeroVector.getMagnitude(), 0.001);
    }

    /**
     * Creating an instance of Vector3D from the normalize method.
     * And testing this new Instance with the expected values.
     */
    @org.junit.Test
    public void normalize() {
        //Vector 1 normalized expected Value
        assertEquals(0.2981, vector1.normalize().getX(), 0.001);
        assertEquals(0.5962, vector1.normalize().getY(), 0.001);
        assertEquals(0.7454, vector1.normalize().getZ(), 0.001);

        // Negative Vector normalized expected value
        assertEquals(-0.1182, negativeVector1.normalize().getX(), 0.001);
        assertEquals(-0.9089, negativeVector1.normalize().getY(), 0.001);
        assertEquals(-0.3999, negativeVector1.normalize().getZ(), 0.001);
    }

    /**
     * If we try to normalize a zero vector (0,0,0) the magnitude will be zero
     * And it can not be normalized. Therefore, an IllegalStateException should be thrown
     */
    @org.junit.Test(expected = IllegalStateException.class)
    public void normalizeFailure() {

        this.zeroVector.normalize();
    }

    /**
     * Creating an instance of Vector3D from the add method.
     * And testing this new Instance with the expected values.
     */
    @org.junit.Test
    public void add() {

        //This will rector the new added vector
        Vector3D newAddedVector = vector1.add(vector2);

        assertEquals(0.55f, newAddedVector.getX(), 0.001);
        assertEquals(11.25f, newAddedVector.getY(), 0.001);
        assertEquals(10, newAddedVector.getZ(), 0.001);

        //Two Other test
        Vector3D newAddedVector2 = negativeVector1.add(otherVector);

        assertEquals(-8.10f, newAddedVector2.getX(), 0.001);
        assertEquals(-7.66f, newAddedVector2.getY(), 0.001);
        assertEquals(-9.56f, newAddedVector2.getZ(), 0.001);

    }

    /**
     * Creating an instance of Vector3D from the multiply method.
     * And testing this new Instance with the expected values.
     */
    @org.junit.Test
    public void multiply() {

        double factor = -4.24f;

        //This will rector the new added vector
        Vector3D newAddedVector = vector1.multiply(factor);
        Vector3D newAddedVector2 = negativeVector1.multiply(factor);

        assertEquals(-8.4804, newAddedVector.getX(), 0.001);
        assertEquals(-16.9604, newAddedVector.getY(), 0.001);
        assertEquals(-21.2038, newAddedVector.getZ(), 0.001);

        assertEquals(6.6144, newAddedVector2.getX(), 0.001);
        assertEquals(50.88, newAddedVector2.getY(), 0.001);
        assertEquals(22.3872, newAddedVector2.getZ(), 0.001);

    }

    /**
     * Test the DotProduct method. The dot product of this vector and another vector.
     * It should not change the two vectors.
     */
    @org.junit.Test
    public void dotProduct() {

        assertEquals(19.548f,  vector2.dotProduct(otherVector),0.001);
        assertEquals(-111.138f,  vector2.dotProduct(negativeVector1),0.001);

        //Test the other Vectors where not changed
        assertEquals(-1.56f, negativeVector1.getX(), 0.001);
        assertEquals(-6.54f, otherVector.getX(), 0.001);
        assertEquals(-12, negativeVector1.getY(), 0.001);
        assertEquals(4.34f, otherVector.getY(), 0.001);

    }

    /**
     * Test the angles between both Vectors. If it's the same vector it should return 0
     */
    @org.junit.Test
    public void angleBetween() {

        //same vector should return 0;
        assertEquals(0, vector1.angleBetween(vector1),0.001);
        assertEquals(99.4001, negativeVector1.angleBetween(otherVector),0.001);
        assertEquals(75.8195, vector2.angleBetween(otherVector),0.001);
    }

    /**
     * Illegal State if the magnitude of either vector is zero.
     */
    @org.junit.Test(expected = IllegalStateException.class)
    public void angleBetweenException() {

        //If we have a magnitude of zero this must fail
        assertEquals(75.81f, vector2.angleBetween(zeroVector),0.001);
    }

    /**
     * Test the CrossProduct needs to create a new instance of Vector3D
     * ande verify the initial Vectors where not modified;
     */
    @org.junit.Test
    public void crossProduct() {

        Vector3D crossVector = negativeVector1.crossProduct(otherVector);

        assertEquals(74.2752, crossVector.getX(), 0.001);
        assertEquals(27.8544, crossVector.getY(), 0.001);
        assertEquals(-85.25, crossVector.getZ(), 0.001);

        //Check the initial vectors where not changed
        assertEquals(-1.56f, negativeVector1.getX(), 0.001);
        assertEquals(-6.54f, otherVector.getX(), 0.001);
        assertEquals(-12, negativeVector1.getY(), 0.001);
        assertEquals(4.34f, otherVector.getY(), 0.001);
    }

    /**
     * Test the format of the ToString method (x, y, z)
     */
    @org.junit.Test
    public void testToString() {
        assertEquals("(2.00, 4.00, 5.00)", vector1.toString());
        assertEquals("(-1.45, 7.25, 5.00)", vector2.toString());
        assertEquals("(-1.56, -12.00, -5.28)", negativeVector1.toString());
        assertEquals("(-6.54, 4.34, -4.28)", otherVector.toString());
        assertEquals("(0.00, 0.00, 0.00)", zeroVector.toString());
    }
}