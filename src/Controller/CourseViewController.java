package Controller;

import model.Course;
import java.sql.Connection;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Student;

public class CourseViewController implements Initializable {

    @FXML
    private TableColumn<Course, String> tcName;

    @FXML
    private TextField txtFieldRoom;

    @FXML
    private TextField txtFieldID;

    @FXML
    private TableColumn<Course, Integer> tcRoom;

    @FXML
    private TextField txtFieldName;

    @FXML
    private TableView<Course> tableView;

    @FXML
    private Button buttonAddNewCourse;

    @FXML
    private TableColumn<?, ?> tcID;
    Statement statement;
    private EntityManagerFactory emf;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
         tcID.setCellValueFactory(new PropertyValueFactory("id"));
        tcName.setCellValueFactory(new PropertyValueFactory("name"));
        tcRoom.setCellValueFactory(new PropertyValueFactory("room"));
        
         this.emf=Persistence.createEntityManagerFactory("ConnectDatabasePU");
        EntityManager em=emf.createEntityManager();
        List<Course>courses= em.createNamedQuery("Course.All").getResultList();
        tableView.getItems().addAll(courses);
    }

    @FXML
    void buttonAddNewCourseHandle(ActionEvent event) throws SQLException {
      
    }

}
