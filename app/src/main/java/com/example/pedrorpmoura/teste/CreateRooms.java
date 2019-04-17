package com.example.pedrorpmoura.teste;

import java.util.ArrayList;
import java.util.List;

public class CreateRooms {

    private List<MRoom> rooms = new ArrayList<>();

    public CreateRooms() {
        rooms.add(new MRoom(1,"Sala de Entrada",
                "A Sala de Entrada " +
                "corresponde ao compartimento onde os visitantes aguardavam enquanto não " +
                "eram encaminhados, por pagens, até que os proprietários da casa, de acordo " +
                "com as fórmulas de etiqueta da época.\n" +
                " Neste espaço, encontra-se um teto neoclássico rematado por lanternim " +
                "decorado a estuque. O palácio integra uma sequência de estuques artísticos " +
                "de expressão neoclássica frequentemente observadas nos interiores abastados " +
                "a partir do século XVII.\n\n",
                new int[] {}, R.raw.sound_sample));
        rooms.add(new MRoom(2,"Salão Nobre",
                "O Salão Nobre do Palácio reúne os componentes que caracterizam" +
                        " o Barroco: a azulejaria, a talha e a pintura, constituindo um " +
                        "notável exemplar de interior civil do século XVIII. O espaço com " +
                        "toda a sua estética de pompa, esplendor e festa destinava-se às " +
                        "ocasiões de maior cerimónia.\n\n",
                new int[] {}, R.raw.sound_sample));
        rooms.add(new MRoom(3,"Oratório",
                "A partir do século XVII, a Capela passou a fazer parte " +
                        "integrante da Casa Senhorial Portuguesa. Deste modo, este " +
                        "é um espaço íntimo reservado à devoção. Este compartimento " +
                        "está associado ao período de intensa religiosidade vivido " +
                        "na é época, bem como aos hábitos de circunscrição da mulher " +
                        "à interioridade doméstica.\n\n",
                new int[] {R.drawable.oratorio1,
                        R.drawable.oratorio2,
                        R.drawable.oratorio3,
                        R.drawable.oratorio4}, R.raw.sound_sample));
        rooms.add(new MRoom(4,"Sala do Estrado",
                "A Sala do Estrado representa um hábito que se instalou em " +
                        "Portugal, desde a Idade Média e que perdurou até ao começo do " +
                        "século XIX. Esta tradição consistia no costume de a Senhora bem " +
                        "como todo o grupo feminino, filhas, familiares, criadas e escravas," +
                        " passarem o dia sentadas de pernas cruzadas no chão ou em estrados," +
                        " a fiar, a bordar e a conversar.\n\n",
                new int[] {}, R.raw.sound_sample));
        rooms.add(new MRoom(5,"Salão de Música e do Jogo",
                "O Salão de Música e de Jogo destinava-se a reuniões da nobreza " +
                        "durante as quais a música (cantada e/ou tocada) e o jogo eram " +
                        "frequentes.\n\n",
                new int[] {}, R.raw.sound_sample));
        rooms.add(new MRoom(6,"Gabinete", "Inserir descrição",
                new int[] {}, R.raw.sound_sample));
        rooms.add(new MRoom(7,"Sala de Jantar", "Inserir descrição",
                new int[] {}, R.raw.sound_sample));
        rooms.add(new MRoom(8,"Cavalariças", "Inserir descrição",
                new int[] {}, R.raw.sound_sample));
        rooms.add(new MRoom(9,"Cozinha", "Inserir descrição",
                new int[] {}, R.raw.sound_sample));
        rooms.add(new MRoom(10,"Jardins", "Inserir descrição",
                new int[] {}, R.raw.sound_sample));
    }


    public List<MRoom> getRooms() {
        return this.rooms;
    }
}
