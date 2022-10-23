package com.zrent.mapper;

import com.zrent.model.Course;
import com.zrent.model.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @description:
 * @author:Zrent
 * @date : 2022/10/18
 */
@Mapper
public interface TeacherMapper {

    @Select("select id,account,name,phone,mail,level,photo,add_time from teacher")
    List<Teacher> list();



    @Select({"<script> " +
            "select count(*) from teacher " +
//            "c left join teacher t on c.teacher_id=t.id " +
            "<where>" +
//            "<if test='courseName != null'> and c.name like '%${courseName}%' </if> "+
            "<if test='teacherName != null'> and t.name like '%${teacherName}%' </if> "+
            "</where> "+
            "</script>"})
    int getRecordCount(
//                        @Param("courseName") String courseName,
                       @Param("teacherName") String teacherName);

    @Select("<script>select id,account,name,phone,mail,level,photo,add_time " +
            "from teacher " +
            "<where>"+
//            "<if test='courseName != null'> and c.name like '%${courseName}%' </if> "+
            "<if test='teacherName != null'> and t.name like '%${teacherName}%' </if> "+
            "</where>"+
            "LIMIT #{recordStart},#{pageSize} " +
            "</script>")
    List<Teacher> queryCourse(@Param("recordStart") Integer recordStart,
                             @Param("pageSize") Integer pageSize,
//                             @Param("courseName") String courseName,
                             @Param("teacherName") String teacherName);

    @Insert("insert into teacher(account,name,phone,mail,level,photo) " +
            "value(#{teacher.account},#{teacher.name},#{teacher.phone}," +
            "#{teacher.mail},#{teacher.level},#{teacher.photo}) ")
    void add(@Param("teacher") Teacher teacher);

    @Delete("delete from teacher where id=#{id}")
    void delete(@Param("id") Integer id);

    @Update("update teacher set account=#{teacher.account},name=#{teacher.name}," +
            "phone=#{teacher.phone},mail=#{teacher.mail},level=#{teacher.level}," +
            "photo=#{teacher.photo} where id=#{teacher.id}")
    void update(@Param("teacher") Teacher teacher);


}
