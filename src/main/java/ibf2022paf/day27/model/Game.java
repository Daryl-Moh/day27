package ibf2022paf.day27.model;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class Game {
    
    private Integer gameId;
    private String name;
    private Integer ranking;
    private String url;
    private String image;

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public static Game createSummary(SqlRowSet rs) {
        Game game = new Game();
        game.setGameId(rs.getInt("gid"));
        game.setName(rs.getString("name"));
        return game;
    }

    public static Game create(SqlRowSet rs) {
        Game game = new Game();
        game.setGameId(rs.getInt("gid"));
		game.setName(rs.getString("name"));
		game.setRanking(rs.getInt("ranking"));
		game.setUrl(rs.getString("url"));
		game.setImage(rs.getString("image"));
		return game;
    }
    
}
