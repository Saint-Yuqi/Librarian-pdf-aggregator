package aggregator;

import aggregator.Student;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class GSONWorker {
    public static void main(String args[]) throws FileNotFoundException {
        Random r = new Random();
        ArrayList students = new ArrayList<Student>();
        for(int i = 0; i < 10; ++i)
        {
            Student student = new Student();
            student.name = "Bob";
            student.age = r.nextInt(10) + 15;
            students.add(student);
        }
        Gson gson = new Gson();

        PrintWriter pw = new PrintWriter("out.txt");
        pw.println(gson.toJson(students));
        pw.close();

        StringBuffer sb = new StringBuffer();
        String path = "/Users/yang/Downloads/in.txt";
        try(BufferedReader reader = new BufferedReader(new FileReader(path)))
        {
            char[] buf = new char[1024];
            int bytesRead = 0;
            while((bytesRead = reader.read(buf)) != -1)
            {
                sb.append(String.valueOf(buf, 0, bytesRead));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String jsonData = sb.toString();
        //String jsonData = "[{\"name\":\"Bob\",\"age\":15},{\"name\":\"Bill\",\"age\":15},{\"name\":\"Yan\",\"age\":23},{\"name\":\"Nikita\",\"age\":20}]\n";
        ArrayList<Student> inStudents = gson.fromJson(jsonData, new TypeToken<ArrayList<Student>>(){}.getType());
        for (Student inStudent : inStudents) {
            System.out.printf("%s : %d %d\n", inStudent.name, inStudent.age, inStudent.banana?1:0);
        }
    }
}
