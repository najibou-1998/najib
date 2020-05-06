import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.FileHandler;

import java.util.logging.SimpleFormatter;




public class Logger {
	
	




	
		public Logger logger;
		private FileHandler filehandler;
		
		public Logger(String file) throws SecurityException, IOException
		{
			File f=new File(file);
			if(!f.exists())
			{
				f.createNewFile();
			}
			
			filehandler=new FileHandler(file, true);
			logger=Logger.getLogger("test");
			logger.addHandler(filehandler);
			SimpleFormatter simpleformatter=new SimpleFormatter();
			filehandler.setFormatter(simpleformatter);
		}


	
	
	public static void main(String[] args) {

		String_Calculator Stringcalcul=new String_Calculator();
		int Result=Stringcalcul.Add("7\n21");
	
		Log my_log;
		try {
			my_log = new Logger("logger.txt");
			my_log.logger.info("the addition equals to : "+Result);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
