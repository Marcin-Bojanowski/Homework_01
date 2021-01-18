package pl.coderslab.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

@Component
//@Primary
public class FileCustomerLogger implements CustomerLogger {

    private String filename;

//    @Autowired
    public FileCustomerLogger( String filename) {
        this.filename = filename;
    }


    public FileCustomerLogger() {

    }

    public String getFilename() {
        return filename;
    }
    @Autowired
    @Qualifier("secondFilename")
    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public void log() {
        Path path = Paths.get(filename);
        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
                Files.writeString(path, LocalDateTime.now() + ": Customer operation", StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {

            try {
                Files.writeString(path, "\n" + LocalDateTime.now() + ": Customer operation", StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
