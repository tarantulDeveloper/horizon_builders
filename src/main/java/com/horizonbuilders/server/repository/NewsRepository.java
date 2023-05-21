package com.horizonbuilders.server.repository;

import com.horizonbuilders.server.model.News;
import com.horizonbuilders.server.repository.projections.NewsListView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<News, Integer> {
    Page<NewsListView> findAllProjectedBy(Pageable pageable);
}
