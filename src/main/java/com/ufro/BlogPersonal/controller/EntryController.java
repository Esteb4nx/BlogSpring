/*
 *  @author Jorge M.
 *  04-01-2022
 */

package com.ufro.BlogPersonal.controller;

import com.ufro.BlogPersonal.model.Post;
import com.ufro.BlogPersonal.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/entry")
public class EntryController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping
    public String entry(@RequestParam(value = "id") Long id, Model model) {
        // Ya que consultamos directo a CrudRepository obtenemos un Optional<T>
        Optional<Post> post = postRepository.findById(id);

        // añade el elemento si está presente
        model.addAttribute("post", post.orElseThrow());
        return "entrada";
    }


}