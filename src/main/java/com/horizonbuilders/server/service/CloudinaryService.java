package com.horizonbuilders.server.service;

import org.springframework.web.multipart.MultipartFile;

public interface CloudinaryService {
    String upload(MultipartFile multipartFile);
}
