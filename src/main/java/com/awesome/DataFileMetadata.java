package com.awesome;

import static com.awesome.Memoize.memoizeSupplier;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.function.Supplier;

public class DataFileMetadata {

    private long customerId;
    private String type;
    private File f;
    private String content;

    private Supplier<String> contentSupplier = memoizeSupplier(this::loadContent);

    private String loadContent(){
        try {
            return content = loadFromFile();
        }catch(IOException e){
            throw new DataFileUnavailableException(e);
        }
    }
    private String loadFromFile() throws IOException {
        return new String(Files.readAllBytes(f.toPath()));
    }

    public long getCustomerId() {
        return customerId;
    }

    public String getType() {
        return type;
    }

    public File getF() {
        return f;
    }

    public String getContent() {
        return contentSupplier.get();
    }
}
