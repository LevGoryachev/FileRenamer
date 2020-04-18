package ru.goryachev.filerenamer;

import java.awt.Component;
import java.awt.Container;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.File;
import java.nio.file.Path;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class RenamerWindow extends JFrame {

	private JTextField nameField;
	private JTextField extField;
	private JTextField numberField;
	private JTextArea fileArea;
	
	private String newName;
	private String newExt;
	private int fromNo;
	private File path;
	private JButton renamerButton;
	
	RenamerWindow () {
			
		Container Pane = this.getContentPane();
		SpringLayout layout = new SpringLayout();
        Pane.setLayout(layout);
        
		Component nameLabel = new JLabel("Новое имя");
		Pane.add(nameLabel);
		this.nameField = new JTextField(38);
		Pane.add(nameField);
				
		Component extLabel = new JLabel("Новое расширение");
		Pane.add(extLabel);
		this.extField = new JTextField(10);
		Pane.add(extField);
						
		Component numberLabel = new JLabel("Начать отсчет нумерации файлов с ");
		Pane.add(numberLabel);
		this.numberField = new JTextField(10);
		Pane.add(numberField);
		
		this.renamerButton = new JButton("Выбрать папку в которой лежат файлы");
		Pane.add(renamerButton);
		renamerButton.addActionListener(btnClick);
		
		layout.putConstraint(SpringLayout.WEST , nameLabel, 10, SpringLayout.WEST , Pane);
		layout.putConstraint(SpringLayout.NORTH, nameLabel, 25, SpringLayout.NORTH, Pane);
		layout.putConstraint(SpringLayout.NORTH, nameField, 25, SpringLayout.NORTH, Pane);
		layout.putConstraint(SpringLayout.WEST , nameField, 20, SpringLayout.EAST , nameLabel);
		
		layout.putConstraint(SpringLayout.WEST , extLabel, 20, SpringLayout.EAST , nameField);
		layout.putConstraint(SpringLayout.NORTH, extLabel, 25, SpringLayout.NORTH, Pane);
		layout.putConstraint(SpringLayout.NORTH, extField, 25, SpringLayout.NORTH, Pane);
		layout.putConstraint(SpringLayout.WEST , extField, 20, SpringLayout.EAST , extLabel);
		
		layout.putConstraint(SpringLayout.WEST , numberLabel, 250, SpringLayout.WEST , Pane);
		layout.putConstraint(SpringLayout.NORTH, numberLabel, 50, SpringLayout.NORTH, Pane);
		layout.putConstraint(SpringLayout.NORTH, numberField, 50, SpringLayout.NORTH, Pane);
		layout.putConstraint(SpringLayout.WEST , numberField, 20, SpringLayout.EAST , numberLabel);
		
		layout.putConstraint(SpringLayout.WEST , renamerButton, 300, SpringLayout.WEST , Pane);
		layout.putConstraint(SpringLayout.NORTH, renamerButton, 125, SpringLayout.NORTH, Pane);		
		
		setLocation(250, 400);
		setSize(850, 250);
		setTitle("FILE RENAMER by Lev Goryachev");
		setVisible(true);
		setResizable(false);
	}
	
	ButtonListener btnClick = new ButtonListener();
		
	public class ButtonListener implements ActionListener{
	
		 public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == renamerButton) {
			
				newName =  nameField.getText();
				newExt = extField.getText();
				fromNo = Integer.parseInt(numberField.getText());
				
				JFileChooser chooseFolder = new JFileChooser();             
				chooseFolder.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int choice = chooseFolder.showOpenDialog(RenamerWindow.this);
			
				if (choice == JFileChooser.APPROVE_OPTION ) {
					JOptionPane.showMessageDialog(RenamerWindow.this, "Переименовать все файлы в выбранной папке??? " + "\n" + chooseFolder.getSelectedFile());
					
					path =  chooseFolder.getSelectedFile();
                                                
						MultiChanger multichanger = new MultiChanger(path, newName, newExt, fromNo);
						multichanger.multiChange();
                
				}
			}
		
		}
		
	}

}