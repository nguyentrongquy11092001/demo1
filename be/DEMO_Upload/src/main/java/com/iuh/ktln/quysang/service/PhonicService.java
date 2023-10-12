package com.iuh.ktln.quysang.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.iuh.ktln.quysang.model.Phonics;
import com.iuh.ktln.quysang.model.Stories;
import com.iuh.ktln.quysang.repository.PhonicRepository;

@Service
public class PhonicService {
	@Autowired
    private Cloudinary cloudinary;
    
    @Autowired
    private PhonicRepository phonicsRepository;
    
    public Phonics uploadPhonics(MultipartFile file, MultipartFile audio ,String name, Long unitId, String mean) throws IOException {
    
        Map<?, ?> cloudinaryResponse = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
        
        Map<?, ?> params = ObjectUtils.asMap("resource_type", "video");
        Map<?, ?> uploadResult = cloudinary.uploader().upload(audio	.getBytes(), params);
        
        Phonics phonics = new Phonics();
        phonics.setUnitId(unitId);
        phonics.setName(name);
        phonics.setImageUrl(cloudinaryResponse.get("url").toString());
        phonics.setAudioUrl(uploadResult.get("url").toString());
        phonics.setMean(mean);
        return phonicsRepository.save(phonics);
    }
    
    public List<Phonics> getAllPhonics() {
        return phonicsRepository.findAll();
    }

    public Phonics getPhonicById(Long id) {
        return phonicsRepository.findById(id)
                .orElse(null);
    }
    public void deletePhonics(Long id) {
    	phonicsRepository.deleteById(id);
    }
    
    public Phonics getPhonicsById(Long unitId) {
        return phonicsRepository.findById(unitId)
                .orElse(null);
    }
}
