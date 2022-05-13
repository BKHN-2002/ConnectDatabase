/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author aashgar
 */
@Entity
@NamedQueries({
    @NamedQuery(name="Course.All",
            query = "select c from Course c")
})
public class Course {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//@ManyToMany(mappedBy="courses")
//@ManyToMany(mappedBy="courses",
//cascade = {CascadeType.PERSIST, CascadeType.MERGE}, 
//fetch = FetchType.EAGER)
@ManyToMany(mappedBy = "courses")
    List<Student> students; 
    private String name;
    private String room;
    

    public Course() {
    }

    public Course(Integer id, String name, String room) {
        this.id = id;
        this.name = name;
        this.room = room;
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

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

}
