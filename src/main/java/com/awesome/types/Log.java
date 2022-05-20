package com.awesome.types;

import com.awesome.FileMetadata;

public interface Log<A> {
    String show(A a);

    static Log<FileMetadata> logDataFileMetadata() {
        return df -> String.format(
            "{ %s, %s }",
            df.userId(),
            df.location().uri());
    }
}
