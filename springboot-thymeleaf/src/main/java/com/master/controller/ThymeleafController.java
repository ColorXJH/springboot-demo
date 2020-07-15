package com.master.controller;

import com.master.model.FileModel;
import com.master.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ColorXJH
 * @version 1.0
 * @date 2020/7/12 12:02
 */
@Controller
public class ThymeleafController {
    Logger logger= LoggerFactory.getLogger(ThymeleafController.class);
    private static final String UPLOAD_FOLDER="springboot-thymeleaf/src/main/resources/fileupload";
    @GetMapping("/index")
    public String index(Model model, HttpServletRequest request, HttpServletResponse response){
        model.addAttribute("message","ColorXJHLoveDearBear");
        model.addAttribute("usename","dearbear77");
        model.addAttribute("flag","yes");
        model.addAttribute("date",new Date());
        List<User> lists=new ArrayList<>();
        User user1=new User();
        model.addAttribute("habbit","sing");
        user1.setName("ColorXJH");user1.setAge(27);user1.setWeight(130);
        User user2=new User();
        model.addAttribute("user1",user1);
        user2.setName("DearBear");user2.setAge(26);user2.setWeight(110);
        lists.add(user1);lists.add(user2);
        model.addAttribute("users",lists);
        request.setAttribute("request","i am a resquest");
        request.getSession().setAttribute("session","i am a session");
        return "hello";
    }
    @GetMapping("/newindex")
    public String newIndex(){
        return "index";
    }
    @GetMapping("/getFragment")
    public String getFragment(){
        return "fragment";
    }

    @RequestMapping("/layout")
    public String layout() {
        return "layout";
    }

    @RequestMapping("/homepage")
    public String home() {
        return "newpage";
    }
    @GetMapping("/toUploadPage")
    public String getUploadPage(){
        return "upload";
    }
    @GetMapping("/multiupload")
    public String getMultiUpload(){
        return "multiupload";
    }
    @GetMapping("/uploadResult")
    public String getUploadResult(@RequestParam("name")String name ,Model model){
        model.addAttribute("name",name);
        return "uploadResult";
    }


    //单文件上传
    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file")MultipartFile file, RedirectAttributes redirectAttributes){
        //查看是否有该文件夹 --相对路径
        File filedir=new File(UPLOAD_FOLDER);
        if(!filedir.exists()){
            //递归生成文件夹
            filedir.mkdirs();
        }

        if(file.isEmpty()){
            //redirectAttributes.addFlashAttribute重定向带参数，放到session中，刷新之后消失，
            //redirectAttributes.addAttribute()重定向带参数,放在url后面，刷新之后不消失，明文
            redirectAttributes.addAttribute("name","XJH");
            redirectAttributes.addFlashAttribute("message","please select a file to upload");
            return "redirect:/uploadResult";
        }

        //构建真实的文件路径
        File newFile=new File(filedir.getAbsolutePath()+File.separator+file.getOriginalFilename());

        try {
            //方法1
            Path path= Paths.get(newFile.getAbsolutePath());
            byte[] bytes = file.getBytes();
            Files.write(path,bytes);
            //方法2
            //file.transferTo(newFile);
            redirectAttributes.addAttribute("name","DearBear");
            redirectAttributes.addFlashAttribute("message","you successfully upload a file:"+file.getOriginalFilename());
        }  catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/uploadResult";
    }

    //多文件上传
    @PostMapping("/multiupload")
    public String multiUpload(@RequestParam("file") MultipartFile [] files,RedirectAttributes attributes){
        if(files.length==0){
            attributes.addFlashAttribute("message","please select one or more file");
            return "redirect:/uploadResult";
        }
        File FileDir=new File(UPLOAD_FOLDER);
        if(!FileDir.exists()){
            FileDir.mkdirs();
        }


        for(MultipartFile file:files){
            //绝对路径的文件
            File newFile=new File(FileDir.getAbsolutePath()+File.separator+file.getOriginalFilename());
            try {
                byte[] bytes =file.getBytes();
                //绝对路径
                Path path=Paths.get(newFile.getAbsolutePath());
                Files.write(path,bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        attributes.addFlashAttribute("message","successful");
        return "redirect:/uploadResult";
    }
    //获取文件名称
    @GetMapping("/getFileList")
    public String getFileList(Model model){
        List<FileModel>list=new ArrayList<>();
        File file=new File(UPLOAD_FOLDER);//相对路径文件
        File newFile=new File(file.getAbsolutePath());//绝对路径文件

        File[] files=newFile.listFiles();
        for(File f:files){
            FileModel fmodel=new FileModel();
            fmodel.setFilename(f.getName());
            fmodel.setAddress(f.toString());
            list.add(fmodel);
        }
        model.addAttribute("lists",list);
        return "filelist";
    }

    //文件下载
    @GetMapping("/download")
    @ResponseBody
    public String downloadFile(String filename,String shortName,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
        if(filename!=null){
            File file=new File(filename);
            if(file.exists()){
                response.setContentType("application/force-download");
                response.addHeader("Content-Disposition","attachment;fileName="+new String( shortName.getBytes("gb2312"), "ISO8859-1" ));
                byte[] buffer=new byte[1024];
                FileInputStream fis=null;
                BufferedInputStream bis=null;
                try {
                    fis=new FileInputStream(file);
                    bis=new BufferedInputStream(fis);
                    OutputStream os=response.getOutputStream();
                    int i=bis.read(buffer);
                    while(i!=-1){
                        os.write(buffer,0,i);
                        i=bis.read(buffer);
                    }
                    return "success download";
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        bis.close();
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }


            }
        }
        return "error !!!";
    }
}
