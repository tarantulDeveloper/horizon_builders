package com.horizonbuilders.server.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.horizonbuilders.server.service.CloudinaryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CloudinaryServiceImpl implements CloudinaryService {

    final Cloudinary cloudinary;

    @Override
    public String upload(MultipartFile multipartFile) throws IOException {
        return String.valueOf(
                cloudinary.uploader()
                        .upload(multipartFile.getBytes(), ObjectUtils.asMap(
                                "quality", 50
                        ))
                        .get("secure_url")
        );
    }
}
