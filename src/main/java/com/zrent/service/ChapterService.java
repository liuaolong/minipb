package com.zrent.service;

import com.zrent.mapper.ChapterMapper;
import com.zrent.model.Chapter;
import com.zrent.model.Course;
import com.zrent.model.Pages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zrent
 */
@Service
public class ChapterService {
    @Autowired
    private ChapterMapper chapterMapper;

    public List<Chapter> list(Integer courseId) {
        return chapterMapper.list(courseId);
    }

    /**
     * 分页
     * @param pageIndex
     * @param pageSize
     * @param courseId
     * @param chapterName
     * @return
     */
    public Pages<Chapter> getPagers(Integer pageIndex,Integer pageSize,Integer courseId,String chapterName){
        //起始条数
        Integer recordStart = (pageIndex - 1) * pageSize;
        //获取data
        List<Chapter> data = chapterMapper.queryCourse(recordStart,pageSize,courseId,chapterName);
        String [] statusInfo = {"未学习","学习中","已学完"};

        for(Chapter chapter : data){
            chapter.setStatusInfo(statusInfo[chapter.getStatus()]);
        }

        int totalRecord = chapterMapper.getRecordCount(chapterName);
        //计算总页数
        Integer totalPage = totalRecord%pageSize == 0? totalRecord%pageSize : totalRecord%pageSize +1;
//        List<Pages> pagers = new ArrayList<>();
        //组装page对象
        Pages<Chapter> pages = new Pages(pageSize,totalPage,totalRecord,pageIndex,data);

        return pages;
    }


    public void add(Chapter chapter) {
        chapterMapper.add(chapter);
    }

    public void update(Chapter chapter) {
        chapterMapper.update(chapter);
    }

    /**
     * 通过课程id进行分页
     * @param pageIndex
     * @param pageSize
     * @param courseId
     * @param chapterName
     * @return
     */
    public Pages<Chapter> getCrsPage(Integer pageIndex, Integer pageSize, Integer courseId, String chapterName) {
        //起始条数
        Integer recordStart = (pageIndex - 1) * pageSize;
        //获取data
        List<Chapter> data = chapterMapper.queryCourseCrs(recordStart,pageSize,courseId,chapterName);
        String [] statusInfo = {"未学习","学习中","已学完"};

        for(Chapter chapter : data){
            chapter.setStatusInfo(statusInfo[chapter.getStatus()]);
        }

        int totalRecord = chapterMapper.getRecordCountDrs(chapterName,courseId);
        //计算总页数
        Integer totalPage = totalRecord%pageSize == 0? totalRecord%pageSize : totalRecord%pageSize +1;
//        List<Pages> pagers = new ArrayList<>();
        //组装page对象
        Pages<Chapter> pages = new Pages(pageSize,totalPage,totalRecord,pageIndex,data);

        return pages;
    }

    public void delete(Integer id) {
        chapterMapper.delete(id);
    }
}
