package com.example.mentor;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor

public class MentorDao {
    private final JdbcTemplate jdbcTemplate;
    public List<Mentor> getAllmentor(){
        String sql="select * from mentor";
        return jdbcTemplate.query(sql,(rs, row)->
                Mentor.builder().id(rs.getInt(1)).full_name(rs.getString(2)).Course_name(rs.getString(3)).build()

        )       ;


    }
        public void delte(int id){

        String sql="delete from mentor where id=?";
        jdbcTemplate.update(sql,id);
        }
        public List<Mentor> getMentorById(int id){

            String sql="select * from mentor";
            return jdbcTemplate.query(sql,(rs, row)->
                    Mentor.builder().id(rs.getInt(1)).full_name(rs.getString(2)).Course_name(rs.getString(3)).build()

            );
        }
        public void editSave(Mentor mentor){
        String sql="update mentor set full_name=?,course_name=? where id=?;";
        jdbcTemplate.update(sql,mentor.getFull_name(), mentor.getCourse_name(),mentor.getId());
        }

    public void addMentor(Mentor mentor) {
        String sql="insert  into mentor(full_name, course_name)values (?,?)";
        jdbcTemplate.update(sql,mentor.getFull_name(),mentor.getCourse_name());
    }
}
