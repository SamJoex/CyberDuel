/* ~[ Demo Mode ]~
 * Contains the implementation of Demo Mode.
 */

package CyberDuel;

import CyberDuel.Moves;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Demo {
	public static Scene BuildDemoModeGUI(Button exitButton) {
		VBox demoRoot = new VBox();						// Create Demo Mode's root node
		demoRoot.setAlignment(Pos.CENTER);				// Center Root Node's elements
		demoRoot.setSpacing(100);						// Set spacing between elements in Root node
		
		VBox functionList = new VBox();					// Create container for the functions
		functionList.setAlignment(Pos.CENTER);			// Center Function List
		
		// Title Text
		Text DemoModeTitle = new Text("Demo Mode");
		DemoModeTitle.setFont(Font.font("Century Schoolbook", FontWeight.BOLD, 48));
		DemoModeTitle.setStroke(Color.BLUE);			// Set Outline color
		DemoModeTitle.setStrokeWidth(2);				// Set Outline width
		DemoModeTitle.setFill(Color.rgb(0, 200, 0));	// Set Title text color
		
		// "Select Move" Text
		Text SelectMove = new Text("Select a move.");
		SelectMove.setFont(Font.font("Tahoma", FontWeight.BOLD, 24));
		
		// Create Move ComboBox
		ComboBox DemoMoves = new ComboBox();
		DemoMoves.setPromptText("Select");
		DemoMoves.getItems().addAll("Attack", "ElemAtk");
		functionList.getChildren().add(DemoMoves);
		
		// Launch Demo Mode Window
		demoRoot.getChildren().addAll(functionList, exitButton);
		return new Scene(demoRoot, 800, 600);
	}
}
