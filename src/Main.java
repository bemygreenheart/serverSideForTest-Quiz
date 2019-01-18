import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        List<Test> testList=new LinkedList<>();
//        testList.add(new Test("shdgfchsdhf","asd","asd","ser","aeff",1));
//        testList.add(new Test("shdgfcdhf","asdsf","assdfsd","sesdfr","aefffe",3));
//        ServerSentFile file = new ServerSentFile();
//        file.setId("U17100");
//        file.setTime(10);
//        file.setTestList(testList);
//        Thread thread = new Thread(file);
//        thread.start();

        JFrame frame= new JFrame();
        frame.setVisible(true);
        //frame.setSize(1600,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        WelcomePanel welcomePanel= new WelcomePanel(frame);
        frame.add(welcomePanel);
        frame.pack();


    }

}
