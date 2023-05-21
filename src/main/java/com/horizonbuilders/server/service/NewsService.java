package com.horizonbuilders.server.service;

import com.horizonbuilders.server.dto.request.NewsRequest;
import com.horizonbuilders.server.model.News;

public interface NewsService {
    News createNews(NewsRequest request);
}
