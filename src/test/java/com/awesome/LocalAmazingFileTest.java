package com.awesome;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class LocalAmazingFileTest {

    @TempDir
    Path tempDir;

    @Test
    public void createFile() throws IOException {
        var path = Files.createFile(tempDir.resolve("test-content.txt"));
        Files.writeString(path, "amazing content", StandardOpenOption.APPEND);

        var file = new LocalAmazingFile(path);

        assertThat(Files.exists(path)).isTrue();
        assertThat(file.getContent()).isEqualTo("amazing content");
    }


    @Test
    public void memoizeContent() throws IOException {
        var path = Files.createFile(tempDir.resolve("test-memoize.txt"));
        Files.writeString(path, "amazing content", StandardOpenOption.APPEND);

        var file = new LocalAmazingFile(path);

        assertThat(file.getContent()).isEqualTo("amazing content");
        Files.writeString(path, "updated", StandardOpenOption.APPEND);
        assertThat(file.getContent()).isEqualTo("amazing content");

    }
}
