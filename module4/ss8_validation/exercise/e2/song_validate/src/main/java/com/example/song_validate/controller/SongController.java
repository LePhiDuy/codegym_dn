package com.example.song_validate.controller;

import com.example.song_validate.Dto.SongDto;
import com.example.song_validate.model.Song;
import com.example.song_validate.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("song")
public class SongController {
    @Autowired
    ISongService songService;
    @GetMapping("")
    public String home(Model model) {
        model.addAttribute("songs", songService.findAll());
        return "list";
    }
    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("songDto", new SongDto());
        return "create";
    }
    @PostMapping("save")
    public String save(@Validated SongDto songDto, BindingResult bindingResult) {
        new SongDto().validate(songDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        songService.save(song);
        return "redirect:/song";
    }
    @GetMapping("{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        Song song = songService.findById(id).get();
        SongDto songDto = new SongDto();
        BeanUtils.copyProperties(song, songDto);
        model.addAttribute("songDto", songDto);
        return "edit";
    }
    @PostMapping("update")
    public String update(@Validated SongDto songDto, BindingResult bindingResult) {
        new SongDto().validate(songDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        songService.save(song);
        return "redirect:/song";
    }
}
