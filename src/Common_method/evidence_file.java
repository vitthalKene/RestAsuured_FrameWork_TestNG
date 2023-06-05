package Common_method;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class evidence_file {
	
	public static void evidence_file (String file, String requestBody, String responseBody) throws IOException
	{
		File newFile=new File("C:\\Users\\Vitthal\\OneDrive\\Desktop\\Evdence\\" +file);
	    if (newFile.createNewFile())
	    {
	    	location_file.location(file, requestBody, responseBody);
	    }
	    else
	    {
	    	 System.out.println("this file already exists,hence deleting and recreating:" +newFile.getName());
			 newFile.delete();
			 
		   location_file.location(file, requestBody, responseBody);			 
	    }
	}

}
