package com.horizonbuilders.server.controller;

import com.horizonbuilders.server.dto.request.NewsRequest;
import com.horizonbuilders.server.model.News;
import com.horizonbuilders.server.service.NewsService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/api/news")
public class NewsController {
    final NewsService newsService;

    @PostMapping
    public News createNews(@ModelAttribute NewsRequest request) {
        return newsService.createNews(request);
    }
}
