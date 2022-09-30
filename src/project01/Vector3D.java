package project01;

import java.util.Vector;

import static java.lang.Math.*;

/**
 * This class represent a Vector3D. It has an x y and z components.
 */
public class Vector3D {

    private double x , y , z;

    /**
     * Constructor of Vector3D class. It expects 3 components, x y , z.
     * @param x represent the x point of the vector
     * @param y represent the y point of the vector
     * @param z represent the z point of the vector
     */
    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Get the x component of this class
     * @return x
     */
    public double getX() {
        return x;
    }

    /**
     * Get the y component of this class
     * @return y
     */
    public double getY() {
        return y;
    }

    /**
     * Get the z component of this class;
     * @return z
     */
    public double getZ() {
        return z;
    }


    /**
     * returns the magnitude of this Vector
     * @return magnitude - The square root of the sum of each component multiplied by itself.
     */
    public double getMagnitude() {

        double powX = pow(this.x, 2);
        double powY = pow(this.y, 2);
        double powZ = pow(this.z, 2);
        double magnitude = sqrt(powX + powY + powZ);
        return magnitude;
    }

    /**
     * Returns a new vector that is obtained by dividing each component of a vector by its magnitude.
     * @return a normalized Vector with the magnitude equal to one
     * @throws IllegalStateException if the magnitude of this vector is equal to zero;
     */
    public Vector3D normalize() throws IllegalStateException {

        //Magnitude can only be positive.
        if(this.getMagnitude() <= 0) {
            throw new IllegalStateException();
        }

        double normalizedX = this.getX() / this.getMagnitude();
        double normalizedY = this.getY() / this.getMagnitude();
        double normalizedZ = this.getZ() / this.getMagnitude();

        Vector3D newNormalizedVector = new Vector3D(normalizedX, normalizedY, normalizedZ);

        return newNormalizedVector;
    }

    /**
     * Returns a Vector3D that is obtained by adding respective components of this Vector3D
     * + another vector.
     * @param otherVector - Another Vector3D to be computed.
     * @return a new Vector3D with the sum of the other Vectors
     */
    public Vector3D add (Vector3D otherVector) {

        //Preparing the expected values
        double addedX = this.getX() + otherVector.getX();
        double addedY = this.getY() + otherVector.getY();
        double addedZ = this.getZ() + otherVector.getZ();

        return new Vector3D(addedX, addedY ,addedZ);
    }

    /**
     * Returns a vector obtained by multiplying each component of the current vector by the provided constant.
     * @param constantMultiplier
     * @return a new Vector3D with each component multiplied by a constant
     */
    public Vector3D multiply (double constantMultiplier) {

        //Preparing the expected values
        double expectedX = this.getX() * constantMultiplier;
        double expectedY = this.getY() * constantMultiplier;
        double expectedZ = this.getZ() * constantMultiplier;

        return new Vector3D(expectedX,expectedY,expectedZ);
    }

    /**
     * Returns the dot product of this vector and another vector. It should not change the two vectors.
     * @param otherVector
     * @return the dot product of 2 vectors
     */
    public double dotProduct (Vector3D otherVector) {
        double expectedDot = this.getX() * otherVector.getX() +
                this.getY() * otherVector.getY() +
                this.getZ() * otherVector.getZ();
        return expectedDot;
    }

    /**
     * Returns the angle between two vectors (this vector and other Vector) in degrees.
     * It should not change the two vectors. This is calculated used the dot product / multiplication of magnitudes
     * of both vectors.
     * @param otherVector
     * @return The angle of 2 vectors in degrees.
     * @throws IllegalStateException if the magnitude of either vector is equal to zero;
     */
    public double angleBetween(Vector3D otherVector) throws IllegalStateException {

        if (this.getMagnitude() == 0 || otherVector.getMagnitude() == 0) {
            throw new IllegalStateException();
        }
        double radiant = acos(this.dotProduct(otherVector) / (this.getMagnitude() * otherVector.getMagnitude()));
        return toDegrees(radiant);

    };

    /**
     * Returns the cross product of this vector and another vector.
     * It should not change the two vectors.
     * @param otherVector
     * @return
     */
    public Vector3D crossProduct (Vector3D otherVector) {

        double crossX = this.getY() * otherVector.getZ() - this.getZ() * otherVector.getY();
        double crossY = this.getZ() * otherVector.getX() - this.getX() * otherVector.getZ();
        double crossZ = this.getX() * otherVector.getY() - this.getY() * otherVector.getX();

        return new Vector3D(crossX,crossY,crossZ);
    }

    /**
     * Override the original method and returns the components in order (x, y ,z);
     * @return (x, y ,z);
     */
    @Override
    public String toString() {
        return "(" + String.format("%.2f",x) +
                ", " + String.format("%.2f",y) +
                ", " + String.format("%.2f",z) +
                ')';
    }

}
