package com.iuh.ktln.quysang.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.iuh.ktln.quysang.model.Songs;
import com.iuh.ktln.quysang.repository.SongRepository;

@Service
public class SongService {
		
	@Autowired
    private Cloudinary cloudinary;
    
    @Autowired
    private SongRepository songRepository;
    
    public Songs uploadSong(MultipartFile file, MultipartFile audio ,String name ,Long unitId) throws IOException {
    
        Map<?, ?> cloudinaryResponse = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
        
        Map<?, ?> params = ObjectUtils.asMap("resource_type", "video");
        Map<?, ?> uploadResult = cloudinary.uploader().upload(audio.getBytes(), params);
        
        Songs song = new Songs();
        song.setUnitId(unitId);
        song.setName(name);
        song.setImageUrl(cloudinaryResponse.get("url").toString());
        song.setAudioUrl(uploadResult.get("url").toString());
       
        return songRepository.save(song);
    }
    
    public List<Songs> getAllSong() {
        return songRepository.findAll();
    }

    public Songs getSongById(Long id) {
        return songRepository.findById(id)
                .orElse(null);
    }
    
    public Songs getSongsById(Long unitId) {
        return songRepository.findById(unitId)
                .orElse(null);
    }
    public void deleteSong(Long id) {
    	songRepository.deleteById(id);
    }

}
