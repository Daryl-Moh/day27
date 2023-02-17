package ibf2022paf.day27.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibf2022paf.day27.model.Comment;
import ibf2022paf.day27.model.Game;
import ibf2022paf.day27.repository.CommentRepository;
import ibf2022paf.day27.repository.GameRepository;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepo;

    @Autowired
    private CommentRepository commentRepo;

    public String addComment (Comment comment) {
        String commentId = UUID.randomUUID().toString().substring(0,8);
        comment.setCommentId(commentId);
        commentRepo.insertComment(comment);
        return commentId;
    }

    public Optional<Game> getGameByGameId(int gameId) {
        return gameRepo.getGameByGameId(gameId);
    }

    public List<Game> getGames() {
        return getGames(30,0);
    }

    public List<Game> getGames(int limit, int offset) {
        return gameRepo.getGames(limit, offset);
    }
}

