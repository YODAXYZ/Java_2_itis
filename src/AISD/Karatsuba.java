package AISD;
// T(n) O(n^2/3)


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
            high1 = Integer.parseInt(strCopy(m2, xString)[0]),
            low1 = Integer.parseInt(strCopy(m2, xString)[1]),
            high2 = Integer.parseInt(strCopy(m2, yString)[0]),
            low2 = Integer.parseInt(strCopy(m2, yString)[1]),

            z0 = karatsuba(low1, low2),
            z2 = karatsuba(high1, high2),
            z1 = karatsuba((low1 + high1), (low2 + high2)) - z2 - z0;

        return (long) (z2 * Math.pow(10, 2*m2) + (z1 * Math.pow(10, m2)) + z0);

    }

    public static void main(String[] args) {
        System.out.println(karatsuba(200, 200));
        System.out.println(karatsuba(12345, 6789));
        System.out.println(karatsuba(2358925, 1259174));
    }
}
