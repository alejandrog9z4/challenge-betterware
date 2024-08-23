package com.test.betterware.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BetterwareServiceImp implements IBetterwareService {

    @Override
    public Map<String, List<String>> agruparAsociados(Map<String, String> asociados) {

        Map<String,List<String>> agrupacionPorDisctribuidora = new HashMap<>();
         for(Map.Entry<String,String> original : asociados.entrySet() )
         {
             String asociado= original.getKey();
             String distribuidora= original.getValue();
             agrupacionPorDisctribuidora.putIfAbsent(distribuidora, new ArrayList<>());
             agrupacionPorDisctribuidora.get(distribuidora).add(asociado);

         }
        return agrupacionPorDisctribuidora;
    }

    @Override
    public int inegi(int[][] informacion) {

        int personasVivas=0,personasVivasActual = 0,anioCalculado = 0;

        Map<Integer, Integer> poblacion = new HashMap<>();

        for(int[] anios : informacion){
           int anioNaciomiento = anios[0];
           int anioMuerte = anios[1];
           poblacion.put(anioNaciomiento, poblacion.getOrDefault(anioNaciomiento,0)+1);
           poblacion.put(anioMuerte+1, poblacion.getOrDefault(anioMuerte+1,0)-1);
        }

        List<Integer> datoAnios = new ArrayList<>(poblacion.keySet());
        Collections.sort(datoAnios);
        for (int anio : datoAnios){
            personasVivasActual += poblacion.get(anio);
            if(personasVivasActual>personasVivas){
                personasVivas= personasVivasActual;
                anioCalculado=anio;
            }
        }
        return anioCalculado;
    }
}
