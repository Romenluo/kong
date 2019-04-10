package com.li.kong.web;

import com.alibaba.fastjson.JSONObject;
import com.li.kong.entity.*;
import com.li.kong.exception.ServiceException;
import com.li.kong.service.*;
import com.li.kong.utils.StringHelper;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 后端管理控制器
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/manager")
public class Manager {
    private UserService us = new UserService();
    private NoteService noteService = new NoteService();
    CategoryService categoryService = new CategoryService();
    InformationService infoService = new InformationService();
    PhotosService photosService = new PhotosService();
    CommentService commentService = new CommentService();
    private HttpSession session;

    public @RequestMapping("findAllUser")
    List<User> findAllUser() {
        try {
            List<User> list = us.findAll();
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 用户管理，对用户进行禁用或解除冻结
     *
     * @param json
     * @param request
     * @return
     */
    public @RequestMapping("updateForbidden")
    Message updateForbidden(@RequestBody JSONObject json, HttpServletRequest request) {
        session = request.getSession();
        Message message = new Message();
        String email = (String) json.get("email");
        String forbidden = (String) json.get("forbidden");
        System.out.println(email + ":" + forbidden);
        User user = new User();
        user.setEmail(email);
        user.setForbidden(forbidden);
        boolean dd = us.updateForbidden(user);
        String msg = "N".equals(forbidden) ? "用户已经解封" : "用户已经被禁用";
        if (dd == true) {
            message.setCases("1");
            List<User> list = us.findAll();
            message.setList(list);
            message.setMsg(msg);
        } else {
            message.setCases("1");
            List<User> list = us.findAll();
            message.setList(list);
            message.setMsg(msg);
        }
        return message;
    }

    /**
     * 查询所有的分类，并返回页面
     *
     * @return
     */
    public @RequestMapping("findAllCategory")
    Message findAllCategory() {
        Message message = new Message();
        try {
            List<Category> list = categoryService.findAll();
            message.setCases("1");
            message.setMsg("获取类型成功");
            message.setCategoryList(list);

        } catch (Exception e) {
            message.setCases("-1");
            message.setMsg("获取类型失败");
        }
        return message;
    }

    /**
     * 保存文章
     *
     * @return
     */
    public @RequestMapping("saveNote")
    Message saveNote(@RequestBody JSONObject json, HttpServletRequest request) {
        Message message = new Message();
        Photos photos = new Photos();

        photos.setImageUrl((String)json.get("imageName"));
        photos.setId(StringHelper.random());
        photos.setTitle((String) json.get("title"));

        String id = StringHelper.random();
        String name = (String) json.get("category");
        try {
            Category category = categoryService.find(name);
            Note note = new Note();
            note.setId(id);
            note.setTitle((String) json.get("title"));
            note.setContent((String) json.get("content"));
            note.setCategory(category);
            noteService.save(note);
            photos.setNote(note);
            photosService.save(photos);
            message.setCases("1");
            message.setMsg("保存成功");
        } catch (Exception e) {
            message.setCases("-1");
            message.setMsg("保存失败");
        }
        return message;
    }

    /**
     * 保存实时资讯
     *
     * @param json 前端传过来的json数据
     * @return
     */
    public @RequestMapping("saveInfo")
    Message saveInfo(@RequestBody JSONObject json) {
        Message message = new Message();
        String title = (String) json.get("title");
        String content = (String) json.get("content");
        Information information = new Information();
        information.setTitle(title);
        information.setContent(content);
        try {
            infoService.save(information);
            message.setCases("1");
            message.setMsg("保存成功");
        } catch (Exception e) {
            message.setCases("-1");
            message.setMsg("保存失败");
        }
        return message;
    }

    /**
     * 获取所有的实时资讯
     *
     * @return
     */
    public @RequestMapping("findAllInfo")
    List<Information> findAllInfo() {
        List<Information> list;
        try {
            list = infoService.findAll();
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 删除实时资讯
     *
     * @param json
     * @return
     */
    public @RequestMapping("deleteInfo")
    Message deleteInfo(@RequestBody JSONObject json) {
        Message message = new Message();
        Integer id = (Integer)json.get("id");
        boolean bb = infoService.deleteInfo(id);
        if (bb == true) {
            message.setCases("1");
            message.setMsg("删除成功");
        } else {
            message.setCases("-1");
            message.setMsg("删除失败");
        }
        return message;
    }

    /**
     * 修改实时资讯
     * @param json
     * @param request
     * @return
     */
    public @RequestMapping("updateInfo") Message updateInfo(@RequestBody JSONObject json,HttpServletRequest request){
        session = request.getSession();
        Message message = new Message();
        int id = (Integer) json.get("id");
        String content = (String)json.get("content");
        Information information;
        try {
            information = infoService.find(id);
            information.setTitle((String)json.get("title"));
            information.setContent(content);
            infoService.update(information);
            message.setCases("1");
            message.setMsg("修改成功");
        }catch (Exception e){
            message.setCases("1");
            message.setMsg("修改失败");
            throw new ServiceException(""+e);
        }
        return message;
    }

    /**
     * 修改文章内容
     * @param json
     * @param request
     * @return
     */
    public @RequestMapping("updateNote") Message updateNote(@RequestBody JSONObject json,HttpServletRequest request){
        session = request.getSession();
        Message message = new Message();
        String id = (String) json.get("id");
        String title = (String)json.get("title");
        String name = (String)json.get("categoryValue");
        String content = (String)json.get("content");
        try {
            Note note = noteService.find(id);
            note.setTitle(title);
            note.setContent(content);
            Photos photos = photosService.find(id);
            photos.setTitle(title);
            photos.setImageUrl((String)json.get("imageName"));
            photos.setNote(note);
            //查询类型
            Category category = categoryService.find(name);
           note.setCategoryId(category.getId());
            noteService.update(note);
            photosService.update(photos);
            message.setCases("1");
            message.setMsg("修改成功");
        }catch (Exception e){
            message.setCases("1");
            message.setMsg("修改失败");
            throw new ServiceException(""+e);
        }
        return message;
    }

    public @RequestMapping("deleteNote")
    Message deleteNote(@RequestBody JSONObject json) {
        Message message = new Message();
        String id = (String)json.get("id");
        try {
            noteService.delete(id);
            message.setCases("1");
            message.setMsg("删除成功");
        }catch (Exception e){
            message.setCases("-1");
            message.setMsg("删除失败");
        }
        return message;
    }

    /**
     * 删除评论
     * @param json
     * @return
     */
    public @RequestMapping("deleteComment")
    Message deleteComment(@RequestBody JSONObject json) {
        Message message = new Message();
        Integer id = (Integer) json.get("id");
        String noteId = (String) json.get("noteId");
        try {
            commentService.delete(id);
            List<Comment> list = commentService.findNote(noteId);
            message.setCommentList(list);
            message.setCases("1");
            message.setMsg("删除评论成功");
        }catch (Exception e){
            message.setCases("-1");
            message.setMsg("删除评论失败");
        }
        return message;
    }

    public @RequestMapping("uploadImage")
    String uploadImage() {
        return "上传成功";
    }

    @PostMapping(value = "/fileUpload")
    public String fileUpload(@RequestParam(value = "file") MultipartFile file, Model model, HttpServletRequest request) {
        if (file.isEmpty()) {
            System.out.println("文件为空空");
        }
        String fileName = file.getOriginalFilename();  // 文件名
        System.out.println(fileName);
        /*String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        String filePath = "D://temp-rainy//"; // 上传后的路径

        File dest = new File(fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String filename = "/temp-rainy/" + fileName;
        model.addAttribute("filename", filename);*/
        return "file";
    }

}
