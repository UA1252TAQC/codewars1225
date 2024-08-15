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
        T result = supplier.apply(author, params);
        if (result == null) {
            return null;
        }
        if (!result.getClass().isArray()) {
            return String.valueOf(result);
        }

        if (result instanceof int[]) {
            return Arrays.toString((int[]) result);
        } else if (result instanceof double[]) {
            return Arrays.toString((double[]) result);
        } else if (result instanceof float[]) {
            return Arrays.toString((float[]) result);
        } else if (result instanceof long[]) {
            return Arrays.toString((long[]) result);
        } else if (result instanceof short[]) {
            return Arrays.toString((short[]) result);
        } else if (result instanceof byte[]) {
            return Arrays.toString((byte[]) result);
        } else if (result instanceof char[]) {
            return Arrays.toString((char[]) result);
        } else if (result instanceof boolean[]) {
            return Arrays.toString((boolean[]) result);
        } else {
            return Arrays.deepToString((Object[]) result);
        }
    }
}

