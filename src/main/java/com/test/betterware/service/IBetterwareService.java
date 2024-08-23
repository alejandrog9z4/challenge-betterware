package com.test.betterware.service;

import java.util.List;
import java.util.Map;

public interface IBetterwareService {

    public  Map<String, List<String>> agruparAsociados(Map<String,String> asignados);
    public int inegi (int[][] informacion);

}
