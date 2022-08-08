package org.AttendanceSystem.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	private Properties p;
	public void intializepropertyfile(String filepath) {
		FileInputStream fis;
		try {
			fis = new FileInputStream(filepath);
			 p=new Properties();
			 try {
				p.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getpropertyfile(String key) {
		return p.getProperty(key).trim();
		
		
	}
}
