package ibf2022paf.day27.model;

import org.bson.Document;
import org.springframework.util.MultiValueMap;

public class Comment {

    private String commentId;
	private int gameId;
	private String userName;
	private int rating;
	private String comment;

    public String getCommentId() {
        return commentId;
    }
    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }
    public int getGameId() {
        return gameId;
    }
    public void setGameId(int gameId) {
        this.gameId = gameId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    
    // Creates a BSON document to be able to send to MongoDB
    public Document toDocument() {
        Document doc = new Document();
        doc.put("c_id", getCommentId());
        doc.put("user", getUserName());
        doc.put("rating", getRating());
        doc.put("c_text", getComment());
        return doc;
    }
    
    @Override
    public String toString() {
        return "Comment[commentId=%s, username=%s, rating=%d, comment=%s]"
        .formatted(commentId, userName, rating, comment);
    }

    public static Comment create(MultiValueMap<String, String> form) {
        Comment comment = new Comment();
        comment.setGameId(Integer.parseInt(form.getFirst("gameId")));
        comment.setUserName("username");
        comment.setRating(Integer.parseInt(form.getFirst("rating")));
        comment.setComment(form.getFirst("comment"));
        return comment;
    }
}
