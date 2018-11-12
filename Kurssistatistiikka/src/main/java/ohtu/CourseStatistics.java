/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 *
 * @author vseppane
 */
class CourseStatistics {

    private CourseWeek[] courseWeeks;
    private JsonObject parsedCourse;
    private Gson mapper;
    private int maxWeek;

    public CourseStatistics(JsonObject parsedCourse) {
        this.parsedCourse = parsedCourse;
        this.mapper = new Gson();
        this.getCourseWeeks();
    }

    private void getCourseWeeks() {
        Integer i = 0;
        maxWeek = 0;
        courseWeeks = new CourseWeek[8];
        while (true) {
            i++;
            String element = i.toString();
            if (parsedCourse.has(element)) {
                String courseText = parsedCourse.get(element).toString();
                courseWeeks[i] = mapper.fromJson(courseText, CourseWeek.class);
                maxWeek = i;
            } else {
                break;
            }
        }
    }
    
    public int getAllSubmissions() {
        int subs = 0;
        for (int i = 1; i <= maxWeek; i++) {
            subs += courseWeeks[i].getStudents();
        }
        return subs;
    }
    
    public int getAllSubmittedExercises() {
        int exercises = 0;
        for (int i = 1; i <= maxWeek; i++) {
            exercises += courseWeeks[i].getExercise_total();
        }
        return exercises;
    }
    
    public int getAllHours() {
        int hours = 0;
        for (int i = 1; i <= maxWeek; i++) {
            hours += courseWeeks[i].getHour_total();
        }
        return hours;
    }

    @Override
    public String toString() {
        return "kurssilla yhteensä " + this.getAllSubmissions() + " palautusta, palautettuja tehtäviä "
                + this.getAllSubmittedExercises() + " kpl, aikaa käytetty yhteensä "
                + this.getAllHours() + " tuntia\n";
    }
    
    
}
