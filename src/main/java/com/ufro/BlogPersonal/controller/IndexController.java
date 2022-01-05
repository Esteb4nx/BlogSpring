package com.ufro.BlogPersonal.controller;

import com.ufro.BlogPersonal.model.Post;
import com.ufro.BlogPersonal.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @Autowired
    PostRepository postRepository;

    @RequestMapping("/")
    public String main(Model model){
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts",posts);

        return "index";
    }
}
