package com.horizonbuilders.server.service;

import com.horizonbuilders.server.dto.request.NewsRequest;
import com.horizonbuilders.server.model.News;
import com.horizonbuilders.server.repository.projections.NewsListView;
import org.springframework.data.domain.Page;

public interface NewsService {
    News createNews(NewsRequest request);

    Page<NewsListView> getAllNews(int pageNo, int pageSize, String sortBy);
}
