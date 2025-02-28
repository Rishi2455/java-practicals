import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws UnknownHostException, IOException {
        try {
            Scanner sc = new Scanner(System.in);
            Socket s = new Socket("localhost", 9000);
            System.out.println("Connected to server...");
            DataInputStream dataInputStream = new DataInputStream(s.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(s.getOutputStream());
            while (true) {
                System.out.print("Enter the name of movie: ");
                String name = sc.nextLine();
                if (name.equals("exit")) {
                    break;
                }
                dataOutputStream.writeUTF(name);
                String result = dataInputStream.readUTF();
                System.out.println(result);
                System.out.println();
            }
            System.out.println("Connection closed...");
            sc.close();
            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
