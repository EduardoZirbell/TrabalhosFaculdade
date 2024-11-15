/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Comparator;
import java.util.Map.Entry;

/**
 *
 * @author rwsouza
 */
public class OrdenacaoPorFrequenciaDecrescente implements Comparator<Entry<String, Integer>>{

    @Override
    public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
        if (o1.getValue() < o2.getValue()){
           return +1; 
        }else if (o1.getValue() > o2.getValue()){
            return -1;
        }
        
        return o1.getKey().compareTo(o2.getKey());
        
    }

    
}
