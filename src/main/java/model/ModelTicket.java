package model;

import java.io.File;

public class ModelTicket {

    private File file;

    public ModelTicket(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

}
