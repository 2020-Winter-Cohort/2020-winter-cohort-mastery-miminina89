package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.model.Hashtag;
import com.survivingcodingbootcamp.blog.storage.HashtagStorageJpaImpl;
import com.survivingcodingbootcamp.blog.storage.PostStorageJpaImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

public class HashtagController {
   private HashtagStorageJpaImpl hashtagStorage;
   private PostStorageJpaImpl postStorage;

    public HashtagController(HashtagStorageJpaImpl hashtagStorage,PostStorageJpaImpl postStorage) {

        this.hashtagStorage = hashtagStorage;
        this.postStorage=postStorage;
    }
    @RequestMapping("/hashtag/{id}")
    public String displaySingleHashtag(@PathVariable long id, Model model) {
        model.addAttribute("hashtag", hashtagStorage.retrieveHashtagById(id).getPosts());
        return "single-hashtag-template";
    }
    @RequestMapping("hashtags")
    public String displayAllHashtag(Model model ){

        model.addAttribute("hashtags",hashtagStorage.retrieveAllHashtag());
       return "all-hashtags-template";
    }
    @PostMapping("addHashtag/{id}")
    public String addHashtag(@PathVariable Long id,@RequestParam String newHashtag){
        Hashtag addHashtag = new Hashtag(newHashtag, postStorage.retrievePostById(id));
        hashtagStorage.save(addHashtag);

        return "redirect:/posts/{id}";
    }

}
