import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class ServerSentFile implements Runnable {
    public final static int port1 = 12345;
    public final static int port2 = 12346;
    public final static int port3 = 12347;
    public final static int port4 = 12348;







    private String id="";
    private FileInputStream fileInputStream = null;
    private BufferedInputStream bufferedInputStream = null;
    private File file =null;
    private OutputStream outputStream = null;
    private OutputStream outputStream1 = null;
    private OutputStream outputStream2 = null;
    private ServerSocket serverSocket = null;
    private ServerSocket serverSocket1 = null;
    private ServerSocket serverSocket2 = null;
    private ServerSocket serverSocket3 = null;
    private Socket socket = null;
    private Socket socket1 = null;
    private Socket socket2 = null;
    private Socket socket3 = null;
    private BufferedWriter bufferedWriter = null;
    private BufferedWriter bufferedWriter1 = null;
    private BufferedWriter bufferedWriter2 = null;
    private OutputStreamWriter outputStreamWriter = null;
    private OutputStreamWriter outputStreamWriter1 = null;
    private OutputStreamWriter outputStreamWriter2 = null;
    private List<Test> testList;
    private int time;
    private Thread thread;
    private boolean isWorking=true;


    public void setWorking(boolean working) {
        isWorking = working;
    }

    public int getTime() {
        return time;
    }
    public void setTime(int time) {
        this.time = time;
    }
    public List<Test> getTestList() {
        return testList;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setTestList(List<Test> testList) {
        this.testList = testList;
    }



    @Override
    public void run() {


                try {
                    serverSocket = new ServerSocket(port1);

                    System.out.println("acceptred");

                    serverSocket1 = new ServerSocket(port2);

                    System.out.println("acceptred");

                    serverSocket2 = new ServerSocket(port3);

                    System.out.println("acceptred");

                    serverSocket3 = new ServerSocket(port4);

                    System.out.println("acceptred");}
                    catch (BindException b)
                    {
                        System.exit(1);
                    }
         catch (IOException e) {
            e.printStackTrace();
        }

        while (isWorking) {
            try {


                socket=serverSocket.accept();
                System.out.println("acceptred"+socket);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {

                socket1 = serverSocket1.accept();
                System.out.println("acceptred"+socket1);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {

                socket2 = serverSocket2.accept();
                System.out.println("acceptred"+socket2);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {

                socket3 = serverSocket3.accept();
                System.out.println("acceptred"+socket3);
            } catch (IOException e) {
                e.printStackTrace();
            }
            sendId();
          //  createNewFile();
         //   writeToTheFile();
            sendSize();
            sendFile();
            sendTime();
 {



}

        }
            stopServerSocket();
            stopSocket();
    }

    public void start() {
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }

    public void sendSize() {
        {
            try {


                System.out.println("aceepted" + socket);
                outputStream = socket.getOutputStream();
                outputStreamWriter = new OutputStreamWriter(outputStream);
                bufferedWriter = new BufferedWriter(outputStreamWriter);
                String message = String.valueOf((int) file.length());
                bufferedWriter.write(message);
                System.out.println("sent " + file.length());
                bufferedWriter.flush();
                System.out.println("Integer is sent");

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                 {
                    try {
                        if (outputStream != null)   outputStream.close();
                        if (outputStreamWriter != null) outputStreamWriter.close();
                        if (bufferedWriter != null) bufferedWriter.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
            }


        }

    public void sendId() {
        {
            try {
                System.out.println("aceeptde" + socket2);
                outputStream1 = socket2.getOutputStream();
                outputStreamWriter1 = new OutputStreamWriter(outputStream1);
                bufferedWriter1 = new BufferedWriter(outputStreamWriter1);
                id=file.getName();
                bufferedWriter1.write(id);
                System.out.println("sent " + id);
                bufferedWriter1.flush();
                System.out.println("ID is sent");

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                { try {
                    if (outputStream1 != null)   outputStream1.close();
                    if (outputStreamWriter1 != null) outputStreamWriter1.close();
                    if (bufferedWriter1 != null) bufferedWriter1.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        }


    }

    public void sendFile() {
        try {

            System.out.println("agsdfgh");


            System.out.println("aceepted" + socket1);


                fileInputStream = new FileInputStream(file);
                bufferedInputStream = new BufferedInputStream(fileInputStream);
                byte[] mybytes = new byte[(int) file.length()];
                bufferedInputStream.read(mybytes, 0, (int) file.length());
                outputStream = socket1.getOutputStream();
                outputStream.write(mybytes, 0, (int) file.length());
                outputStream.flush();
                System.out.println("file is sent");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally
        {
            try {

                if (outputStream != null) outputStream.close();
                if (fileInputStream != null) fileInputStream.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void writeToTheFile() {
        try {
            FileOutputStream out = new FileOutputStream(file);
            ObjectOutputStream outputStream = new ObjectOutputStream(out);
            outputStream.writeObject(testList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setFile(File file) {
        this.file = file;
    }

    public  void createNewFile() {
        file = new File(id);
        file.mkdir();
        file = new File(file.getAbsolutePath() + "/test.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("File is created");

    }
    public void sendTime() {
        {
            try {


                System.out.println("aceepted" + socket3);
                outputStream2 = socket3.getOutputStream();
                outputStreamWriter2 = new OutputStreamWriter(outputStream2);
                bufferedWriter2 = new BufferedWriter(outputStreamWriter2);
                String message = String.valueOf((time));
                bufferedWriter2.write(message);
                System.out.println("sent " + time);
                bufferedWriter2.flush();
                System.out.println("Time is sent");

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                {
                    try {
                        if (outputStream2 != null)   outputStream2.close();
                        if (outputStreamWriter2 != null) outputStreamWriter2.close();
                        if (bufferedWriter2 != null) bufferedWriter2.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        }


    }
    public  void stopServerSocket()
    {
        try {
            serverSocket.close();
            serverSocket1.close();
            serverSocket2.close();
            serverSocket3.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void stopSocket()
    {

        try {
            socket.close();
            socket1.close();
            socket2.close();
            socket3.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}


