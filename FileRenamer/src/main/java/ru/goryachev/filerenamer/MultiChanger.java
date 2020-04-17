package ru.goryachev.filerenamer;

import java.io.File;

public class MultiChanger {
	
	String path;
	String name;
	String ext;
	int numbFrom;
	
	
	public MultiChanger (String path, String name, String ext, int numbFrom) {
		
		this.path = path;
		this.name = name;
		this.ext = ext;
		this.numbFrom = numbFrom;
		
	}

	
	public void multiChange () {
		
		File [] fileList;
				
		File filesPath = new java.io.File(path);
         
        fileList = filesPath.listFiles(); // From the folder to array
        
        for(int i=0; i<fileList.length; i++){
        	
        	int number = numbFrom;
        	number = number + i;
        	
            String bufferedName = fileList[i].getName(); // read the current name
            
           
            	bufferedName = bufferedName.replaceFirst("(.*)(.*)", name + "_" + number + "." + ext);
            	            	
            	
                fileList[i].renameTo(new File(path+bufferedName));
        }
	}
}

