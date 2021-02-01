package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.model.Comment;
import com.survivingcodingbootcamp.blog.storage.PostStorage;
import com.survivingcodingbootcamp.blog.storage.TopicStorage;
import com.survivingcodingbootcamp.blog.storage.repository.commentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class commentController {
    private PostStorage postStorage;


    private commentRepository commentRepo;

    public commentController(PostStorage postStorage, commentRepository commentRepo) {
        this.postStorage = postStorage;

        this.commentRepo = commentRepo;
    }
    @RequestMapping("/addComment/{id}")
    public String addNewComment(@PathVariable Long id, @RequestParam String newComment, Model model){
        Comment addComment = new Comment(newComment,postStorage.retrievePostById(id));
        commentRepo.save(addComment);

        return "redirect:/posts/{id}";

    }

    @RequestMapping("/{id}")
    public String displayAllComment(@PathVariable long id, Model model) {
        model.addAttribute("AllComment",postStorage.retrievePostById(id).getComments());
        return "single-post-template";
    }

}
