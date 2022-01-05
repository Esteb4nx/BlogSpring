package com.ufro.BlogPersonal.controller;

import com.ufro.BlogPersonal.model.Post;
import com.ufro.BlogPersonal.model.User;
import com.ufro.BlogPersonal.repository.PostRepository;
import com.ufro.BlogPersonal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("/entry")
public class EntryController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String main(@RequestParam(value = "id") Long id, Model model) {
        // Ya que consultamos directo a CrudRepository obtenemos un Optional<T>
        Optional<Post> post = postRepository.findById(id);

        // añade el elemento si está presente
        model.addAttribute("post", post.orElseThrow());
        return "entrada";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam(value = "id") Long id, Model model) {
        Optional<Post> post = postRepository.findById(id);
        model.addAttribute("post", post.orElseThrow());
        return "editar-entrada";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Post post){
        postRepository.save(post);
        return "redirect:/entry?id=" + post.getId();
    }

    // new entry related mappings
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("post", new Post());
        // TODO: cambiar nombres de html a un solo idioma para ordenar código y mejore coherencia con el backend (inglés p.ej.)
        return "nueva-entrada";
    }
    
    @PostMapping("/submit")
    public String submit(@ModelAttribute Post post) {
        Date date = new Date();
        Timestamp sqlTimestamp = new Timestamp(date.getTime());
        post.setPostDate(sqlTimestamp);

        // Todo asignar usuario por Principal
        Optional<User> author = userRepository.findById(1L);
        post.setAuthor(author.orElseThrow());
        postRepository.save(post);
        return "redirect:/entry?id=" + post.getId();
    }

    // delete entry mapping
    @RequestMapping("/delete")
    public String delete(@RequestParam(value = "id") Long id) {
        postRepository.deleteById(id);
        return "redirect:/?deleted";
    }

}
