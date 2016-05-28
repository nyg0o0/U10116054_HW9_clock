import javafx.application.Application;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.util.Duration;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.layout.Pane;
public class ClockAnimation extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		
		double sceneWidth = 300;
		double sceneHeight = 400;
		
		Pane pane = new Pane();
		ClockPane clock = new ClockPane(); // Create a clock

		// Create a handler for animation
		EventHandler<ActionEvent> eventHandler = e -> {
			clock.setCurrentTime(); // Set a new clock time
		};
    
		// Create an animation for a running clock
		Timeline animation = new Timeline( new KeyFrame(Duration.millis(1000), eventHandler) );
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play(); // Start animation

		clock.setPrefWidth(sceneWidth);
		clock.setPrefHeight(sceneHeight);
		pane.getChildren().addAll(clock);
		
		
		
		double currentY =  sceneHeight / 2 + 50;
		// Label for time counter
		Label timingLabel = new Label("      00 \" 00 \" 00");
		timingLabel.setLayoutX( sceneWidth / 4 );
		timingLabel.setLayoutY( currentY = currentY + 30 );
		
		
		// Draw buttons
		
		Button btnSetAlarm = new Button();
		btnSetAlarm.setText("Timing Begin");
		btnSetAlarm.setLayoutX( sceneWidth / 4 );
		btnSetAlarm.setLayoutY( currentY = currentY + 30 );
		btnSetAlarm.setStyle("-fx-font: 16 arial; -fx-base: #b6e7c9;");
		btnSetAlarm.setPrefWidth( sceneWidth / 2 );
		
		Button btnClearAlarm = new Button();
		btnClearAlarm.setText("Timing End");
		btnClearAlarm.setLayoutX( sceneWidth / 4 );
		btnClearAlarm.setLayoutY( currentY = currentY + 40 );
		btnClearAlarm.setStyle("-fx-font: 16 arial; -fx-base: #FF8888;");
		btnClearAlarm.setPrefWidth( sceneWidth / 2 );
		 
		pane.getChildren().addAll(timingLabel,btnSetAlarm,btnClearAlarm);
		btnSetAlarm.setOnAction((ActionEvent event) -> {
			
			
		});	    
		
		// Create a scene and place it in the stage
		Scene scene = new Scene( pane , sceneWidth, sceneHeight);
		primaryStage.setTitle("ClockAnimation"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	/**
	* The main method is only needed for the IDE with limited
	* JavaFX support. Not needed for running from the command line.
	*/
	public static void main(String[] args) {
		launch(args);
	}
}
