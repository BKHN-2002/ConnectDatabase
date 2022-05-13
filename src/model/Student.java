/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author aashgar
 */
@Entity
@NamedQueries({
    @NamedQuery(name="Students.All",
            query = "select s from Student s"),
    @NamedQuery(name="Students.Search",
            query = "select s from Student s where s.id= :id")
})
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany
    @JoinTable(
  name = "regestration", 
  joinColumns = @JoinColumn(name = "studentId"), 
  inverseJoinColumns = @JoinColumn(name = "courseId"))
  List<Course> courses; 
    private String name;
    private String major;
    private Double grade;

    public Student() {
    }
    
    public Student(Integer id, String name, String major, Double grade) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.grade = grade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return String.format("%-5s %-10s %-10s %8.2f", id, name, major, grade);
    }
    
}
