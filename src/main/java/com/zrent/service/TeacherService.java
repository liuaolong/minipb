package com.zrent.service;

import com.zrent.mapper.CourseMapper;
import com.zrent.mapper.TeacherMapper;
import com.zrent.model.Course;
import com.zrent.model.Pages;
import com.zrent.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author:Zrent
 * @date : 2022/10/18
 */
@Service
public class TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    public List<Teacher> list(){
        List<Teacher> list = teacherMapper.list();
        for(Teacher teacher:list){
            if (teacher.getLevel().equals("1")) {
                teacher.setLevel(1);

            }else if (teacher.getLevel().equals("2")){
                teacher.setLevel(2);
            }
        }

        return list;
    }

    /**
     * 分页
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public Pages<Teacher> getPagers(Integer pageIndex, Integer pageSize,String teacherName){

        //起始条数
        Integer recordStart = (pageIndex - 1) * pageSize;
        //获取data
        List<Teacher> data = teacherMapper.queryCourse(recordStart,pageSize,teacherName);

//        for(Course course:data){
//            if (course.getAttribute().equals("1")) {
//                course.setAttribute("公开课");
//
//            }else if (course.getAttribute().equals("2")){
//                course.setAttribute("标准课");
//            }
//        }

        int totalRecord = teacherMapper.getRecordCount(teacherName);
        //计算总页数
        Integer totalPage = totalRecord%pageSize == 0? totalRecord%pageSize : totalRecord%pageSize +1;
//        List<Pages> pagers = new ArrayList<>();
        //组装page对象
        Pages<Teacher> pages = new Pages(pageSize,totalPage,totalRecord,pageIndex,data);

        return pages;
    }




    public void add(Teacher teacher) {
        teacherMapper.add(teacher);
    }
    public void delete(Integer id) {
        teacherMapper.delete(id);
    }
    public void update(Teacher teacher) {
        teacherMapper.update(teacher);
    }
}
