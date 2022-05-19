package com.awesome;

import cyclops.control.Eval;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.function.Supplier;

public class DataFileMetadata {

    private long id;
    private File f;
    private String content;

    private Supplier<String> contentSupplier = Eval.later(this::loadContent);

    public DataFileMetadata(final long customerId, final File f) {
        this.id = customerId;
        this.f = f;
    }

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

    public long getId() {
        return id;
    }

    public String getContent() {
        return contentSupplier.get();
    }
}
