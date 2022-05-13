
package Controller;

import Main.CourseScreen;
import Main.RegestraionScreen;
import model.Student;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * FXML Controller class
 *
 * @author jit
 */
public class TableViewPaneController extends Stage implements Initializable {

    @FXML
    private TextField txtFieldID;
    @FXML
    private TextField txtFieldName;
    @FXML
    private TextField txtFieldMajor;
    @FXML
    private TextField txtFieldGrade;
    @FXML
    private TableView<Student> tableView;
    @FXML
    private TableColumn<Student, Integer> tcID;
    @FXML
    private TableColumn<Student, String> tcName;
    @FXML
    private TableColumn<Student, String> tcMajor;
    @FXML
    private TableColumn<Student, Double> tcGrade;
    @FXML
    private Button buttonAddNewCourse;
    Statement statement;
    @FXML
    private Button buttonAdd;
    @FXML
    private Button buttonEdite;
    @FXML
    private Button buttonDelete;
    @FXML
    private Button buttonRegistraion;
    @FXML
    private Button buttonSql1;
    Connection connection;
    private EntityManagerFactory emf;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tcID.setCellValueFactory(new PropertyValueFactory("id"));
        tcName.setCellValueFactory(new PropertyValueFactory("name"));
        tcMajor.setCellValueFactory(new PropertyValueFactory("major"));
        tcGrade.setCellValueFactory(new PropertyValueFactory("grade"));
        this.emf=Persistence.createEntityManagerFactory("ConnectDatabasePU");
        
        EntityManager em=emf.createEntityManager();
        List<Student>students= em.createNamedQuery("Students.All").getResultList();
        tableView.getItems().addAll(students);
        tableView.setOnMouseClicked((event) -> {
            Student std=tableView.getSelectionModel().getSelectedItem();
        txtFieldName.setText(std.getName());
        txtFieldID.setText(std.getId()+"");
        txtFieldMajor.setText(std.getMajor());
        txtFieldGrade.setText(std.getGrade()+"");
        
    
        });
    }
    public void showSelectedStudent() {
    }

    @FXML
    public void buttonAddHandle(ActionEvent event) throws SQLException {

    }

    @FXML
    public void buttonEditeHandle(ActionEvent event) throws SQLException {

    }

    public void update() throws SQLException {
//        
    }

    @FXML
    public void buttonDeleteHandle(ActionEvent event) throws SQLException {
    }

    @FXML
    public void buttonAddNewCourseHandle(ActionEvent event) throws Exception {
CourseScreen.getInstance().start(this);
    }


    @FXML
    private void buttonRegistraionHandle(ActionEvent event) throws Exception {
  RegestraionScreen.getInstance().start(this);
    }

}
