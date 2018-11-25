import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
 
public class getMessage {
	public static Connection conn = null;
 
    public static void main(String[] args) throws IOException{
        
        getMessage ss = new getMessage();
        ss.ServerRun();
    }
 
    public void ServerRun() throws IOException{
    	String dbdata[] = new String[3];
    
        ServerSocket server = null;
        int port = 4200;
        Socket socket = null;
        
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        
        try {
            server = new ServerSocket(port);
            while(true){
                socket = server.accept();
                
                is = socket.getInputStream();
                isr = new InputStreamReader(is);
                br = new BufferedReader(isr);
                
                String data;
                
                int i = 0;
                while((data=br.readLine()) != null) {
                	dbdata[i] = data;
                	
                	i++;
                	if(i == 3) break;
                }
                
                saveData(dbdata);
                receiveData("성공", socket);
            }
        } catch (Exception e) {
        	e.printStackTrace();
        } finally {
        	try {
        		br.close();
        		isr.close();
                is.close();
                server.close();
        	}catch(Exception e){
        		e.printStackTrace();
        	}
        }
	}
    
    public void saveData(String[] data) throws ClassNotFoundException, SQLException {
    	Class.forName("org.sqlite.JDBC");
		conn = DriverManager.getConnection("jdbc:sqlite:" + "dormitory.db");
		
		PreparedStatement ps = conn.prepareStatement("INSERT INTO message VALUES(?, ?, ?)");

		ps.setString(1, data[0]);
		ps.setString(2, data[1]);
		ps.setString(3, data[2]);
		
		int res = ps.executeUpdate();
		
		if(res == 1) System.out.println(String.format("%d row insert success", res));
		
		ps.close();

		conn.close();
    }
    
    public void receiveData(String data, Socket socket){
        OutputStream os = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        
        try {
            os = socket.getOutputStream();
            osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);
            
            bw.write(data); 
            bw.flush();
        } catch(Exception e1) {
            e1.printStackTrace();
        } finally {
            try {
                bw.close();
                osw.close();
                os.close();
                socket.close();
            } catch(Exception e1){
                e1.printStackTrace();
            }
        }
    }    
}