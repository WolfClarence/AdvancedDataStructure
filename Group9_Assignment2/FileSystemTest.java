import java.io.IOException;

// Test class to verify the functionality of the file system.
// FileSystemTest.java
// A simple test class to verify the FileSystem
public class FileSystemTest {
    public static String filename="files.csv";
    //57535404.txt,86
    //99908163.txt,155
    //63688241.txt,91
    //99022269.txt,138
    //27956016.txt,177
    public static String[] filenames= {"57535404.txt","99908163.txt",
    "63688241.txt","99022269.txt","27956016.txt"};

    public static void main(String[] args) throws IOException {
        FileSystem fileSystem=new FileSystem();
        fileSystem.readFile(filename);
        for (String s : filenames) {
            fileSystem.getFileSize(s);
        }
    }
}
