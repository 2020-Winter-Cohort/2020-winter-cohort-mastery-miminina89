package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.model.Hashtag;
import com.survivingcodingbootcamp.blog.model.Topic;
import com.survivingcodingbootcamp.blog.storage.PostStorage;
import com.survivingcodingbootcamp.blog.storage.TopicStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/topics")
public class TopicController {

    private TopicStorage topicStorage;
    private PostStorage postStorage;

    public TopicController(TopicStorage topicStorage) {

        this.topicStorage = topicStorage;
    }
    @GetMapping("/{id}")
    public String displaySingleTopic(@PathVariable long id, Model model) {
        model.addAttribute("topic", topicStorage.retrieveSingleTopic(id));
        return "single-topic-template";
    }
    @PostMapping("addTopic")
    public String addTopic(@RequestParam String newTopic){

        Topic addTopic = new Topic(newTopic);
        topicStorage.save(addTopic);

        return "redirect:/";
    }

}
