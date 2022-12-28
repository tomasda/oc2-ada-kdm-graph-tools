
import org.apache.commons.io.FileUtils;
import org.scalatest.flatspec.AnyFlatSpec;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public abstract class TestsUtils extends AnyFlatSpec {

    protected List<File> allFiles() throws IOException {
        return allFiles("samples");
    }

    protected List<File> allFiles(String folder) throws IOException {
        return Files.walk(Paths.get(folder))
                .filter(Files::isRegularFile)
                .map(Path::toFile)
                .collect(Collectors.toList());
    }

    protected List<String> allCodes() throws IOException {
        return allCodes("samples");
    }

    protected List<String> allCodes(String folder) throws IOException {
        return allFiles(folder).stream()
                .map(this::getCode)
                .collect(Collectors.toList());
    }

    protected String getCode(File file) {
       try {
            return FileUtils.readFileToString(file, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    protected void writeFile(String fileName, String content)
            throws IOException {
        FileOutputStream outputStream = new FileOutputStream(fileName);
        byte[] strToBytes = content.getBytes();
        outputStream.write(strToBytes);
        outputStream.close();
    }

}
