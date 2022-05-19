package com.awesome;

import java.io.IOException;

public class DataFileUnavailableException extends RuntimeException {
    public DataFileUnavailableException(final IOException e) {
    }
}
