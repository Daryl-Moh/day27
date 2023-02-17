package ibf2022paf.day27.repository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import ibf2022paf.day27.model.Game;

import static ibf2022paf.day27.repository.Queries.*;

@Repository
public class GameRepository {

    @Autowired
    private JdbcTemplate template;

    public Optional<Game> getGameByGameId(int gameId) {

        SqlRowSet rs = template.queryForRowSet(SQL_SELECT_GAME_BY_GID, gameId);

        if(!rs.next())
            return Optional.empty();

        return Optional.of(Game.create(rs));

    }
    
    public List<Game> getGames() {
        return getGames(30, 0);
    }

    public List<Game> getGames(int limit, int offset) {

        SqlRowSet rs = template.queryForRowSet(SQL_SELECT_GAMES, limit, offset);
        
        List<Game> games = new LinkedList<>();
        while (rs.next())
            games.add(Game.createSummary(rs));

        return games;
    }

    
}
