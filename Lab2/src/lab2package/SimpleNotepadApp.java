package lab2package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class SimpleNotepadApp extends JFrame {
	private JTextArea textarea;
	private JFileChooser filechooser;
	
	public SimpleNotepadApp() {
		setTitle("Simple Notepad App");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textarea = new JTextArea();
		JScrollPane scrollpane = new JScrollPane(textarea);
		
		JButton newButton = new JButton("New");
		JButton openButton = new JButton("Open");
		JButton saveButton = new JButton("Save");
		JButton exitButton = new JButton("Exit");
		
		newButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				newFile();
			}
		});
		
		openButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				openFile();
			}
		});
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveFile();
			}
		});
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		// to keep the button next to each other in single line, using panel with flowlayout
		JPanel buttonPanel = new JPanel(new FlowLayout());
		buttonPanel.add(newButton);
		buttonPanel.add(openButton);
		buttonPanel.add(saveButton);
		buttonPanel.add(exitButton);
		
		setLayout(new BorderLayout());
		add(buttonPanel, BorderLayout.NORTH);
		add(scrollpane, BorderLayout.CENTER);
		
		filechooser = new JFileChooser();		
	}
	
	public void newFile() {
		textarea.setText("");
	}
	
	public void openFile() {
		int returnValue = filechooser.showOpenDialog(this);
		
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File file = filechooser.getSelectedFile();
			try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
				StringBuilder content = new StringBuilder();
				String line;
				while ((line = reader.readLine()) != null) {
					content.append(line).append("\n");
				}
				textarea.setText(content.toString());
				
			} catch (IOException ex) {
				ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error reading file", "Error", JOptionPane.ERROR_MESSAGE);
			}			
		}
	}
	
	public void saveFile() {
		int returnValue = filechooser.showSaveDialog(this);
		
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File file = filechooser.getSelectedFile();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(textarea.getText());
                
            } catch (IOException ex) {
            	ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error saving file", "Error", JOptionPane.ERROR_MESSAGE);
            }                
		}           
	}
	public static void main(String args[]) {
		SwingUtilities.invokeLater(() -> {
			
			new SimpleNotepadApp().setVisible(true);
		});
	}		
}
