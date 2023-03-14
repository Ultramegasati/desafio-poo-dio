package br.com.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {

    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();


    public void inscreverBotcamp(Bootcamp bootcamp){
        this.conteudosInscritos.addAll(bootcamp.getConteudos());//pegando set de conteudosInscritos e adicionado todo conteudo do botcamp
        bootcamp.getDevsInscritos().add(this);//adicionando Dev ao bootcamp
    }

    public void progredir(){
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();//pegar o primeiro do conteudosInscritos

        //tirar de conteudosInscritos e colocar em conteudosConcluidos
        if(conteudo.isPresent()) {//se conteudo esta presente
            this.conteudosConcluidos.add(conteudo.get());//colocar em conteudosConcluidos
            this.conteudosInscritos.remove(conteudo.get());    //removendo de conteudosInscritos
        } else {   //caso conteudoInscrtos esteja vazia
            System.err.println("Você não esta matriculado em nenhum conteúdo");

        }
    }

    public double calcularTotalXP(){

        return this.conteudosConcluidos
                .stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();
        //cada conteudo do conteudosConcluidos, xp de cada conteudo e somou

    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscritos, dev.conteudosInscritos) && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }
}
