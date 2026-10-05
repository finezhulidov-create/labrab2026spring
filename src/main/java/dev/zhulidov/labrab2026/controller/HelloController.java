package dev.zhulidov.labrab2026.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController("/api")
public class HelloController {

    private List<String> array;
    private Map<Integer,String> map;
    private Integer count = 1;

    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "name", defaultValue = "World")String name){
        return String.format("Hello %s!", name);
    }

    @GetMapping("/update-array")
    public void updateArrayList(String s){
        if (array.isEmpty()){
            array = new ArrayList<>();
        } else {
            array.add(s);
        }
    }

    @GetMapping("/show-array")
    public String showArrayList(){
        return array.toString();
    }

    @GetMapping("/update-map")
    public void updateHashMap(String s){
        if (map.isEmpty()){
            map = new HashMap<>();
        } else {
            map.put(count,s);
            count++;
        }
    }

    @GetMapping("/show-map")
    public String showHashMap(){
        return map.toString();
    }

    @GetMapping("/show-all-length")
    public String showAllLength(){
        int resultArr = array.size();
        int resultMap = map.size();
        return "ArrayList: " + resultArr + " HashMap: "+resultMap;
    }
}
