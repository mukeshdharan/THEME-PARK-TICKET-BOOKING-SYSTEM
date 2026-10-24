import java.io.*;
public class ReadTextFile{
    public static void main(String [] args) throws IOException{
        FileReader file=new FileReader("c:/test.txt");
        BufferedReader in= new BufferedReader(file);
        String line=in.readLine();
        while(line!=null){
            System.out.println(line);
            line=in.readLine();
        }
    }
    in.close();
}