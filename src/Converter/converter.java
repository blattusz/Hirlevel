package Converter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class converter {
	
	
	public static String html = "fghj";
	private static final String FILENAME = "html.txt";
	
	public static void HtmlConverter()
	{
		BufferedReader br = null;
		BufferedWriter bw = null;
		FileReader fr = null;
		
		
		
		try {
	        FileOutputStream fos = new FileOutputStream("html.txt");
	        Writer out = new OutputStreamWriter(fos, "UTF8");
	        out.write(html);
	        out.close();
	    } 
	    catch (IOException e) {
	        e.printStackTrace();
	    }
		

		
		String oldFileName = "html.txt";
		String tmpFileName = "html2.txt";



		try {
			br = new BufferedReader(new FileReader(oldFileName));
			bw = new BufferedWriter(new FileWriter(tmpFileName));
			String line;
			while ((line = br.readLine()) != null) {
				if (line.contains("\""))
					line = line.replace("\"", "\"");

				bw.write(line);

			}
		} catch (Exception e) {
			return;
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException e) {
				//
			}
			try {
				if (bw != null)
					bw.close();
			} catch (IOException e) {
				//
			}
		}
		// Once everything is complete, delete old file..
		File oldFile = new File(oldFileName);
		oldFile.delete();

		// And rename tmp file's name to old file name
		File newFile = new File(tmpFileName);
		newFile.renameTo(oldFile);

		

		
		
		


		try {

			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			String sCurrentLine;

			br = new BufferedReader(new FileReader(FILENAME));

			while ((sCurrentLine = br.readLine()) != null) {
				html = sCurrentLine;
			}
		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
	}
	
	

}
