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
    CommentService commentService = new CommentService();
    private HttpSession session;

    /**
     * 根据类型获取所有的文章
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
                List<Comment> commentList = commentService.findNote(note.getId());

                note.setCommentList(commentList);
                note.setPhotos(photos);
                notes.add(note);
            }
        } catch (Exception e) {
            throw new ServiceException("" + e);
        }
        return notes;
    }

    /**
     * 发布评论
     *
     * @param json
     * @param request
     * @return
     */
    public @RequestMapping("saveComment")
    Message saveComment(@RequestBody JSONObject json, HttpServletRequest request) {
        session = request.getSession();
        Message message = new Message();
        Integer userId = (Integer) json.get("userId");
        String noteId = (String) json.get("noteId");
        String content = (String) json.get("content");
        Comment comment = new Comment();
        User user = new User();
        user.setId(userId);
        Note note = new Note();
        note.setId(noteId);
        comment.setUser(user);
        comment.setNote(note);
        comment.setContent(content);
        try {
            commentService.save(comment);
            List<Comment> list = commentService.findNote(noteId);
            message.setCases("1");
            message.setCommentList(list);
            message.setMsg("发布成功");
        } catch (Exception e) {
            message.setCases("-1");
            message.setMsg("评论发表失败");
        }
        //System.out.println(userId+":"+noteId+":"+content);
        return message;
    }

    /**
     * 文章点赞
     * @param json
     * @param request
     * @return
     */
    public @RequestMapping("noteUpVote") Note noteUpVote(@RequestBody JSONObject json,HttpServletRequest request){
        session = request.getSession();
        String id = (String) json.get("id");
        int upVote = (Integer)json.get("upVote");
        Note note;
        try {
            note = noteService.find(id);
            note.setUpVote(upVote);
            note.setDownVote((Integer)json.get("downVote"));
            noteService.update(note);
            note = noteService.find(id);
        }catch (Exception e){
            throw new ServiceException(""+e);
        }
        return note;
    }

    /**
     * 评论点赞
     * @param json
     * @param request
     * @return
     */
    public @RequestMapping("commentUpVote") Comment commentUpVote(@RequestBody JSONObject json,HttpServletRequest request){
        session = request.getSession();
        Integer id = (Integer) json.get("id");
        int upVote = (Integer)json.get("upVote");
        int downVote = (Integer)json.get("downVote");
        Comment comment;
        try {
            comment = commentService.find(id);
            comment.setUpVote(upVote);
            comment.setDownVote(downVote);
            commentService.update(comment);
            comment = commentService.find(id);
        }catch (Exception e){
            throw new ServiceException(""+e);
        }
        return comment;
    }



}
