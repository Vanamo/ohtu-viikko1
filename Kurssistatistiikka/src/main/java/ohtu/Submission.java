package ohtu;

public class Submission {
    private int week;
    private double hours;
    private int[] exercises;
    private String course;

    public void setWeek(int week) {
        this.week = week;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
    
    public void setExercises(int[] exercises) {
        this.exercises = exercises;
    }
    
    public void setCourse(String course) {
        this.course = course;
    }
    
    public int getWeek() {
        return week;
    }

    public double getHours() {
        return hours;
    }
    
    public int[] getExercises() {
        return exercises;
    }
    
    public String getCourse() {
        return course;
    }    

    @Override
    public String toString() {
        String exerciseString = "";
        for (int i = 0; i < exercises.length; i++) {
            if (i != 0) {
                exerciseString += ", ";
            }
            exerciseString += exercises[i];
        }
        return "" + course + ", viikko " + week + " tehtyjä tehtäviä yhteensä " + exercises.length
                + " aikaa kului " + hours + " tehdyt tehtävät " + exerciseString;
    }
    
}