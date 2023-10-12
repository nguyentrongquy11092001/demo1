package com.iuh.ktln.quysang.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.iuh.ktln.quysang.model.Stories;
import com.iuh.ktln.quysang.repository.StoriesRepository;

@Service
public class StoriesService {
	@Autowired
    private Cloudinary cloudinary;
    
    @Autowired
    private StoriesRepository storiesRepository;
    
    public Stories uploadStories(MultipartFile file, MultipartFile video ,String name, Long unitId) throws IOException {
	    
        Map<?, ?> cloudinaryResponse = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
        
        Map<?, ?> params = ObjectUtils.asMap("resource_type", "video");
        Map<?, ?> uploadResult = cloudinary.uploader().upload(video	.getBytes(), params);
        
        Stories stories = new Stories();
        stories.setUnitId(unitId);
        stories.setStoryName(name);
        stories.setImageUrl(cloudinaryResponse.get("url").toString());
        stories.setVideoUrl(uploadResult.get("url").toString());
       
        return storiesRepository.save(stories);
    }
    
    public Stories getStoriesById(Long unitId) {
        return storiesRepository.findById(unitId)
                .orElse(null);
    }
}
