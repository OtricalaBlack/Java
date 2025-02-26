
package javaapplication3;

class InvalidRecIntegralException extends Exception {
    public InvalidRecIntegralException(String message) {
        super(message);
    }

    public static void throwException(String message) throws InvalidRecIntegralException {
        throw new InvalidRecIntegralException(message);
    }
}

