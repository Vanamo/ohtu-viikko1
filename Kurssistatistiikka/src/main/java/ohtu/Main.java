package ohtu;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import java.io.IOException;
import java.util.HashMap;
import org.apache.http.client.fluent.Request;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

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

        String ohtuStatsUrl = "https://studies.cs.helsinki.fi/courses/ohtu2018/stats";
        String ohtuStatsText = Request.Get(ohtuStatsUrl).execute().returnContent().asString();

        String railsStatsUrl = "https://studies.cs.helsinki.fi/courses/rails2018/stats";
        String railsStatsText = Request.Get(railsStatsUrl).execute().returnContent().asString();

//        System.out.println("json-muotoinen data:");
//        System.out.println( bodyText );
//        System.out.println( courseInfoText );
        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);

        Course[] courses = mapper.fromJson(courseInfoText, Course[].class);

        JsonParser parser = new JsonParser();
        JsonObject parsedOhtu = parser.parse(ohtuStatsText).getAsJsonObject();

        JsonObject parsedRails = parser.parse(railsStatsText).getAsJsonObject();

        //CourseWeek[] ohtuWeeks;
        Integer i = 0;
        while (true) {
            i++;
            String element = i.toString();
            String ohtuText = parsedOhtu.get(element).toString();
            System.out.println("ohtu " + ohtuText);
            if (ohtuText.isEmpty()) break;
        }


//        System.out.println("parsed " + parsedOhtu.get("1").toString());
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
