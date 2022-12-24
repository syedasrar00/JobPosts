package com.jobposts.jobRepo;

import com.jobposts.model.Job;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobsRepo extends MongoRepository<Job,String>
{
}
