package com.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 文件上传的处理器
 */
@Controller
@Slf4j
public class FormController {

    /**
     *这个处理器是处理文件上传功能
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("username")String username,
                         @RequestParam("email")String email,
                         @RequestPart("headerImg") MultipartFile headerImg,
                         @RequestPart("photos")MultipartFile[] photos) throws IOException {

        log.info("上传的信息:username={},email={},headerImg={},photos={}",
                username,email,headerImg.getSize(),photos.length);

        if(!headerImg.isEmpty()){
            //保存到文件服务器，OSS服务器
            String originalFilename = headerImg.getOriginalFilename();
            headerImg.transferTo(new File("D:\\temp\\"+originalFilename));
            log.info("originalFilename={}",originalFilename);
        }

        if(photos.length > 0){
            for(MultipartFile photo : photos){
                if(!photo.isEmpty()){
                    String originalFilename = photo.getOriginalFilename();
                    photo.transferTo(new File("D:\\temp\\"+originalFilename));
                    log.info("originalFilename={}",originalFilename);
                }
            }
        }

        return "main";
    }

    /**
     * @return 跳转到文件上传的页面
     */
    @GetMapping("/form_layouts")
    public String form_layouts(){

        return "forms/form_layouts";
    }



}
