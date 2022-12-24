package com.jobposts.controller;

import com.jobposts.jobRepo.JobsRepo;
import com.jobposts.jobRepo.SearchRepoImpl;
import com.jobposts.model.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApplicationController {
    @Autowired
    private JobsRepo repo;
    @Autowired
    private SearchRepoImpl searchRepo;

    @GetMapping(path="/jobs/{value}")
    public List<Job> searchJobs(@PathVariable("value")String val){
        return searchRepo.findByText(val);
    }

    @GetMapping(path="/jobs")
    public List<Job> getJobs(){
        return repo.findAll();
    }

    @PostMapping(path="/job")
    public Job postJob(@RequestBody Job job){
        return repo.save(job);
    }

    @PutMapping(path="/job")
    public Job updateOrSave(@RequestBody Job job){
        return repo.save(job);
    }
    @DeleteMapping(path="/job")
    public String delete(@RequestBody Job job){
        repo.delete(job);
        return "Success";
    }
}
