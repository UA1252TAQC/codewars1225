package org.academy.codewars.entities.models;

import org.academy.codewars.entities.Author;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class SupplierWrapper<T> {
    private final BiFunction<Author, List<Object>, T> supplier;

    public SupplierWrapper(BiFunction<Author, List<Object>, T> supplier) {
        this.supplier = supplier;
    }

    public String applyString(Author author, List<Object> params) {
        final T result = supplier.apply(author, params);
        if (result == null) return null;
        if (!result.getClass().isArray()) {
            return String.valueOf(result);
        }

        return switch (result) {
            case int[] ints -> Arrays.toString(ints);
            case double[] doubles -> Arrays.toString(doubles);
            case float[] floats -> Arrays.toString(floats);
            case long[] longs -> Arrays.toString(longs);
            case short[] shorts -> Arrays.toString(shorts);
            case byte[] bytes -> Arrays.toString(bytes);
            case char[] chars -> Arrays.toString(chars);
            case boolean[] booleans -> Arrays.toString(booleans);
            default -> Arrays.deepToString((Object[]) result);
        };
    }
}

