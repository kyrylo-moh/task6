package util;

import java.io.File;
import java.io.FileReader;

public class Validator {

    public String[] fileString(String string) {
        String[] fileString = string.split("\\s+");
        return fileString;
    }

    public boolean isFileExist(File file) {
        return  (file.exists() && file.isFile());
    }

    public boolean isEmptyFile(File file) {
        return (file.length() != 0);
    }

}
