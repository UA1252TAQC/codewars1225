package org.academy.kata.implementation.ol271176;

import org.academy.kata.Seven;

public class SevenImpl implements Seven {
    @Override
    public long newAvg(double[] arr, double navg) {
        double arrSum = 0;
        for(double e : arr){
            arrSum += e;
        }
        long result = (long) Math.ceil(navg*(arr.length+1) - arrSum);
        if(result > 0){
            return result;
        }else{
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String seriesSum(int n) {
        return "";
    }
}
