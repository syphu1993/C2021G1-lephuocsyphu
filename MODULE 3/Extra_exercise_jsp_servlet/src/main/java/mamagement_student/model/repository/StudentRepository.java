package mamagement_student.model.repository;

import mamagement_student.model.bean.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentRepository {
    BaseRepository baseRepository = new BaseRepository();

    private final String FIND_ALL_STUDENT_SQL = "select *\n" +
            "from student;";
    private final String FIND_STUDENT_BY_ID_SQL = "select *\n" +
            "from student\n" +
            "where id = ?;";
    private final String CREATE_STUDENT_SQL ="insert into student(`name`,birthday)\n" +
            "value(?,?);";

    private final String EDIT_STUDENT_SQL ="update student\n" +
            "set `name` = ?, birthday = ?\n" +
            "where id = ?;";

    private final String DEL_STUDENT_SQL ="delete from student\n" +
            "where id = ?;";

    public List<Student> findAll() {
        Connection connection = baseRepository.connectDataBase();
        List<Student> students = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_STUDENT_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String birthday = resultSet.getString("birthday");
                Student student = new Student(id, name, birthday);
                students.add(student);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
    public Student findById(int id) {
        Student student  = null;
        Connection connection =baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_STUDENT_BY_ID_SQL);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id1 = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String birthday = resultSet.getString("birthday");
                student = new Student(id1, name, birthday);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }
    public void save(Student student) {
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_STUDENT_SQL);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setString(2,student.getBirthday());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean update(Student student) {
        Connection connection =baseRepository.connectDataBase();
        boolean check=false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(EDIT_STUDENT_SQL);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setString(2,student.getBirthday());
            preparedStatement.setInt(3,student.getId());
            check =preparedStatement.executeUpdate()>0;
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }
    public boolean delete(int id) {
        Connection connection =baseRepository.connectDataBase();
        boolean check=false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DEL_STUDENT_SQL);
            preparedStatement.setInt(1,id);
            check =preparedStatement.executeUpdate()>0;
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }
}
