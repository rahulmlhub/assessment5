package com.ass.config;

import com.ass.payload.Author;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Author-Service")
public interface AuthorProxy {

    @LoadBalanced
    @GetMapping("/api-author/{authorId}")
    Author getAuthorById(@PathVariable Long authorId);
}
