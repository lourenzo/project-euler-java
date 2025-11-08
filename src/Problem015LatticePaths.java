import java.math.BigInteger;

public final class Problem015LatticePaths {
    public static BigInteger countLatticePaths(int n) {
        int numeratorSize = 2 * n;
        int denominatorSize = n;
        return combinations(numeratorSize, denominatorSize);
    }

    public static BigInteger combinations(int n, int k) {
        int actualK = Math.min(k, n - k);
        BigInteger result = BigInteger.ONE;
        for (int i = 0; i < actualK; i++) {
            BigInteger numerator = BigInteger.valueOf(n - i);
            BigInteger denominator = BigInteger.valueOf(i + 1);
            result = result.multiply(numerator).divide(denominator);
        }
        return result;
    }

    public static void main(String[] args) {
        int gridSize = 20;
        BigInteger paths = countLatticePaths(gridSize);
        System.out.println("Grid Size: " + gridSize + "x" + gridSize);
        System.out.println("Total Lattice Paths: " + paths);
    }
}

