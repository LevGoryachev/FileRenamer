package ru.goryachev.filerenamer;

import java.io.File;

public class MultiChanger {
			
	File path;
	String name;
	String ext;
	int numbFrom;
		
	public MultiChanger (File path, String name, String ext, int numbFrom) {
		
		this.path = path;
		this.name = name;
		this.ext = ext;
		this.numbFrom = numbFrom;		
	}
	
	public void multiChange () {
		
		File [] fileList;
				         
        fileList = path.listFiles(); // From the folder to array
        
        for(int i=0; i<fileList.length; i++){
        	
        	numbFrom = numbFrom + i;
        	
            String bufferedName = fileList[i].getName(); // read the current name
           
            	bufferedName = bufferedName.replaceFirst("(.*)", name + "_" + numbFrom + "." + ext);
            	           	
            	String io = fileList[i].getAbsolutePath();
            	
                fileList[i].renameTo(new File(path + "\\" + bufferedName));
        }
	}
}
