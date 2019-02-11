package main;

import static org.junit.Assert.*;

import org.junit.Test;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import main.Hostel;
public class HostelTest {


	Hostel h;
	@SuppressWarnings("static-access")
	@Test
	public void hostelAllotTest() throws IOException {
		BufferedWriter out = null;
		 try {
             out = new BufferedWriter(new FileWriter("hostel.txt", true));
                 out.write("test1 1");
                 out.newLine();
         } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
             if(out!=null){
                 out.close();
             }
         }	
		 h.allotHostel();
		 boolean chk= true;
			try{
	       		BufferedReader br = new BufferedReader(new FileReader("allotedhostel.txt"));
	                   
	            String line = null;
	           while ((line = br.readLine()) != null) {
	               String[] splited = line.split("\\s+");
	                   if(splited[0].equals("test1")){
	                	  chk = false;
	                	   assertEquals("test1",splited[0]);
	                	   break;
	                   }
	               }
	           }catch(Exception e){
	               System.out.println(e);
	           }
			if(chk) {
				assertEquals("test1","xw");
			}
	}
}
