package br.com.fiap.challenge.controllers;

import br.com.fiap.challenge.model.request.FavoriteRequest;
import br.com.fiap.challenge.model.response.FavoriteResponse;
import br.com.fiap.challenge.services.FavoriteService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/favorito")
public class FavoriteController {
    @Autowired
    private final FavoriteService service;

    public FavoriteController(FavoriteService service) {
        this.service = service;
    }

    @GetMapping
    public List<FavoriteResponse> findAll(@RequestParam("userId") Long userId) {
        return service.getAll(userId);
    }

    @PostMapping
    public FavoriteResponse save(@RequestBody FavoriteRequest favoriteRequest) {
        return service.save(favoriteRequest);
    }

    @PutMapping
    public void update(@RequestBody FavoriteRequest request) {
        service.update(request);
    }

    @PostMapping("/delete/{idFavorite}")
    @Transactional
    public ModelAndView delete(@PathVariable("idFavorite") Long idFavorite) {
        service.delete(idFavorite);
        ModelAndView mv = new ModelAndView("redirect:/home");
        return mv;
    }

    @GetMapping("/formulario")
    public ModelAndView formulario(FavoriteRequest request) {
        ModelAndView mv = new ModelAndView("favorito/formulario");
        mv.addObject("request", request);
        return mv;
    }

    @PostMapping("/novo")
    public ModelAndView novo(FavoriteRequest requisicao) {
        service.save(requisicao);
        ModelAndView mv = new ModelAndView("redirect:/home");
        return mv;
    }
}
