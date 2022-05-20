package com.awesome;

public class FileMetadata {

    private final String userId;
    private final FileLocation location;

    public FileMetadata(final String userId, final AmazingFile f) {
        this.userId = userId;
        this.location = f.location();
    }

    public String userId() {
        return userId;
    }

    public FileLocation location() {
        return location;
    }

    public FileMetadata withFile(AmazingFile f) {
        return this.location == f.location() ? this : new FileMetadata(userId, f) ;
    }

}
