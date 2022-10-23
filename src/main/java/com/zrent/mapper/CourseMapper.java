package com.zrent.mapper;

import com.zrent.model.Candition;
import com.zrent.model.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Zrent
 */
@Mapper
public interface CourseMapper {

    @Select("select id,name,teacher_id,attribute,face_img,ks,add_time from course")
    List<Course> list();



    @Select({"<script> " +
            "select count(*) from course c left join teacher t on c.teacher_id=t.id " +
            "<where>" +
            "<if test='courseName != null'> and c.name like '%${courseName}%' </if> "+
            "<if test='teacherName != null'> and t.name like '%${teacherName}%' </if> "+
            "</where> "+
            "</script>"})
    int getRecordCount(@Param("courseName") String courseName,
                       @Param("teacherName") String teacherName);

    @Select("<script>select c.id,c.name,c.teacher_id,t.name teacherName, c.attribute,c.face_img,c.ks,c.add_time " +
            "from course c left JOIN teacher t ON c.teacher_id=t.id " +
            "<where>"+
            "<if test='courseName != null'> and c.name like '%${courseName}%' </if> "+
            "<if test='teacherName != null'> and t.name like '%${teacherName}%' </if> "+
            "</where>"+
            "LIMIT #{recordStart},#{pageSize} " +
            "</script>")
    List<Course> queryCourse(@Param("recordStart") Integer recordStart,
                             @Param("pageSize") Integer pageSize,
                             @Param("courseName") String courseName,
                             @Param("teacherName") String teacherName);

    @Insert("insert into course(name,teacher_id,attribute,ks,face_img) value(#{course.name},#{course.teacherId},#{course.attribute},#{course.ks},#{course.faceImg}) ")
    void add(@Param("course") Course course);

//    @Delete("delete from course where id=#{id}")
//    void delete(@Param("id") Integer id);

    @Delete("DELETE course.*, " +
            "chapter.* " +
            "FROM " +
            "course " +
            "LEFT JOIN chapter ON course.id = chapter.course_id " +
            "WHERE " +
            "course.id = #{id};")
    void delete(@Param("id") Integer id);


    @Update("update course set name=#{course.name},teacher_id=#{course.teacherId}," +
            "attribute=#{course.attribute},ks=#{course.ks},face_img=#{course.faceImg} where id=#{course.id}")
    void update(@Param("course") Course course);




}
