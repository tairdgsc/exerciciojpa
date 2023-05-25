/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exerciciojpa;

/**
 *
 * @author Taila
 */
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("escolajpa");
        EntityManager em = emf.createEntityManager();

        try {

            // Criar uma escola
            Escola escola = new Escola();
            escola.setNome("Escola1");

            // Criar turmas
            Turma turmaNoite01 = new Turma();
            turmaNoite01.setNome("Noite01");
            turmaNoite01.setEscola(escola);

            Turma turmaManha01 = new Turma();
            turmaManha01.setNome("Manha01");
            turmaManha01.setEscola(escola);

            // Criar alunos
            Aluno aluno1 = new Aluno();
            aluno1.setNome("Aluno1");
            aluno1.setTelefone("1111111111");
            aluno1.setTurma(turmaNoite01);

            Aluno aluno2 = new Aluno();
            aluno2.setNome("Aluno2");
            aluno2.setTelefone("2222222222");
            aluno2.setTurma(turmaNoite01);

            Aluno aluno3 = new Aluno();
            aluno3.setNome("Aluno3");
            aluno3.setTelefone("3333333333");
            aluno3.setTurma(turmaManha01);

            // Adicionar alunos às turmas
            List<Aluno> alunosNoite01 = new ArrayList<>();
            alunosNoite01.add(aluno1);
            alunosNoite01.add(aluno2);

            turmaNoite01.setAlunos(alunosNoite01);

            List<Aluno> alunosManha01 = new ArrayList<>();
            alunosManha01.add(aluno3);

            turmaManha01.setAlunos(alunosManha01);

            // Adicionar turmas à escola
            List<Turma> turmas = new ArrayList<>();
            turmas.add(turmaNoite01);
            turmas.add(turmaManha01);

            escola.setTurmas(turmas);
            em.getTransaction().begin();

            // Persistir no banco de dados
            em.persist(escola);

            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
