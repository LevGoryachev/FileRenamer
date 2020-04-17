package ru.goryachev.filerenamer;

import java.awt.Component;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class RenamerWindow extends JFrame {

	RenamerWindow () {
		
		Container Pane = this.getContentPane();
		
		SpringLayout layout = new SpringLayout();
		Pane.setLayout(layout);
		
		Component nameLabel = new JLabel("Новое наименование");
		Pane.add(nameLabel);
		
		Component nameField = new JTextField(30);
		Pane.add(nameField);
		
		Component extLabel = new JLabel("Новое расширеное");
		Pane.add(extLabel);
		
		Component extField = new JTextField(10);
		Pane.add(extField);
		
		Component numberLabel = new JLabel("Начать нумерацию с:");
		Pane.add(numberLabel);
		
		Component numberField = new JTextField(10);
		Pane.add(numberField);
		
		Component fileLabel = new JLabel("Путь");
		Pane.add(fileLabel);
		
		
		Component fileArea = new JTextArea(5,60);
		Pane.add(fileArea);
		
		
		
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
		
		layout.putConstraint(SpringLayout.WEST , fileLabel, 350, SpringLayout.WEST , Pane);
		layout.putConstraint(SpringLayout.NORTH, fileLabel, 125, SpringLayout.NORTH, Pane);		
		layout.putConstraint(SpringLayout.WEST , fileArea, 50, SpringLayout.WEST , Pane);
		layout.putConstraint(SpringLayout.NORTH, fileArea, 150, SpringLayout.NORTH, Pane);
		
			
		
		
		setLocation(200, 400);
		setSize(850, 400);
		setVisible(true);
		setResizable(false);
		
		
	}
		
		
	
	
}
