package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.HashMap;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        // ÄLÄ laita githubiin omaa opiskelijanumeroasi
        String studentNr = "012345678";
        if (args.length > 0) {
            studentNr = args[0];
        }

        String url = "https://studies.cs.helsinki.fi/courses/students/" + studentNr + "/submissions";

        String bodyText = Request.Get(url).execute().returnContent().asString();

        String courseInfoUrl = "https://studies.cs.helsinki.fi/courses/courseinfo";
        String courseInfoText = Request.Get(courseInfoUrl).execute().returnContent().asString();

//        System.out.println("json-muotoinen data:");
//        System.out.println( bodyText );
//        System.out.println( courseInfoText );
        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);

        Course[] courses = mapper.fromJson(courseInfoText, Course[].class);

//        System.out.println("kurssi " + courses[0].getId());
        for (Course course : courses) {
            int subExercisesSum = 0;
            double hoursSum = 0;
            boolean printCourse = false;
            for (Submission sub : subs) {
                if (sub.getCourse().equals(course.getName())) {
                    printCourse = true;
                }
            }

            if (printCourse) {
                System.out.println(course.getFullName() + "\n");
                for (Submission sub : subs) {
                    if (sub.getCourse().equals(course.getName())) {
                        int subExercises = sub.getExercises().length;
                        subExercisesSum += subExercises;
                        int courseExercises = course.getExercises()[sub.getWeek()];
                        hoursSum += sub.getHours();

                        System.out.println("Viikko " + sub.getWeek() + ":");
                        System.out.println("Tehtyjä tehtäviä " + subExercises
                                + "/" + courseExercises
                                + " aikaa kului " + sub.getHours() + " tehdyt tehtävät: "
                                + sub.getExerciseString());
                    }
                }
                System.out.println("\nyhteensä: " + subExercisesSum + "/" + course.getExercisesSum()
                        + " tehtävää " + hoursSum + " tuntia\n");
            }
        }
    }
}
