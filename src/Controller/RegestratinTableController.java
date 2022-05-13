/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
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
import model.Regestration;
import model.Student;

/**
 * FXML Controller class
 *
 * @author jit
 */
public class RegestratinTableController implements Initializable {

    @FXML
    private TextField txtFieldCourseID;
    @FXML
    private TextField txtFieldStudentID;
    @FXML
    private TextField txtFieldSemester;
    @FXML
    private TableView<Regestration> tableView;
    @FXML
    private TableColumn<Regestration, Integer> tcCourseId;
    @FXML
    private TableColumn<Regestration, Integer> tcStudentId;
    @FXML
    private TableColumn<Regestration, Integer> tcSemester;
    @FXML
    private Button buttonAdd;
    private Statement statement;
private EntityManagerFactory emf;
    /**s
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tcCourseId.setCellValueFactory(new PropertyValueFactory("courseId"));
        tcStudentId.setCellValueFactory(new PropertyValueFactory("studentId"));
        tcSemester.setCellValueFactory(new PropertyValueFactory("semester"));
         this.emf=Persistence.createEntityManagerFactory("ConnectDatabasePU");
//        
        EntityManager em=emf.createEntityManager();
        List<Regestration>regestrations= em.createNamedQuery("Regestration.All").getResultList();
        System.out.println(regestrations.get(0));
        tableView.getItems().addAll(regestrations);
                }

    @FXML
    private void buttonAddHandle(ActionEvent event) throws SQLException {
//
//        

    }

}
