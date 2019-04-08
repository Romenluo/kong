package com.li.kong.web;

import com.alibaba.fastjson.JSONObject;
import com.li.kong.entity.*;
import com.li.kong.exception.ServiceException;
import com.li.kong.service.*;
import com.li.kong.utils.MessageDigestType;
import com.li.kong.utils.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/app")
public class App {

    NoteService noteService = new NoteService();
    PhotosService photosService = new PhotosService();
    private HttpSession session;

    @RequestMapping("/home")
    String home() {
        return "你好，世界!";
    }

    /**
     * 获取验证码，返回提示消息
     *
     * @return
     */
    public @RequestMapping("getNote")
    List<Note> findNote(@RequestBody JSONObject json, HttpServletRequest request) {
        session = request.getSession();
        Integer id = (Integer) json.get("id");
        List<Note> list;
        List<Note> notes = new ArrayList<>();
        try {
            list = noteService.findCategoryAll(id);
            for (Note note : list) {
                Photos photos = photosService.find(note.getId());
                note.setPhotos(photos);
                notes.add(note);
            }
        } catch (Exception e) {
            throw new ServiceException("" + e);
        }
        return notes;
    }


}
