
package Main;

import java.util.Map;
import java.util.TreeMap;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class CourseScreen extends Application {
    private static CourseScreen instance=null;
        
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane paneTableView = FXMLLoader.load(getClass().getResource("CourseTable.fxml"));
        Map<String, Pane> mapPanes = new TreeMap<>();
        mapPanes.put("courseView", paneTableView);
        Scene scene = new Scene(mapPanes.get("courseView"));
        primaryStage.setTitle("Add New Course");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private CourseScreen() {
    }
    
    public static CourseScreen getInstance(){
        if (instance==null)
            return new CourseScreen();
        return instance;
    }
    
}
