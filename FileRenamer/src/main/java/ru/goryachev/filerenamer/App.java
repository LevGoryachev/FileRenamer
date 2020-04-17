package ru.goryachev.filerenamer;

import javax.swing.JFrame;

/**
 * FileRenamer by Lev Goryachev
 *
 */
public class App {
	
	
    public static void main( String[] args )    {
        
    	RenamerWindow window = new RenamerWindow();
    	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    	
    	
    	
    	MultiChanger multichanger = new MultiChanger("C:\\10\\", "IMAGE_pict", "jpg", 1);
		multichanger.multiChange();
    	    	
    }
}
