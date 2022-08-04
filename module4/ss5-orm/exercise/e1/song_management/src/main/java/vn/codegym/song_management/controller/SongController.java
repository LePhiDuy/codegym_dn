package vn.codegym.song_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.codegym.song_management.model.Song;
import vn.codegym.song_management.service.ISongService;

import java.util.List;

@Controller
@RequestMapping({"song", ""})
public class SongController {
    @Autowired
    ISongService songService;
    @GetMapping("")
    public String list(Model model) {
        model.addAttribute("songs", songService.findAll());
        return "list";
    }
    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("song", new Song());
        return "create";
    }
    @PostMapping("save")
    public String save(Song song) {
        songService.save(song);
        return "redirect:/song";
    }
    @GetMapping("{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("song", songService.findById(id));
        return "edit";
    }
    @PostMapping("update")
    public String update(Song song) {
        songService.update(song);
        List<Song> abc = songService.findAll();
        return "redirect:/song";
    }
    @GetMapping("{id}/delete")
    public String delete(@PathVariable int id) {
        songService.delete(id);
        return "redirect:/song";
    }
}
