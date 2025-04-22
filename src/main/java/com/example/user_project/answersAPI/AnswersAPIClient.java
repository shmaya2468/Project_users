package com.example.user_project.answersAPI;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "${externalApi.answers.name}", url = "${externalApi.answers.url}")
public interface AnswersAPIClient {


    @DeleteMapping("/poll-answers/users/{userId}")
    void deleteUserWithHisAnswersByUserId(@PathVariable int userId);
}
