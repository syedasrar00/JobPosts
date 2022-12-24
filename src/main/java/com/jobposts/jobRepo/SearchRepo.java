package com.jobposts.jobRepo;

import com.jobposts.model.Job;
import java.util.List;

public interface SearchRepo {
    List<Job> findByText(String value);
}
