package com.navjot.storage;

import java.io.FileOutputStream;

/**
 * Created by navsin on 3/29/2016.
 */
public class FileStorageHelper {

    private FileOutputStream outputStream;

    public FileStorageHelper(FileOutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void writeCSVString(String csvString) {
        try {
            outputStream.write(csvString.getBytes());
        } catch (Exception ex) {

        }
    }

    public void closeStream() {
        try {
            outputStream.close();
        }
        catch (Exception ex) {

        }
    }
}
