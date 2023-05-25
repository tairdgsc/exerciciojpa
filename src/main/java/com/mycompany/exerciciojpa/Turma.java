package com.mycompany.exerciciojpa;

import javax.persistence.*;
import java.util.List;

@Entity
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String nome;
    
    @OneToMany(mappedBy = "turma", cascade = CascadeType.ALL)
    private List<Aluno> alunos;
    
    @ManyToOne
    @JoinColumn(name = "escola_id")
    private Escola escola;
    
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
    
    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
    
    public List<Aluno> getAlunos() {
        return alunos;
    }
    
    public void setEscola(Escola escola) {
        this.escola = escola;
    }
    
    public Escola getEscola() {
        return escola;
    }
}
