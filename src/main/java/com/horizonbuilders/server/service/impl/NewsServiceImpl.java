package com.horizonbuilders.server.service.impl;

import com.horizonbuilders.server.dto.request.NewsRequest;
import com.horizonbuilders.server.model.News;
import com.horizonbuilders.server.repository.NewsRepository;
import com.horizonbuilders.server.repository.projections.NewsListView;
import com.horizonbuilders.server.service.CloudinaryService;
import com.horizonbuilders.server.service.NewsService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NewsServiceImpl implements NewsService {
    final NewsRepository newsRepository;
    final CloudinaryService cloudinaryService;

    @Override
    public News createNews(NewsRequest request) {
        News news = News.builder()
                .header(request.header())
                .text(request.text())
                .imgUrl(cloudinaryService.upload(request.img()))
                .build();
        return newsRepository.save(news);
    }

    @Override
    public Page<NewsListView> getAllNews(int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
        return newsRepository.findAllProjectedBy(pageable);
    }
}
