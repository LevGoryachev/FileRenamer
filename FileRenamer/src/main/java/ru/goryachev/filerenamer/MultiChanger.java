package ru.goryachev.filerenamer;

import java.io.File;

public class MultiChanger {
	
	public void multiChange () {
				
		
		File [] fileList;
				
        File filesPath = new java.io.File("C:\\10\\");
         
        fileList = filesPath.listFiles(); // From the folder to array
                 
        
        for(int i=0; i<fileList.length; i++){
        	
        	int number = 1;
        	number = number + i;
        	
            String bufferedName = fileList[i].getName(); // read the current name
            	
            	bufferedName = bufferedName.replaceFirst("(.*)(.*)", "IMG_pict" + "_" + number + ".jpg");
            	
                fileList[i].renameTo(new File("C:\\10\\"+bufferedName));
            
        }
	
	}
}

