/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Comparator;

/**
 *
 * @author rwsouza
 */
public class OrdenacaoNotaDecrescente implements Comparator<Aluno> {
      @Override
    public int compare(Aluno o1, Aluno o2) {
        int ordem;
        if (o1.getNotaEnem() < o2.getNotaEnem()) {
            ordem = +1;
        } else if (o1.getNotaEnem() > o2.getNotaEnem()) {
            ordem = -1;
        } else {
            ordem = 0;
        }
        
        return ordem;
    }
}
