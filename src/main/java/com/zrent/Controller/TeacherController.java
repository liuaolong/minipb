package com.zrent.Controller;

import com.zrent.model.Course;
import com.zrent.model.Pages;
import com.zrent.model.Response;
import com.zrent.model.Teacher;
import com.zrent.service.CourseService;
import com.zrent.service.TeacherService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @description:
 * @author:Zrent
 * @date : 2022/10/18
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController {

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
    private TeacherService teacherService;


    //物理路径
    @Value("${file.upload.path}")
    private String filePath;
    //显示虚拟地址
    @Value("${file.upload.relative}")
    private String fileRelativePath;

    @GetMapping("/list")
    public List<Teacher> list(){

        List<Teacher> list = teacherService.list();
        return list;
    }

    @GetMapping("/getPage")
    public Pages<Teacher> getPage(Integer pageIndex, Integer pageSize, String teacherName){
        Pages<Teacher> pagers = teacherService.getPagers(pageIndex,pageSize,teacherName);

        return pagers;
    }


    /**
     * 保存课程
     * @param teacher
     */

    @GetMapping("/add")
    public void add(Teacher teacher){
        teacherService.add(teacher);

    }



    /**
     * 上传课程封面
     * @param photo
     * @return
     * @throws IOException
     */

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public Response upload(MultipartFile photo) throws IOException {
        //获取文件原名
        String fileName =photo.getOriginalFilename();
        //创建要上传的文件对象
        File newFile =new File(filePath,fileName);
//        将文件copy到目标地址
        photo.transferTo(newFile);

        String filePath = fileRelativePath.replace("*","")+fileName;
        return new Response(200,"success",filePath);

    }




    @GetMapping("/delete")
    public void delete(Integer id){
        teacherService.delete(id);

    }

    @GetMapping("/update")
    public void update(Teacher teacher){
        teacherService.update(teacher);

    }

}
