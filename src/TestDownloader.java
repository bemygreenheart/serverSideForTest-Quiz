import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TestDownloader {
    private List<Test> testList;
    private String testName;
    private static final Scanner scanner = new Scanner(System.in);

    public TestDownloader() {

    }

    public void setTestName(String testName) {
        this.testName = testName;

    }

    public void writeToTheFile(LinkedList<Test> quiz) {
        try {
            File file = new File("myTests\\" + testName + ".txt");
            file.createNewFile();

            FileOutputStream out = new FileOutputStream(file);
            ObjectOutputStream outputStream = new ObjectOutputStream(out);
            outputStream.writeObject(quiz);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File[] getTests() {
        File file = new File("Tests\\");
        File[] myFiles = file.listFiles();
        return myFiles;
    }

    public String[] getTestNames() {
        File file = new File("Tests\\");
        return file.list();
    }

}
