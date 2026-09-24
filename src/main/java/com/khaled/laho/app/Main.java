package com.khaled.laho.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import javafx.scene.Scene; 
import javafx.stage.Stage;  

public class Main extends Application { 
   @Override 
   public void start(Stage stage) throws IOException {      
      
	   FXMLLoader loader = new FXMLLoader(
			   Main.class.getResource("/com/khaled/laho/fxml/app-shell.fxml")
			   );
      // Creating a scene object 
      Scene scene = new Scene(loader.load(), 900, 600); 
       
      // Setting title to the Stage   
      stage.setTitle("لهو - LAHO"); 
         
      // Adding scene to the stage 
      stage.setScene(scene);
      
      //Displaying the contents of the stage 
      stage.show(); 
   } 
   public static void main(String args[]){ 
      launch(args); 
   } 
}