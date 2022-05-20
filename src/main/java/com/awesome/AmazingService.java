package com.awesome;

import java.io.File;

public class AmazingService {

    public DataFileMetadata miew() {
        var customer = 1L;
        var fileLocation = "/tmp/somewhere";
        var dataFileMetadata = new DataFileMetadata(customer, new File(fileLocation));

        return dataFileMetadata;
    }

}
