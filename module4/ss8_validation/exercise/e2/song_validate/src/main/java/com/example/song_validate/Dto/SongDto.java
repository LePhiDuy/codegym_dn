package com.example.song_validate.Dto;

import lombok.Data;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SongDto implements Validator {
    private Long id;
    @Size(max = 10)
    @Pattern(regexp = "^[a-zA-Z0-9]*$")
    private String name;
    @Size(max = 5)
    @Pattern(regexp = "^[a-zA-Z0-9]*$")
    private String singer;
    @Size(max = 10)
    @Pattern(regexp = "^[a-zA-Z0-9,]*$")
    private String type;
    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDto songDto = (SongDto) target;
        String name = songDto.name;
        String singer = songDto.singer;
        String type = songDto.type;
        ValidationUtils.rejectIfEmpty(errors, "name", "song.name.empty");
        ValidationUtils.rejectIfEmpty(errors, "singer", "song.singer.empty");
        ValidationUtils.rejectIfEmpty(errors, "type", "song.type.empty");
    }

    @Override
    public String toString() {
        return "SongDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", singer='" + singer + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
