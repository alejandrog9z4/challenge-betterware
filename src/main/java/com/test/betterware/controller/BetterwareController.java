package com.test.betterware.controller;

import com.test.betterware.service.IBetterwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/betteware")
public class BetterwareController {

    @Autowired
    private IBetterwareService bettewareService;


    @PostMapping(path = "/agrupar/asociados", consumes = "application/json",produces ="application/json")
    public Map<String, List<String>> agrupraAsociados(@RequestBody Map<String,String> asociados){
        Map<String,List<String>> response = new HashMap<>();
        response = bettewareService.agruparAsociados(asociados);
        return response;
    }

    @PostMapping(path = "/inegi",consumes = "application/json",produces ="application/json")
    public int[] inegi(@RequestBody int[][] intervalos){
       int [] anio = new int[1];
       anio[0]= bettewareService.inegi(intervalos);
       return anio;
    }

}
