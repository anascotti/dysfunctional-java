package com.awesome;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

public final class NotEfficientMemoize {
    public static <T> Supplier<T> memoizeSupplier(final Supplier<T> s) {
        final Map<String,T> lazy = new ConcurrentHashMap<>();
        return () -> lazy.computeIfAbsent("dummy", i-> s.get());
    }
}
