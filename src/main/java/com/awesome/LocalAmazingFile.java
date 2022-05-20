package com.awesome;

import cyclops.control.Eval;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.cert.PKIXParameters;
import java.util.function.Supplier;

public class LocalAmazingFile implements AmazingFile, FileHandler<File> {

    private final Path path;
    private Supplier<String> contentSupplier = Eval.later(this::loadContent);

    public LocalAmazingFile(final Path path) {
        this.path = path;
    }

    @Override
    public File writeContent(final String content) throws IOException {
        return Files.writeString(path, content).toFile();
    }

    @Override
    public FileLocation location() {
        return new FileLocation(path.toString());
    }

    @Override
    public String getContent() {
        return contentSupplier.get();
    }

    private String loadContent() {
        try {
            return new String(Files.readAllBytes(path));
        }catch(IOException e){
            throw new DataFileUnavailableException(e);
        }
    }
}
