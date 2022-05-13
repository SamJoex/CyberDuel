/* ~[ Cyber Duel: Main File ]~
 * AUTHOR:		SamJoex
 * VERSION:		0.4.0
 * BUILD:		5
 * DATESTAMP:	2021-11-28
 * DESCRIPTION:	This program simulates an RPG Battle called a "Cyber Duel".
 *				It is currently an experimental endeavor.
 */

package CyberDuel;  // To allow for importing the other files.

// Imports
import CyberDuel.Demo;
import CyberDuel.Moves;
import CyberDuel.Player;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GUI extends Application {
	

	// Create Demo Mode scene
	Scene demoScene;
	
	//~~ START: Starts the GUI.
	@Override
	public void start(Stage primaryStage) {
		// Create and configure Root node
		VBox root = new VBox();				// Root node: The heart of the main menu UI.
		root.setAlignment(Pos.CENTER);		// Center elements.
		root.setPadding(new Insets(10));	// Put space between Root and the window border.
		root.setSpacing(100);				// Put space between Root's components.
		
		// Create and Configure the Main Menu scene
		Scene scene = new Scene(root, 800, 600);
		scene.getStylesheets().add(getClass().getResource("mainMenuStyles.css").toExternalForm());
		
		// Title Text
		Text title = new Text("Cyber Duel");					// Title
		Text version = new Text("v0.4.0-5");					// Version Number
		Text author = new Text("Made by SamJoex");				// Author (SamJoex)
		
		// Configure Title Text
		title.setFont(Font.font("Century Schoolbook", FontWeight.BOLD, 72));	// Set font, weight, and size for Title
		title.setStroke(Color.BLUE);							// Set Outline color
		title.setStrokeWidth(2);								// Set Outline width
		title.setFill(Color.rgb(0, 200, 0));					// Set Title text color
		
		version.setFont(new Font("Century", 18));				// Set Version font and size
		version.setFill(Color.WHITE);							// Set Version text color
		
		author.setFont(new Font("Century", 18));				// Set Author font and size
		author.setFill(Color.WHITE);							// Set Author text color
		
		HBox versionAuthor = new HBox(version, author);			// Create HBox for version number and author
		versionAuthor.setAlignment(Pos.CENTER);					// Center items
		versionAuthor.setSpacing(180);							// Put some space between version and author
		
		VBox TitleText = new VBox(title, versionAuthor);		// Join the title text together
		TitleText.setAlignment(Pos.CENTER);						// Center title text
		
		// Mode Selections
		HBox Modes = new HBox();								// Create HBox to store the buttons
		Modes.setSpacing(100);									// Put some space between the mode buttons
		Modes.setAlignment(Pos.CENTER);							// Center buttons
		Button testButton = new Button("Test Moves");			// Test Moves button
		Button playButton = new Button("Play!");				// Play! button
		Modes.getChildren().addAll(testButton, playButton);		// Add buttons to HBox
		
		// VS Symbol & Mode Exit Button
		ImageView vsSymbol = new ImageView(new Image("file:img/VS Symbol.png"));
		Button exitButton = new Button("Back to Main Menu");
		
		
		// LAUNCH MAIN MENU WINDOW
		root.getChildren().addAll(TitleText, vsSymbol, Modes);	// Add components to Root
		primaryStage.setTitle("Cyber Duel");					// Set window title
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		//~~ Demo Button's Event Handler
		testButton.setOnAction(e -> {
			demoScene = Demo.BuildDemoModeGUI(exitButton);	// Build Demo Mode GUI
			demoScene.getStylesheets().add(getClass().getResource("demoModeStyles.css").toExternalForm());
			primaryStage.setScene(demoScene);
			primaryStage.show();
		});
		
		exitButton.setOnAction(e -> {
			primaryStage.setScene(scene);	// Once Demo Mode is exited, reset to the main menu scene.
			primaryStage.show();			// Show the Main Menu again.
		});
		
		//~~ Battle Button's Event Handler
		playButton.setOnAction(e -> {
			HBox notDone = new HBox(new Text("This is not implemented yet."));	// Message showing that the main mode isn't implemented yet.
			Scene notDoneScene = new Scene(notDone, 800, 600);					// New scene for this message.
			notDoneScene.getStylesheets().add(getClass().getResource("demoModeStyles.css").toExternalForm());
			primaryStage.setScene(notDoneScene);								// Set the primary stage's scene to the message's scene.
			primaryStage.show();												// Change the window.
		});
	}
	
	//~~ Required Main function
	public static void main(String[] args) {
		launch(args);
	}
}
