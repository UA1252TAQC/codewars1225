package org.academy.kata.implementation.ol271176;

import org.academy.kata.Seven;

public class SevenImpl implements Seven {
    @Override
    public long newAvg(double[] arr, double navg) {
        return 0;
    }

    @Override
    public String seriesSum(int n) {
        if(n == 0 ) return "0.00";
        double result = 0;
        int cnt = 1;
        for(int i = 1; i <= n; i++){
            result += 1.0/cnt;
            cnt += 3;
        }
        return String.format("%.2f",result);
    }
}
