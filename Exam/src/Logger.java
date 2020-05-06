import java.io.File;
	import java.io.IOException;
	import java.util.logging.FileHandler;
	import java.util.logging.Logger;
	import java.util.logging.SimpleFormatter;
public class Logger {
	
	




	public class Log {
		public Logger logger;
		FileHandler fh;
		
		public Log(String file_name) throws SecurityException, IOException
		{
			File f=new File(file_name);
			if(!f.exists())
			{
				f.createNewFile();
			}
			
			fh=new FileHandler(file_name, true);
			logger=Logger.getLogger("test");
			logger.addHandler(fh);
			SimpleFormatter formatter=new SimpleFormatter();
			fh.setFormatter(formatter);
		}

	}
	
	
	ublic static void main(String[] args) {

		String_Calculator obj=new String_Calculator();
		int Result=obj.Add("2\n1");
		//System.out.println(res);
		Log my_log;
		try {
			my_log = new Log("log.txt");
			my_log.logger.info("The sum is: "+res);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
