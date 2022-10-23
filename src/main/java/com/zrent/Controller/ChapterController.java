package com.zrent.Controller;

import com.zrent.model.Chapter;
import com.zrent.model.Course;
import com.zrent.model.Pages;
import com.zrent.model.Response;
import com.zrent.service.ChapterService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;


/**
 * @author Zrent
 */
@RestController
@RequestMapping("/chapter")
public class ChapterController {
    @Resource
    private ChapterService chapterService;

    //物理路径
    @Value("${file.upload.path}")
    private String filePath;
    //显示虚拟地址
    @Value("${file.upload.relative}")
    private String fileRelativePath;

    @GetMapping("/list")
    public List<Chapter> listChapter(Integer courseId){
        List<Chapter> list = chapterService.list(courseId);
        String [] statusInfo = {"未学习","学习中","已学完"};


        for(Chapter chapter : list){
            chapter.setStatusInfo(statusInfo[chapter.getStatus()]);
        }
        return list;
    }

//    @GetMapping("/getPage")
//    public Pages<Chapter> getPage(Integer pageIndex, Integer pageSize, Integer courseId,String chapterName){
//        Pages<Chapter> pagers = chapterService.getPagers(pageIndex,pageSize,courseId,chapterName);
//        return pagers;
//    }

    @GetMapping("/getPage")
    public Pages<Chapter> getPage(Integer pageIndex, Integer pageSize, Integer courseId,String chapterName){
        Pages<Chapter> pagers = chapterService.getPagers(pageIndex,pageSize,courseId,chapterName);
        return pagers;
    }
    @GetMapping("/getCrsPage")
    public Pages<Chapter> getCrsPage(Integer pageIndex, Integer pageSize, Integer courseId,String chapterName){
        Pages<Chapter> pagers = chapterService.getCrsPage(pageIndex,pageSize,courseId,chapterName);
        return pagers;
    }




    @GetMapping("/add")
    public Response add(Chapter chapter){
        chapterService.add(chapter);
        return new Response(200,"success");
    }

    @GetMapping("/update")
    public void update(Chapter chapter){
        chapterService.update(chapter);

    }

    @GetMapping("/delete")
    public void delete(Integer id){
        chapterService.delete(id);

    }


    /**
     * 上传课程
     * @param video
     * @return
     * @throws IOException
     */

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public Response upload(@RequestParam("file") MultipartFile video) throws IOException {
        //获取文件原名
        String fileName =video.getOriginalFilename();
        //创建要上传的文件对象
        File newFile =new File(filePath,fileName);
//        将文件copy到目标地址
        video.transferTo(newFile);

        String filePath = fileRelativePath.replace("*","")+fileName;
        return new Response(200,"success",filePath);

    }








}
