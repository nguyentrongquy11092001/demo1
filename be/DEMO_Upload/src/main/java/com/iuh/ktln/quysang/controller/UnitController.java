package com.iuh.ktln.quysang.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.iuh.ktln.quysang.model.Phonics;
import com.iuh.ktln.quysang.model.Songs;
import com.iuh.ktln.quysang.model.Stories;
import com.iuh.ktln.quysang.model.UnitModel;
import com.iuh.ktln.quysang.repository.PhonicRepository;
import com.iuh.ktln.quysang.repository.SongRepository;
import com.iuh.ktln.quysang.repository.StoriesRepository;
import com.iuh.ktln.quysang.repository.UnitRepository;
import com.iuh.ktln.quysang.service.PhonicService;
import com.iuh.ktln.quysang.service.SongService;
import com.iuh.ktln.quysang.service.StoriesService;
import com.iuh.ktln.quysang.service.UnitService;

@RestController

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/units")
public class UnitController {

    @Autowired
    private UnitRepository unitRepository;
    
    @Autowired
    private UnitService unitService;
    
    @Autowired
    private StoriesRepository storiesRepository;
    
    @Autowired
    private StoriesService storiesService;
    
    @Autowired
    private SongRepository songRepository;
    
    @Autowired
    private SongService songService;
    
    @Autowired
    private PhonicService phonicService;
    
    @Autowired
    private PhonicRepository phonicRepository;

    @PostMapping("/createUnit")
    public ResponseEntity<?> createUnit(@RequestBody UnitModel unit) {
		return new ResponseEntity<>(unitService.createUnit(unit), HttpStatus.CREATED);
	}
    @GetMapping("/getUnitByLevelId/{levelId}")
    public List<UnitModel> getUnitsByLevelId(@PathVariable Long levelId) {
        return unitRepository.findUnitsByLevelId(levelId);
    }
    
    @GetMapping("/getUnitByUnitId/{unitId}")
    public Optional<UnitModel> getUnitByUnitId(@PathVariable Long unitId) {
        return unitRepository.findById(unitId);
    }
    
    //Stories
    @PostMapping("stories/uploadStories")
    public ResponseEntity<Stories> uploadStories(@RequestParam("file") MultipartFile file, 
    		@RequestParam("video") MultipartFile video,
    		@RequestParam("storyName") String storyName,
    		@RequestParam("unitId") Long unitId) {
        try {
            Stories uploadedImage = storiesService.uploadStories(file, video, storyName, unitId);
            return new ResponseEntity<>(uploadedImage, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/getStoriesByUnitId/{unitId}")
    public List<Stories> getStoriesByUnitId(@PathVariable Long unitId) {
        return storiesRepository.findStoriesByUnitId(unitId);
    }
    
    //Songs
    @PostMapping("/songs/uploadSong")
    public ResponseEntity<Songs> uploadSong(@RequestParam("file") MultipartFile file, @RequestParam("audio") MultipartFile audio, 
    		@RequestParam("name") String name ,@RequestParam("unitId") Long unitId) {
        try {
            Songs uploadSong = songService.uploadSong(file, audio, name,unitId);
            return new ResponseEntity<>(uploadSong, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/getSongsByUnitId/{unitId}")
    public List<Songs> getSongsByUnitId(@PathVariable Long unitId) {
        return songRepository.findSongsByUnitId(unitId);
    }
    
  
    //Phonics
    @PostMapping("/phonics/uploadPhonics")
    public ResponseEntity<Phonics> uploadPhonics(@RequestParam("file") MultipartFile file, 
    	@RequestParam("audio") MultipartFile audio, @RequestParam("name") String name, 
    	@RequestParam("unitId") Long unitId, @RequestParam("mean") String mean) {
        try {
            Phonics uploadPhonics = phonicService.uploadPhonics(file, audio, name, unitId, mean);
            return new ResponseEntity<>(uploadPhonics, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/getPhonicsByUnitId/{unitId}")
    public List<Phonics> getPhonicsByUnitId(@PathVariable Long unitId) {
        return phonicRepository.findPhonicsByUnitId(unitId);
    }
    
    @GetMapping("/findUnitId")
    public Long findUnitIdByUnitName(@RequestParam("unitName") String unitName) throws Exception {
        Long unitId = unitRepository.findUnitIdByUnitName(unitName);
        if (unitId != null) {
            return unitId;
        } else {
            throw new Exception("Unit not found for unitName: " + unitName);
        }
    }
    // Các phương thức khác cho việc lấy thông tin đơn vị, cập nhật, xóa, v.v.
}