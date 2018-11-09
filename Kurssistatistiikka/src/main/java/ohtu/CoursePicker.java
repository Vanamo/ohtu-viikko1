/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

/**
 *
 * @author vseppane
 */
public class CoursePicker {

    private Submission submission;
    private Course[] courses;
    
    public CoursePicker(Submission submission, Course[] courses) {
        this.submission = submission;
        this.courses = courses;
    }
        
    public Course getCourse() {
        if (submission.getCourse().equals("rails2018")) {
            return this.findCourseWithId("5b71a456589cd9003615c7ce");
        } else if (submission.getCourse().equals("ohtu2018")) {
            return this.findCourseWithId("5bb48ca56ec4c800e33cb76f");            
        } else {
            return null;
        }
    }

    private Course findCourseWithId(String id) {
        Course course = null;
            for (int i = 0; i < courses.length; i++) {
                if (id.equals(courses[i].getId())) return course;
            }
        return course;
    }
}
