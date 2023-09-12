package br.com.fiap.challenge.controllers;

import br.com.fiap.challenge.model.entities.Favorite;
import br.com.fiap.challenge.repositories.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private FavoriteRepository repository;

    @GetMapping
    public ModelAndView home() {
        List<Favorite> favoritos = repository.findAll();

        ModelAndView mv = new ModelAndView("home");
        mv.addObject("favoritos", favoritos);
        return mv;
    }
}
