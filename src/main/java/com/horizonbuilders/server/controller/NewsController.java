package com.horizonbuilders.server.controller;

import com.horizonbuilders.server.dto.request.NewsRequest;
import com.horizonbuilders.server.model.News;
import com.horizonbuilders.server.repository.projections.NewsListView;
import com.horizonbuilders.server.service.NewsService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public Page<NewsListView> getAllNews(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "3") int pageSize,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        return newsService.getAllNews(pageNo, pageSize, sortBy);
    }

    @GetMapping("/{newsId}")
    public News getNewsById(@PathVariable("newsId") int newsId) {
        return newsService.getNewsById(newsId);
    }
}
