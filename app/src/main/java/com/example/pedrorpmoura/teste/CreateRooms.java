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
        rooms.add(new MRoom(6,"Gabinete",
                "Nos séculos XVII e XVIII, ainda proliferavam os “Gabinetes de " +
                        "Curiosidades”.\n" +
                        "Com origem no renascimento, período de expansão intercontinental " +
                        "que disseminara na europa à procura de espécimes de toda a ordem, " +
                        "belos e raros.\n" +
                        "A Casa Senhorial dispunha habitualmente uma Biblioteca, também " +
                        "reconhecida de Livraria, em que se incluía o Cartório, que " +
                        "consistia no conjunto de documentos respeitantes ao património " +
                        "e respetiva administração e assuntos diversos relacionados com " +
                        "a família. Espaço de características Neoclássicas, pois apresenta " +
                        "um teto ornamental de estuques relevados pintura central e um " +
                        "revestimento parietal azulejar.\n\n",
                new int[] {}, R.raw.sound_sample));
        rooms.add(new MRoom(7,"Sala de Jantar",
                "A Sala de Jantar como espaço fixo para tomar as refeições " +
                        "surgiu em Portugal a partir do terceiro quartel do século XVIII. " +
                        "Até então as refeições eram servidas em diferentes espaços da " +
                        "casa de acordo com a disposição dos donos. Os lacaios deslocavam " +
                        "as mesas que cobriam com os têxteis, usando serviços de estanho " +
                        "e de prata, e de cerâmica (europeia e chinesa).\n" +
                        "A sala é revestida com painéis de azulejo e pinturas neoclássicas " +
                        "ao gosto dos finais do século XVIII.\n" +
                        "Nos banquetes, apresentação dos pratos era especialmente elaborada" +
                        " e os alimentos em abundância. Todas as refeições eram geralmente " +
                        "servidas por lacaios ou escravos, em grande número nestas casas, " +
                        "habitualmente trajando ricas librés (fardas).\n\n",
                new int[] {}, R.raw.sound_sample));
        rooms.add(new MRoom(8,"Cavalariças",
                "Em Portugal a equitação foi tradicionalmente apreciada ao nível " +
                        "da nobreza. É conhecido também o gosto dos monarcas portugueses pela " +
                        "arte de cavalgar. Quando em 1761, o Colégio Real dos Nobres foi " +
                        "instituído pelo Marquês de Pombal, primeiro ministro do Rei D. José I, " +
                        "aquela prática, juntamente com a esgrima compunham o módulo desportivo " +
                        "do estabelecimento. \n" +
                        "Nas casas senhoriais existiam cavalos, mulas, burros ou mesmo bois para " +
                        "transporte. A cavalariça é uma adaptação realizada no século XIX, " +
                        "substituindo a que se situava no átrio do palácio.\n" +
                        "O meio de transporte presente é um carro de cavalos britânico do século " +
                        "XIX.\n\n",
                new int[] {}, R.raw.sound_sample));
        rooms.add(new MRoom(9,"Cozinha",
                "Na época setecentista, este terá sido um espaço vivo com numerosa " +
                        "criadagem, distribuída em diferentes funções.\n" +
                        "Os produtos então utilizados na alimentação eram carne, com grande " +
                        "presença de caça, o peixe- este com especial incidência nos períodos " +
                        "de jejum religioso- os ovos, o pão, o leite, os legumes, o açúcar, " +
                        "a farinha e a fruta.\n" +
                        "Muitos dos doces que integram a atual gastronomia português (XXI), " +
                        "forma inventados nas cozinhas dos mosteiros e conventos barrocos dos" +
                        " quais se referem, a título de exemplo, papos de anjo, beijos e " +
                        "barrigas de freira, toucinho-do-céu e manjar celeste.\n\n",
                new int[] {}, R.raw.sound_sample));
        rooms.add(new MRoom(10,"Jardins",
                "Os jardins barrocos do Museu dos Biscainhos são um dos mais " +
                        "importantes de Portugal. Estão organizados em três patamares: o " +
                        "Terreiro e o Jardim Formal; o Pomar e a Horta, sendo rematados, " +
                        "no limite Oeste, por muralhas sugerindo um baluarte seiscentista. " +
                        "Ao longo do jardim encontram-se fontes e esculturas em granito do " +
                        "período do barroco e rococó.\n" +
                        "O Terreiro foi um espaço de intenso movimento de lacaios, cavalos " +
                        "e de carruagens, um chafariz com taça de formato oval.\n" +
                        "O Jardim Formal apresenta um labirinto geométrico, duas casas de " +
                        "fresco formadas por japoneiras e um pavilhão de jardim.\n" +
                        "O Pomar tem uma árvore secular com cerca de duzentos e cinquenta " +
                        "anos, um Tulipeiro da Virgínia. Na época, era considerada como uma " +
                        "planta exótica apreciada pela nobreza. Na Horta cultivavam-se " +
                        "legumes e plantas medicinais.\n\n",
                new int[] {}, R.raw.sound_sample));
    }


    public List<MRoom> getRooms() {
        return this.rooms;
    }
}
