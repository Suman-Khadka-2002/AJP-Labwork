// VM Argument to run the program:
//--module-path "D:\Courses\7th_Sem\AdvanceJava\JavaProgram\javafx-sdk-21.0.2\lib" --add-modules javafx.controls,javafx.graphics,javafx.fxml


package application;

import javafx.application.Application; 
import javafx.scene.Scene; 
import javafx.scene.control.*; 
import javafx.scene.layout.VBox; 
import javafx.stage.FileChooser; 
import javafx.stage.Stage; 
import java.io.File; 

public class FXUI extends Application { 
	 @Override 
	 public void start(Stage primaryStage) { 
		 // Create a VBox to hold UI components 
		 VBox vbox = new VBox(10); 
		 
		 // Label and TextField 
		 Label nameLabel = new Label("Name:"); 
		 TextField nameTextField = new TextField(); 
		 nameTextField.setPromptText("Enter your name"); 
		 
		 // Button 
		 Button submitButton = new Button("Submit"); 
		 
		 submitButton.setOnAction(event -> { 
			 String enteredName = nameTextField.getText(); 
			 System.out.println("Name entered: " + enteredName); 
		 }); 
		 
		 // RadioButton 
		 ToggleGroup genderToggleGroup = new ToggleGroup(); 
		 RadioButton maleRadioButton = new RadioButton("Male"); 
		 RadioButton femaleRadioButton = new RadioButton("Female"); 
		 maleRadioButton.setToggleGroup(genderToggleGroup); 
		 femaleRadioButton.setToggleGroup(genderToggleGroup); 
		 
		 // CheckBox 
		 CheckBox subscribeCheckBox = new CheckBox("Did you fill up the above information?"); 
		 
		 // Hyperlink 
		 Hyperlink hyperlink = new Hyperlink("<-Access to website->");
		 
		 hyperlink.setOnAction(event -> { 
			 System.out.println("Opening the website..."); 
			 
			 // You can add code to open a website here 
		 }); 
		 // Menu 
		 MenuBar menuBar = new MenuBar(); 
		 Menu fileMenu = new Menu("File"); 
		 MenuItem openMenuItem = new MenuItem("Open"); 
		 FileChooser fileChooser = new FileChooser(); 
		 
		 openMenuItem.setOnAction(event -> { 
			 File selectedFile = fileChooser.showOpenDialog(primaryStage); 
			 if (selectedFile != null) { 
				 System.out.println("Selected file: " + selectedFile.getAbsolutePath()); 
			 } 
		 }); 
		 
		 fileMenu.getItems().add(openMenuItem); 
		 menuBar.getMenus().add(fileMenu); 
		 
		 // Tooltip 
		 Tooltip tooltip = new Tooltip("Click me!");
		 
		 submitButton.setTooltip(tooltip); 
		 
		 // Add components to the VBox 
		 vbox.getChildren().addAll(nameLabel, nameTextField, submitButton, 
		maleRadioButton, femaleRadioButton, 
		 subscribeCheckBox, hyperlink, menuBar); 
		 
		 // Create the scene and set it in the stage 
		 Scene scene = new Scene(vbox, 400, 300); 
		 primaryStage.setTitle("JavaFX UI"); 
		 primaryStage.setScene(scene); 
		 primaryStage.show(); 
	 } 
	 
	 public static void main(String[] args) { 
		 launch(args); 
	 } 
} 
