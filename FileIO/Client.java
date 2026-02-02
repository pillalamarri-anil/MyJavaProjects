package FileIO;

import java.io.*;

public class Client {

    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader("D:\\workspace\\JavaPractice\\src\\FileIO\\sample.txt");

        BufferedReader br = new BufferedReader(fr);

        String line;
        while( (line = br.readLine()) != null) {
            System.out.println(line);
        }

        FileWriter fw = new FileWriter("D:\\workspace\\JavaPractice\\src\\FileIO\\output.txt");

        try(BufferedWriter bw = new BufferedWriter(fw))
        {
        bw.write("hello world");
        bw.newLine();
        bw.write("welcome to java");
        bw.close();

        }
        catch (IOException e) {
        e.printStackTrace();
        }
    }
}
