package com.awesome;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class DataFileMetadata {

    private long customerId;
    private String type;
    private File f;
    private String contents;

    private void loadContents(){
        try {
            contents = loadFromFile();
        }catch(IOException e){
            throw new RuntimeException(e);
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

    public String getContents() {
        if (contents == null) {
            loadContents();
        }
        return contents;
    }
}
