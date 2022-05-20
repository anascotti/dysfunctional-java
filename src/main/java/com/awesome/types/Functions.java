package com.awesome.types;

public final class Functions {

    public static <A> String log(A a, Log<A> sh) {
        return sh.show(a);
    }
}
