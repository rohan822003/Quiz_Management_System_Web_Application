package Components;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDb {

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/qms", "root", "Rohan@123");

        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

    public static int save(Student s) {
        int status = 0;
        try {
            Connection con = StudentDb.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into register(name, email, password) values (?,?,?)");
            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getPassword());

            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return status;
    }
    public static int saveResponse(Student s) {
        int status = 0;
        try {
            Connection con = StudentDb.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into response(name, contact, response) values (?,?,?)");
            ps.setString(1, s.getStuName());
            ps.setString(2, s.getStuContact());
            ps.setString(3, s.getResponse());

            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return status;
    }

    public static int update(Student s) {
        int status = 0;
        try {
            Connection con = StudentDb.getConnection();
            PreparedStatement ps = con.prepareStatement("update register set name = ?, email = ?, password = ? where id = ?");

            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getPassword());

            ps.setInt(4, s.getId());
            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return status;
    }
    public static int updateQuestions(Student s) {
        int status = 0;
        try {
            Connection con = StudentDb.getConnection();
            PreparedStatement ps = con.prepareStatement("update exam set question = ?, option1 = ?, option2 = ?, option3 = ?, option4 = ?, answer = ? where id = ?");

            ps.setString(1, s.getQuestion());
            ps.setString(2, s.getOption1());
            ps.setString(3, s.getOption2());
            ps.setString(4, s.getOption3());
            ps.setString(5, s.getOption4());
            ps.setString(6, s.getAnswer());

            ps.setInt(7, s.getId3());
            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return status;
    }

    public static int delete(int id) {
        int status = 0;
        try {
            Connection con = StudentDb.getConnection();
            PreparedStatement ps = con.prepareStatement("delete from examNames where id = ?");

            ps.setInt(1, id);

            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return status;
    }
    public static int deleteQuestions(int id) {
        int status = 0;
        try {
            Connection con = StudentDb.getConnection();
            PreparedStatement ps = con.prepareStatement("delete from exam where id = ?");

            ps.setInt(1, id);

            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return status;
    }
    public static int deleteResponse(int id) {
        int status = 0;
        try {
            Connection con = StudentDb.getConnection();
            PreparedStatement ps = con.prepareStatement("delete from response where id = ?");

            ps.setInt(1, id);

            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return status;
    }

    public static List<Student> getAllStudents() {
        List<Student> list = new ArrayList<Student>();
        try {
            Connection con = StudentDb.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from register");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt(1));
                s.setName(rs.getString(2));
                s.setEmail(rs.getString(3));
                s.setPassword(rs.getString(4));

                list.add(s);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return list;
    }

    public static Student getQuestionById(int id) {
        Student s = new Student();
        try {
            Connection con = StudentDb.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from exam where id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                s.setId3(rs.getInt(1));
                s.setExamName(rs.getString(2));
                s.setQuestion(rs.getString(3));
                s.setOption1(rs.getString(4));
                s.setOption2(rs.getString(5));
                s.setOption3(rs.getString(6));
                s.setOption4(rs.getString(7));
                s.setAnswer(rs.getString(8));

            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return s;
    }

    public static int getStudentByuname(String email, String password) {
        int status = 0;
        try {
            Connection con = StudentDb.getConnection();
            PreparedStatement ps = con.prepareStatement("select name from register where email=? and password=?");
            ps.setString(1, email);
            ps.setString(2, password);
            Student s = new Student();
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                s.setName(rs.getString(1));
                System.out.println("Login successful");
                status = 1;
            }
            con.close();
        } catch (Exception e) {

            System.out.println("Error during login: " + e.getMessage());
            e.printStackTrace();
        }
        return status;
    }

    public static int add(Student s) {
        int status = 0;
        try {
            Connection con = StudentDb.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into exam(id, examName, question, option1, option2, option3, option4, answer) values (?,?,?,?,?,?,?,?)");
            ps.setInt(1, s.getId2());
            ps.setString(2, s.getExamName());
            ps.setString(3, s.getQuestion());
            ps.setString(4, s.getOption1());
            ps.setString(5, s.getOption2());
            ps.setString(6, s.getOption3());
            ps.setString(7, s.getOption4());
            ps.setString(8, s.getAnswer());

            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return status;
    }

    public static int saveExam(Student s) {
        int status = 0;
        try {
            Connection con = StudentDb.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into examNames(examName, examDate) values (?,?)");
            ps.setString(1, s.getExamName2());
            ps.setString(2, s.getExamDate());
          

            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return status;
    }

    public static List<Student> getAllExams() {
        List<Student> list = new ArrayList<Student>();
        try {
            Connection con = StudentDb.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from examNames");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setExamName2(rs.getString(1));
                s.setExamDate(rs.getString(2));
                s.setId4(rs.getInt(3));

                list.add(s);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return list;
    }
    
    public static List<Student> getAllResponse() {
        List<Student> list = new ArrayList<Student>();
        try {
            Connection con = StudentDb.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from response");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setId5(rs.getInt(1));
                s.setStuName(rs.getString(2));
                s.setStuContact(rs.getString(3));
                s.setResponse(rs.getString(4));

                list.add(s);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return list;
    }
    
    public static List<Student> getSearchAllExams(String examName) {
        List<Student> list = new ArrayList<Student>();
        try {
            Connection con = StudentDb.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from examNames where examName=?");
            ps.setString(1, examName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setExamName2(rs.getString(1));
                s.setExamDate(rs.getString(2));
                s.setId4(rs.getInt(3));

                list.add(s);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return list;
    }
    
    public static List<Student> getSearchAllResponse(String name) {
        List<Student> list = new ArrayList<Student>();
        try {
            Connection con = StudentDb.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from response where name=?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setId5(rs.getInt(1));
                s.setStuName(rs.getString(2));
                s.setStuContact(rs.getString(3));
                s.setResponse(rs.getString(4));

                list.add(s);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return list;
    }

    public static List<Student> getAllExamQuestions() {
        List<Student> list = new ArrayList<Student>();
        try {
            Connection con = StudentDb.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from exam");
            ResultSet rs = ps.executeQuery();
            int questionCount = 0;
            while (rs.next()) {
                questionCount++;
                Student s = new Student();
                s.setId2(rs.getInt(1));
                s.setExamName(rs.getString(2));
                s.setQuestion(rs.getString(3));
                s.setOption1(rs.getString(4));
                s.setOption2(rs.getString(5));
                s.setOption3(rs.getString(6));
                s.setOption4(rs.getString(7));
                s.setAnswer(rs.getString(8));

                list.add(s);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return list;
    }

    public static List<Student> getExamQuestions(String examName) {
        List<Student> list = new ArrayList<Student>();

        try ( Connection con = getConnection();  PreparedStatement ps = con.prepareStatement("select * from exam where examName = ?")) {
            ps.setString(1, examName);
            ResultSet rs = ps.executeQuery();
            int questionCount = 0;
            while (rs.next()) {
                questionCount++;
                Student s = new Student();
                s.setId2(rs.getInt(1));
                s.setExamName2(rs.getString(2));
                s.setQuestion(rs.getString(3));
                s.setOption1(rs.getString(4));
                s.setOption2(rs.getString(5));
                s.setOption3(rs.getString(6));
                s.setOption4(rs.getString(7));
                s.setAnswer(rs.getString(8));

                list.add(s);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace(); // Handle or log the exception as needed
        }

        return list;
    }

    public static List<Student> getCorrectAnswerForQuestion(int id) {
        List<Student> list = new ArrayList<Student>();

        try ( Connection con = getConnection();  PreparedStatement ps = con.prepareStatement("select * from exam where id = ?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            int questionCount = 0;
            while (rs.next()) {
                questionCount++;
                Student s = new Student();
                s.setId2(rs.getInt(1));
                s.setExamName2(rs.getString(2));
                s.setQuestion(rs.getString(3));
                s.setOption1(rs.getString(4));
                s.setOption2(rs.getString(5));
                s.setOption3(rs.getString(6));
                s.setOption4(rs.getString(7));
                s.setAnswer(rs.getString(8));

                list.add(s);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace(); // Handle or log the exception as needed
        }

        return list;
    }

    public static int saveExamResult(Student s) {
        int status = 0;
        try {
            Connection con = StudentDb.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO exam_results (name, contact, exam_name, total_questions, correct_answers, results) VALUES (?, ?, ?, ?, ?, ?)");
            ps.setString(1, s.getsName());
            ps.setString(2, s.getContact());
            ps.setString(3, s.geteName());
            ps.setInt(4, s.gettQuestions());
            ps.setInt(5, s.getcQuestions());
            ps.setString(6, s.getResults());

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return status;
    }

    public static List<Student> getResults() {
    List<Student> list = new ArrayList<Student>();
    try {
        Connection con = StudentDb.getConnection();
        PreparedStatement ps = con.prepareStatement("select * from exam_results");
        
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            Student s = new Student();
            s.setId4(rs.getInt(1));
            s.setsName(rs.getString(2));
            s.setContact(rs.getString(3));
            s.seteName(rs.getString(4));
            s.settQuestions(rs.getInt(5));
            s.setcQuestions(rs.getInt(6));
            s.setResults(rs.getString(7)); // corrected index to get result
            list.add(s); // Add the populated Student object to the list
        }
        con.close();
    } catch (Exception e) {
        System.out.println(e);
    }

    return list;
}

    public static List<Student> getSearchResults(String name) {
    List<Student> list = new ArrayList<Student>();
    try {
        Connection con = StudentDb.getConnection();
        PreparedStatement ps = con.prepareStatement("select * from exam_results where name=?");
        ps.setString(1, name);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            Student s = new Student();
            s.setId4(rs.getInt(1));
            s.setsName(rs.getString(2));
            s.setContact(rs.getString(3));
            s.seteName(rs.getString(4));
            s.settQuestions(rs.getInt(5));
            s.setcQuestions(rs.getInt(6));
            s.setResults(rs.getString(7)); // corrected index to get result
            list.add(s); // Add the populated Student object to the list
        }
        con.close();
    } catch (Exception e) {
        System.out.println(e);
    }

    return list;
}
    
    public static List<Student> getAllQuestion() {
        List<Student> list = new ArrayList<Student>();
        try {
            Connection con = StudentDb.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from exam");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setId3(rs.getInt(1));
                s.setExamName(rs.getString(2));
                s.setQuestion(rs.getString(3));
                s.setOption1(rs.getString(4));
                s.setOption2(rs.getString(5));
                s.setOption3(rs.getString(6));
                s.setOption4(rs.getString(7));
                s.setAnswer(rs.getString(8));

                list.add(s);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return list;
    }
    
    public static List<Student> getSearchExamQuestions(String examName) {
        List<Student> list = new ArrayList<Student>();

        try ( Connection con = getConnection();  
            PreparedStatement ps = con.prepareStatement("select * from exam where examName = ?")) {
            ps.setString(1, examName);
            ResultSet rs = ps.executeQuery();
            int questionCount = 0;
            while (rs.next()) {
                questionCount++;
                Student s = new Student();
                s.setId2(rs.getInt(1));
                s.setExamName(rs.getString(2));
                s.setQuestion(rs.getString(3));
                s.setOption1(rs.getString(4));
                s.setOption2(rs.getString(5));
                s.setOption3(rs.getString(6));
                s.setOption4(rs.getString(7));
                s.setAnswer(rs.getString(8));

                list.add(s);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace(); // Handle or log the exception as needed
        }

        return list;
    }

}
