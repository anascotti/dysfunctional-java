package com.awesome;

import static com.awesome.types.Functions.log;
import static com.awesome.types.Log.logDataFileMetadata;

import java.io.IOException;
import java.nio.file.Path;

public class AmazingService {

    public FileMetadata createLocalFile(
        User user,
        String path,
        String content
    ) {
        var file = new LocalAmazingFile(Path.of(path));
        try {
            file.writeContent(content);
        } catch (IOException e) {
            e.printStackTrace();
        }

        var dataFileMetadata = new FileMetadata(user.id(), file);
        System.out.println(log(dataFileMetadata, logDataFileMetadata()));
        System.out.println(log(dataFileMetadata, FileMetadata::toString));
        System.out.println(file.getContent());

        return dataFileMetadata;
    }


}
