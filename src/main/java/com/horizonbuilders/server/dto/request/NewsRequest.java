package com.horizonbuilders.server.dto.request;

import org.springframework.web.multipart.MultipartFile;

public record NewsRequest(
        String header,
        String text,
        MultipartFile img
) {
}
