package service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

public class DictionaryService {
    static Map<String, String> dictionary = new HashMap<>();
    static {
        dictionary.put("hello", "xin chao");
        dictionary.put("dog", "con cho");
        dictionary.put("people", "con nano");
    }
    public String search(String english) {
        return dictionary.get(english);
    }

}
