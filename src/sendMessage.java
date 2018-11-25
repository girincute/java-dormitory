import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
 
public class sendMessage {
 
    public static void main(String[] args) throws IOException{
        
        sendMessage cm = new sendMessage();
        cm.ClientRun(args);
    }
 
    public void ClientRun(String data[]){
        
        Socket socket = null;
        OutputStream os = null;
        OutputStreamWriter osw =null;
        BufferedWriter bw = null;
        
        InputStream is =null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        
        try{
            socket = new Socket("127.0.0.1", 4200);
            os = socket.getOutputStream();
            osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);
        
            is = socket.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            
            String txt = data[0] + "\n" + data[1] + "\n" + data[2];

            bw.write(txt);
            bw.newLine();
            bw.flush();
            
            String receiveData = "";
            receiveData = br.readLine();
            
            
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            try{
                bw.close();
                osw.close();
                os.close();
                br.close();
                isr.close();
                is.close();
            } catch(Exception e){
                e.printStackTrace();
            }
        }    
        
    }
    
}