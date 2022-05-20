package com.awesome.types;

import java.io.File;

public interface Empty<A> {
    A get();

    static Empty<File> emptyFile(){
        return () -> new File("");
    }
}
