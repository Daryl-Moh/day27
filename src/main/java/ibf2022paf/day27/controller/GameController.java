package ibf2022paf.day27.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import ibf2022paf.day27.model.Comment;
import ibf2022paf.day27.model.Game;
import ibf2022paf.day27.service.GameService;

@Controller
@RequestMapping("/game")
public class GameController {
    
    @Autowired
    private GameService gameSvc;

    @PostMapping(path="/comment")
    public String postComment(@RequestBody MultiValueMap<String, String> form){
        Comment comment = Comment.create(form);
        String commentId = gameSvc.addComment(comment);
        System.out.printf(">>>> commentId: %s\n", commentId);
        return "redirect:/";
    }

    @GetMapping(path="/{gameId}")
    public String getGame(Model model, @PathVariable int gameId) {

        Optional<Game> opt = gameSvc.getGameByGameId(gameId);

        if (opt.isEmpty())
            return "not-found";

        model.addAttribute("game", opt.get());

        return "display-game";
    }
 
}
