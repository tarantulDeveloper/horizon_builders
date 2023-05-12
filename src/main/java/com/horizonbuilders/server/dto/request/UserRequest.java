package com.horizonbuilders.server.dto.request;

import com.horizonbuilders.server.model.enums.ERole;
import org.springframework.web.multipart.MultipartFile;

public record UserRequest(
        String username,
        String password
) {
}
