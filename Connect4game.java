import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;

public class Connect4game extends Application {
    // this method is the basic gui start method that calls the SetBoard method that
    // controls most of the GUI.
    // here the whole scene is made and launched
    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new SetBoard();
        Scene Scene = new Scene(root, 900, 700);
        primaryStage.setTitle("Connect 4");
        primaryStage.setScene(Scene);
        primaryStage.show();
    }

    // main method where the command line args are used to launch the GUI
    // application
    public static void main(String[] args) {
        Application.launch(args);
    }
}