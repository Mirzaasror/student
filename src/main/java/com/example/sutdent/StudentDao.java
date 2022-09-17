package com.example.sutdent;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StudentDao {
    private final JdbcTemplate jdbcTemplate;

    public List<Student> allstudent() {
    String sql="select s.id,s.full_name,s.cource_name,m.full_name from student s join mentor m on m.id = s.mentor_id";
  return   jdbcTemplate.query(sql,(rs,row)->
          Student.builder().id(rs.getInt(1)).full_name(rs.getString(2)).course_name(rs.getString(3)).mentor_name(rs.getString(4)).build());
    }

    public void save(Student student) {
        String sql="insert into student (full_name,cource_name,mentor_id) values (?,?,?)";

        jdbcTemplate.update(sql,student.getFull_name(),student.getCourse_name(),student.getMentor_id());
    }
    public void delete(int id){
        String sql="delete from student where id =?";
                ;
        jdbcTemplate.update(sql,id);
    }

    public List<Student> getStudentById(int id) {
        String sql="select s.id,s.full_name,s.cource_name,m.full_name from student s join mentor m on m.id = s.mentor_id where s.id="+id+";";

        return   jdbcTemplate.query(sql,(rs,row)->
                Student.builder().id(rs.getInt(1)).full_name(rs.getString(2)).course_name(rs.getString(3)).mentor_name(rs.getString(4)).build());


    }

    public void editsave(Student student) {
        String sql="update student set full_name=? , cource_name=? , mentor_id=? where id=?";
        jdbcTemplate.update(sql,student.getFull_name(),student.getCourse_name(),student.getMentor_id(),student.getId());
    }
}
