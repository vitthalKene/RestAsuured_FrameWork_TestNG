import Testcase.get_tc;
import Testcase.post_practice_new;
import Testcase.post_tc;


import java.io.IOException;

import Common_method.excel_data_extractor;
import Common_method.location_file;

public class Driver_class {

	public static void main(String[] args) throws IOException { 
		// TODO Auto-generated method stub
		
		// post_tc.post_executer();
		excel_data_extractor.getdata("Excel_data", "post_tc", "value_tc5" );
		
		//post_practice_new.post_practice();
	//get_tc.get_executor();
	}
}