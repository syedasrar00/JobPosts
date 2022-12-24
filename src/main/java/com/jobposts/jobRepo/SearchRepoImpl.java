package com.jobposts.jobRepo;

import com.jobposts.model.Job;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Component
public class SearchRepoImpl implements SearchRepo{
    @Autowired
    MongoClient mongoClient;
    @Autowired
    MongoConverter converter;
    @Override
    public List<Job> findByText(String value) {
        List<Job> list = new ArrayList<>();
        MongoDatabase database = mongoClient.getDatabase("JobPost");
        MongoCollection<Document> collection = database.getCollection("postList");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                new Document("text",
                new Document("query", value)
                .append("path", Arrays.asList("skills", "location", "profile")))),
                new Document("$sort",
                new Document("exp", 1L)),
                new Document("$limit", 5L)));
        result.forEach(doc->list.add(converter.read(Job.class,doc)));
        return list;
    }
}
