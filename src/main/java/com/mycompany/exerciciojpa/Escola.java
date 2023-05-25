package com.mycompany.exerciciojpa;

import javax.persistence.*;
import java.util.List;

@Entity
public class Escola {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String nome;
    
    @OneToMany(mappedBy = "escola", cascade = CascadeType.ALL)
    private List<Turma> turmas;
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }
    
    public List<Turma> getTurmas() {
        return turmas;
    }
}
