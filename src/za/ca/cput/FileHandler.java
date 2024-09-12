
package za.ca.cput;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
    private BufferedWriter bw;
    private FileWriter fw;
    
    public void openFile() 
    //open text file using FileWiter       
    {
        try {
            fw = new FileWriter("Output6.txt", true);  
            bw = new BufferedWriter(fw);
        
        } catch (IOException OP) {
            System.out.println("File not found...");
            System.out.println(OP);
        }
        
    }
    
    public void processFile(String rec) {
        try {
            bw.write(rec);
        
        }
        catch (IOException p) {
            System.out.println(p);
        }
        
    }
    
    public void closeFile() {
        //close FileWriter/BufferedWriter
        try {
            bw.close();
            
        } catch (IOException e) {
            System.out.println("Success");
        }
    }
    
}
