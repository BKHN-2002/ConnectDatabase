/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author aashgar
 */

@Entity
@NamedQueries({
    @NamedQuery(name="Regestration.All",
            query = "select r from Regestration r")
})
public class Regestration {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Course courseId;
    private Student studentId;
    private String semester;

    public int getCourseId() {
        return courseId.getId();
    }

    public void setCourseId(Course courseId) {
        this.courseId = courseId;
    }

    public int getStudentId() {
        return studentId.getId();
    }

    public void setStudentId(Student studentId) {
        this.studentId = studentId;
    }

    
    
    
    
    public Regestration() {
    }


    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    

}
