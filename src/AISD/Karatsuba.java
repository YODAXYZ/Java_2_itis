package AISD;
// T(n) O(n^2/3)

/*
 * Take two numbers, x and y.
 * Example: 12345 and 6789.
 * Find a base b and power m to separate it into.
 * We'll pick base = 10, and m to be half the length of the digits of the numbers in this implementation of the algorithm.
 * 	In this case, m will be 2, so 10^2 = 100. We will split the 2 numbers using this multiplier.
 * The form we want is:
 * x = x1*b^m + x0
 * y = y1*b^m + y0
 * ----------
 * Using the above example,
 * x1 = 123
 * x0 = 45
 * ----------
 * y1 = 67
 * y2 = 89
 * ----------
 * b = 10 and m = 2
 * ----------
 * Thus:
 * 12345 = 123 * 10^2  +  45
 * 6789 =   67 * 10^2  +  89
 *
 *
 * The recursive algorithm is as follows:
 *
 * If x<10 or y<10, return x*y. Single digit multiplication is the base case.
 * Otherwise:
 * Let z2 = karatsuba(x1, y1). x1 and y1 are the most significant digits, and are the local variables "high".
 * Let z0 = karatsuba(x0, y0). x0 and y0 are the least significant digits, and are the local variables "low".
 * Let z1 = karatsuba(x1+y0, x0+y1) - z0 - z2.
 * And the result is the following sum:
 * z2 * b^2m	+	z1 * b^m	+	z0
 *
 * @param x The multiplicand.
 * @param y The multiplier.
 * @return The product.
 */

public class Karatsuba {
    public static String[] strCopy(long index, String string) {
        String	first = "",
                last = "";
        long actualIndex = string.length() - index;
        for (int i = 0; i<actualIndex; i++) {
            first+=string.charAt(i);
        }
        for (int i = (int)actualIndex; i<string.length(); i++) {
            last+=string.charAt(i);
        }
        return new String[] {first, last};
    }

    public static long karatsuba(long x, long y) {
        if (x<10 || y<10) {
            return x * y;
        }

        String xString = Integer.toString((int)x);
        String yString = Integer.toString((int)y);
        long m = Math.max(xString.length(), yString.length()),
            m2 = m/2,
            high1 = Integer.parseInt(strCopy(m2, xString)[0]), // the most significant digits. this is the scalar multiplier for b^m2
            low1 = Integer.parseInt(strCopy(m2, xString)[1]), // the least significant digits. this is what is added on to high1*b^m2
            high2 = Integer.parseInt(strCopy(m2, yString)[0]), // same for y
            low2 = Integer.parseInt(strCopy(m2, yString)[1]), // same for y

            // Three recursive calls
            z0 = karatsuba(low1, low2), // z0 = x0y0
            z2 = karatsuba(high1, high2), // z2 = x1y1
            z1 = karatsuba((low1 + high1), (low2 + high2)) - z2 - z0; // z1 = (x0 + y1)*(x1 + y0) - z2 - z0, courtesy of Karatsuba

        return (long) (z2 * Math.pow(10, 2*m2) + (z1 * Math.pow(10, m2)) + z0);

    }

    public static void main(String[] args) {
        System.out.println(karatsuba(200, 200));
        System.out.println(karatsuba(12345, 6789));
        System.out.println(karatsuba(2358925, 1259174));
    }
}
