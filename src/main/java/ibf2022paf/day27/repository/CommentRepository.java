package ibf2022paf.day27.repository;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import ibf2022paf.day27.model.Comment;

@Repository
public class CommentRepository {
    
    public static String COLLECTION_COMMENTS="comments";

    @Autowired
    private MongoTemplate template;

    public void insertComment(Comment comment) {
        Document doc = comment.toDocument();
        template.insert(doc, COLLECTION_COMMENTS);
    }

}
