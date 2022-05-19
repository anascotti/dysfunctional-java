package com.awesome;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class DataFileMetadataTest {

    @TempDir
    Path tempDir;

    @Test
    public void getContent() throws IOException {
        var path = Files.createFile(tempDir.resolve("test-content.txt"));
        Files.writeString(path, "amazing content", StandardOpenOption.APPEND);

        var dataFileMetadata = new DataFileMetadata(1L, path.toFile());

        assertThat(dataFileMetadata.getContent()).isEqualTo("amazing content");
    }

    @Test
    public void memoize() throws IOException {
        var path = Files.createFile(tempDir.resolve("test-memoize.txt"));
        Files.writeString(path, "amazing content", StandardOpenOption.APPEND);

        var dataFileMetadata = new DataFileMetadata(1L, path.toFile());

        assertThat(dataFileMetadata.getContent()).isEqualTo("amazing content");
        Files.writeString(path, "updated", StandardOpenOption.APPEND);
        assertThat(dataFileMetadata.getContent()).isEqualTo("amazing content");

    }
}
