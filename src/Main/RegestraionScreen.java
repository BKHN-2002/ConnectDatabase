
package Main;

import java.util.Map;
import java.util.TreeMap;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class RegestraionScreen extends Application {
    private static RegestraionScreen instance=null;
        
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane paneTableView = FXMLLoader.load(getClass().getResource("RegestratinTable.fxml"));
        Map<String, Pane> mapPanes = new TreeMap<>();
        mapPanes.put("regestraionView", paneTableView);
        Scene scene = new Scene(mapPanes.get("regestraionView"));
        primaryStage.setTitle("Regestraion Course");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private RegestraionScreen() {
    }
    
    public static RegestraionScreen getInstance(){
        if (instance==null)
            return new RegestraionScreen();
        return instance;
    }
    
}
