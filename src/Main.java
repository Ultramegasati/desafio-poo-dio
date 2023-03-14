import br.com.desafio.dominio.Bootcamp;
import br.com.desafio.dominio.Curso;
import br.com.desafio.dominio.Dev;
import br.com.desafio.dominio.Mentoria;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

       Curso curso1 = new Curso();
       curso1.setTitulo("Curso Java");
       curso1.setDescricao("Descrição do curso Java");
       curso1.setCargaHoraria(10);


        Curso curso2 = new Curso();
        curso2.setTitulo("Curso Java Script");
        curso2.setDescricao("Descrição do curso Java Script");
        curso2.setCargaHoraria(7);


        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria de Java");
        mentoria.setDescricao("Descriçao mentoria Java");
        mentoria.setData(LocalDate.now());


        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição o Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev devMaria = new Dev();
        devMaria.setNome("Maria");
        devMaria.inscreverBotcamp(bootcamp);
        System.out.println("Conteúdos Inscritos Maria " + devMaria.getConteudosInscritos());
        devMaria.progredir();
        System.out.println("-");
        System.out.println("Conteúdos Inscritos Maria " + devMaria.getConteudosInscritos());
        System.out.println("Conteúdos Concluído Maria " + devMaria.getConteudosConcluidos());
        System.out.println("XP : " + devMaria.calcularTotalXP());

        System.out.println("-----------------");


        Dev devJoao = new Dev();
        devJoao.setNome("João");
        devJoao.inscreverBotcamp(bootcamp);
        System.out.println("Conteúdos Inscritos João " + devJoao.getConteudosInscritos());
        devJoao.progredir();
        devJoao.progredir();
        devJoao.progredir();
        System.out.println("-");
        System.out.println("Conteúdos Inscritos João " + devJoao.getConteudosInscritos());
        System.out.println("Conteúdos Concluído João " + devJoao.getConteudosConcluidos());
        System.out.println("XP : " + devJoao.calcularTotalXP());

        System.out.println(curso1);
        System.out.println(curso2);
        System.out.println(mentoria);



    }
}