package org.academy.kata;

import java.math.BigInteger;

public interface Five {
    long[] gap(int g, long m, long n);

    int zeros(int n);

    BigInteger perimeter(BigInteger n);

    double solve(double m);

    public long[] smallest(long n) {
        String numStr = Long.toString(n);
        long minVal = n;
        int minL = 0, minJ = 0;

        for (int i = 0; i < numStr.length(); i++) {
            char ch = numStr.charAt(i);
            StringBuilder sb = new StringBuilder(numStr);
            sb.deleteCharAt(i);

            for (int j = 0; j <= sb.length(); j++) {
                StringBuilder newSb = new StringBuilder(sb);
                newSb.insert(j, ch);
                long newVal = Long.parseLong(newSb.toString());

                if (newVal < minVal) {
                    minVal = newVal;
                    minL = i;
                    minJ = j;
                }
            }
        }
        return new long[]{minVal, minL, minJ};
    }

}
