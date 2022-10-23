package com.zrent.mapper;

import com.zrent.model.Chapter;
import com.zrent.model.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Zrent
 */
@Mapper
public interface ChapterMapper {

    @Select("SELECT c1.id,c1.course_id,c2.name courseName,c1.name,c1.info,c1.video,c1.status" +
            " FROM chapter c1 JOIN course c2 ON c1.course_id=c2.id where c1.course_id = #{id}")
    List<Chapter> list(@Param("id") Integer courseId);




    @Select({"<script> " +
            "select count(*) from chapter c1 join course c2 on c1.course_id=c2.id where c1.course_id = c2.id " +
            "<where>" +
            "<if test='chapterName != null'> and c1.name like '%${chapterName}%' </if> "+
            "</where> "+
            "</script>"})
    int getRecordCount(@Param("chapterName") String chapterName);

    @Select("<script>select c.id,c.name,c.course_id,t.name courseName, c.info,c.video,c.status " +
            "from chapter c left JOIN course t ON c.course_id=t.id" +
            "<where>"+
            "<if test='courseId != null'> and c.id like '%${courseId}%' </if> "+
            "<if test='chapterName != null'> and t.name like '%${chapterName}%' </if> "+
            "</where>"+
            "LIMIT #{recordStart},#{pageSize} " +
            "</script>")
    List<Chapter> queryCourse(@Param("recordStart") Integer recordStart,
                             @Param("pageSize") Integer pageSize,
                             @Param("courseId") Integer courseId,
                             @Param("chapterName") String chapterName);

    @Insert("insert into chapter(name,course_id,info,video) value(#{chapter.name},#{chapter.courseId},#{chapter.info},#{chapter.video}) ")
    void add(@Param("chapter") Chapter chapter);

    @Update("update chapter set name=#{chapter.name},course_id=#{chapter.courseId}," +
            "info=#{chapter.info},video=#{chapter.video} where id=#{chapter.id}")
    void update(@Param("chapter") Chapter chapter);

    @Delete("delete from chapter where id=#{id}")
    void delete(Integer id);



    @Select("<script>select c.id,c.name,c.course_id,t.name courseName, c.info,c.video,c.status " +
            "from chapter c JOIN course t ON c.course_id = t.id and c.course_id=#{courseId}" +
            "<where>"+
//            "<if test='courseId != null'> and t.id like '%${courseId}%' </if> "+
            "<if test='chapterName != null'> and t.name like '%${chapterName}%' </if> "+
            "</where>"+
            "LIMIT #{recordStart},#{pageSize} " +
            "</script>")
    List<Chapter> queryCourseCrs(@Param("recordStart") Integer recordStart,
                                 @Param("pageSize") Integer pageSize,
                                 @Param("courseId") Integer courseId,
                                 @Param("chapterName") String chapterName);

    @Select({"<script> " +
            "select count(*) from chapter c1 join course c2 on c1.course_id=c2.id " +
            "where c1.course_id = c2.id and c2.id = #{courseId}" +
            "<where>" +
            "<if test='chapterName != null'> and c1.name like '%${chapterName}%' </if> "+
            "</where> "+
            "</script>"})
    int getRecordCountDrs(@Param("chapterName") String chapterName,
                          @Param("courseId") Integer courseId);




}
