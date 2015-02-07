package outils;

import java.io.*;
import java.util.ArrayList;

public class LecteurFichier
{
	  public static ArrayList<String> read(String fichier)
	    {
	        ArrayList<String> ch = new ArrayList<String>();
	        try
	        {
	            InputStream ips = new FileInputStream(fichier); 
	            InputStreamReader ipsr = new InputStreamReader(ips);
	            BufferedReader br = new BufferedReader(ipsr);
	            int c = 0;
	            int i = 0;
	            char lastCar = 0;
	            ch.add("");
	            while((c = br.read()) != -1)
	            {
	                if((char)c != ';')
	                {
	                    String s = ch.get(i);
	                    s += (char)c;
	                    ch.set(i, s);
	                }
	                else
	                {
	                    i++;
	                    ch.add("");
	                }
	                lastCar = (char)c;
	            }
	            if(lastCar == ';')
	            	ch.remove(ch.size()-1);
	            br.close(); 
	        }        
	        catch (Exception e){
	            System.out.println(e.toString());
	        }
	        return ch;
	    }
}
