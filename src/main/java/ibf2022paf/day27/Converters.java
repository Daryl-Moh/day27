package ibf2022paf.day27;

import org.springframework.util.MultiValueMap;

import ibf2022paf.day27.model.Comment;

public class Converters {

    public static Comment create(MultiValueMap<String, String> form) {

        Comment comment = new Comment();
        comment.setGameId(
            Integer.parseInt(form.getFirst("gameId"))
        );
        comment.setUserName(form.getFirst("username"));
        comment.setRating(
            Integer.parseInt(form.getFirst("rating"))
        );
        comment.setComment(form.getFirst("comment"));

        return comment;
    }

    
}
