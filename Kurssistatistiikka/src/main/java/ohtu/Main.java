package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.HashMap;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        // ÄLÄ laita githubiin omaa opiskelijanumeroasi
        String studentNr = "012345678";
        if ( args.length>0) {
            studentNr = args[0];
        }

        String url = "https://studies.cs.helsinki.fi/courses/students/"+studentNr+"/submissions";

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

        HashMap<Course, Submission[]> courseSubs = new HashMap<>();
        System.out.println("Opiskelijanumero: " + studentNr + "\n");
        for (Submission submission : subs) {
            CoursePicker coursePicker = new CoursePicker(submission, courses);
            Course course = coursePicker.getCourse();
            System.out.println(submission);
        }
    }
}
