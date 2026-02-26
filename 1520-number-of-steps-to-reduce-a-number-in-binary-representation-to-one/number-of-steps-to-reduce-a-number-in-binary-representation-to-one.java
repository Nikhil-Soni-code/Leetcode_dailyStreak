import java.math.*;

class Solution {
    public int numSteps(String s) {
        BigInteger binary = new BigInteger(s, 2);
        int steps = 0;

        while (!binary.equals(BigInteger.ONE)) {
            if (binary.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
                binary = binary.divide(BigInteger.TWO);
            } else {
                binary = binary.add(BigInteger.ONE);
            }
            steps++;
        }

        return steps;
    }
}