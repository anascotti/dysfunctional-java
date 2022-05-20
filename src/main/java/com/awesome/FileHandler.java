package com.awesome;

import java.io.IOException;

public interface FileHandler<T> {

    T writeContent(String content) throws IOException;

    String getContent() throws IOException;
}
