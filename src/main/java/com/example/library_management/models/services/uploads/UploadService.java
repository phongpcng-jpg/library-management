package com.example.library_management.models.services.uploads;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.library_management.exception.UploadCloudinaryException;
import com.example.library_management.message.UploadCloudinaryMessage;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UploadService {

    private final Cloudinary cloudinary;

    public String upload(MultipartFile file) {
        try {
            String originalFilename = file.getOriginalFilename();

            if(originalFilename != null && originalFilename.contains(".")) {
                originalFilename = originalFilename.substring(
                    0,
                    originalFilename.lastIndexOf(".")
                );
            }

            Map<?, ?> uploadParams = ObjectUtils.asMap(
                "public_id",originalFilename
            );

            Map<?, ?> uploadResult = cloudinary.uploader().upload(
                file.getBytes(),uploadParams
            );

            return uploadResult.get("url").toString();

        } catch (IOException e) {
            throw new UploadCloudinaryException(
                UploadCloudinaryMessage.UPLOAD_CLOUDINARY
            );
        }
    }

}
