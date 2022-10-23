package com.zrent.Controller;

import com.zrent.model.Course;
import com.zrent.model.Pages;
import com.zrent.model.Response;
import com.zrent.service.CourseService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author Zrent
 */
@RestController
@RequestMapping("/course")
public class CourseController {

    /**
     * 添加
     * 修改
     * 删除
     *
     * 列表
     * 查询
     * @return
     */
    @Resource
    private CourseService courseService;


    //物理路径
    @Value("${file.upload.path}")
    private String filePath;
    //显示虚拟地址
    @Value("${file.upload.relative}")
    private String fileRelativePath;

    @GetMapping("/list")
    public List<Course> list(){

        List<Course> list = courseService.list();
        return list;
    }

    @GetMapping("/getPage")
    public Pages<Course> getPage(Integer pageIndex,Integer pageSize,String courseName,String teacherName){
        Pages<Course> pagers = courseService.getPagers(pageIndex,pageSize,courseName,teacherName);

        return pagers;
    }


    /**
     * 保存课程
     * @param course
     */

    @GetMapping("/add")
    public void add(Course course){
        courseService.add(course);

    }



    /**
     * 上传课程封面
     * @param faceImg
     * @return
     * @throws IOException
     */

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public Response upload(MultipartFile faceImg) throws IOException{
        //获取文件原名
        String fileName =faceImg.getOriginalFilename();
        //创建要上传的文件对象
        File newFile =new File(filePath,fileName);
//        将文件copy到目标地址
        faceImg.transferTo(newFile);

        String filePath = fileRelativePath.replace("*","")+fileName;
        return new Response(200,"success",filePath);

    }




    @GetMapping("/delete")
    public void delete(Integer id){
        courseService.delete(id);

    }

    @GetMapping("/update")
    public void update(Course course){
        courseService.update(course);

    }

}
