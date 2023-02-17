package ibf2022paf.day27.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ibf2022paf.day27.model.Game;
import ibf2022paf.day27.service.GameService;

@Controller
@RequestMapping
public class IndexController {

    @Autowired
    private GameService gameSvc;

    @GetMapping(path={"/", "/index.html"})
    public String getGames(Model model,
        @RequestParam(defaultValue = "30") int limit,
        @RequestParam(defaultValue = "0") int offset){

        List<Game> games = gameSvc.getGames(limit, offset);
        model.addAttribute("games", games);
        model.addAttribute("next", offset + limit);
        return "index";

    }
}
