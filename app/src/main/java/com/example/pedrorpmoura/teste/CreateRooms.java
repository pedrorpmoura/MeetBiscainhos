package com.example.pedrorpmoura.teste;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;

public class CreateRooms {

    private List<MRoom> rooms = new ArrayList<>();

    public CreateRooms() {

        // create objects
        final MObject obj_entrada1 = new MObject(
                "Cadeirinha",
                "século XVIII d.C.",
                "Madeira entalhada e dourada; " +
                        "couro pintado em policromia; " +
                        "tecido de damasco vermelho",
                "altura de 141 cm; " +
                        "largura de 72 cm e " +
                        "profundidade de 245 cm.",
                "Cadeirinha com a base rematada por " +
                        "duas travessas decorativas e duas colunas " +
                        "em espiral, com uma estrutura em madeira " +
                        "pintada a vermelho na parte inferior e a " +
                        "verde na parte superior, moldurada a dourado, " +
                        "com um friso de folhagem rematando a parte " +
                        "superior; varais inseridos na própria estrutura " +
                        "de madeira; cobertura arredondada, revestida a " +
                        "couro em preto firmado por pregaria; duas " +
                        "janelas laterais envidraçadas e outra ao nível " +
                        "superior da porta colocada na face anterior. " +
                        "Interior com revestimento a couro vermelho nos " +
                        "laterais, porta, chão, fundo e almofada do " +
                        "assento, sendo o restante revestido a algodão" +
                        " riscado a castanho e creme e ornado com galão.",
                R.drawable.obj_entrada_cadeirinha
        );

        final MObject obj_salao_nobre_teto = new MObject(
                "Teto",
                "século XIX d.C.",
                "Madeira, Óleo e Talha Dourada",
                "________",
                "O teto abobadado em madeira de castanho " +
                        "é revestido por uma pintura ornamental a óleo. " +
                        "Trata-se de um teto comemorativo e de homenagem " +
                        "a um antepassado da família que habitou a casa, " +
                        "o Beato Miguel de Carvalho, jesuíta martirizado " +
                        "no Japão, queimado numa fogueira. Acima da " +
                        "cornija, uma composição continuada pela periferia " +
                        "da abóbada, sobressaem oito damas, trajadas à " +
                        "época. Todas elas estão inseridas em  jardins, " +
                        "onde permanecem estátuas, seres mitológicos, " +
                        "festões, guirlandas floridas, cartelas, entre " +
                        "outros. Ao centro encontramos a representação " +
                        "do Beato preso a um poste, tendo junto de si " +
                        "homens e labaredas de fogo. ",
                R.drawable.obj_salao_nobre_teto
        );

        final MObject obj_salao_nobre_azulejos = new MObject(
                "Painel de Azulejo",
                "século XIX d.C.",
                "Painéis de Azulejo Azul e Branco",
                "________",
                "O painel de azulejo é constituído por pinturas" +
                        " de momentos galantes em jardins e paisagens, " +
                        "cenas de montaria e de caça, referenciadores da " +
                        "ocupação da nobreza da época. \n" +
                        "O uso do azul e branco refletiu o fascínio exercido " +
                        "no gosto lusitano pelas delicadas porcelanas " +
                        "chinesas exportadas para a Europa. \n" +
                        "A atração por paredes amplamente ornamentadas " +
                        "também é um elemento de destaque, influenciado " +
                        "pela proximidade com a cultura árabe peninsular.",
                R.drawable.obj_salao_nobre_azulejos
        );

        final MObject obj_cozinha_roda = new MObject(
                "Roda de Fumeiro",
                "século XX d.C.",
                "Madeira e Ferro",
                "Diâmetro de 139 centímetros",
                "A roda de fumeiro é constituída por uma " +
                        "estrutura circular e por traves que se cruzam " +
                        "na zona interior. A toda a volta tem 42 ganchos" +
                        " pregados para suspensão de carnes.",
                R.drawable.obj_cozinha_roda
        );

        final MObject obj_cozinha_escano = new MObject(
                "Escano",
                "século XX d.C.",
                "Madeira",
                "altura de 169 cm;" +
                        " largura de 65,5 cm; " +
                        "comprimento de 212 cm.",
                "O escano é um banco de madeira, constituído " +
                        "por quatro pernas lisas retangulares. Os braços " +
                        "são formados por tábuas lisas, rematadas pelo " +
                        "prolongamento das pernas. Em cima, tem um tampo " +
                        "fixado ao centro por uma haste vertical que serve " +
                        "de mesa quando colocado na frente. ",
                R.drawable.obj_cozinha_escano
        );

        final MObject obj_cozinha_almofariz = new MObject(
                "Almofariz",
                "________",
                "Bronze",
                "altura de 11,5 cm",
                "O almofariz em bronze é um objeto cilíndrico, " +
                        "ornado com quatro pares de filetes incisos. Tem uma " +
                        "base e aba superior alargadas e emolduradas. O pilão " +
                        "afunila para o punho e alarga no topo achatado. Tem um " +
                        "anel na zona média do corpo e no punho. São ainda " +
                        "visíveis pares de filetes incisos no corpo. ",
                R.drawable.obj_cozinha_almofariz
        );

        final MObject obj_cavalarica_arreios = new MObject(
                "Arreios",
                "________",
                "________",
                "________",
                "O conjunto de arreios para cavalos é " +
                        "constituído por couro e alguns elementos " +
                        "metálicos. Tem ainda uma peça semelhante a " +
                        "um colar grosso de couro para colocar no " +
                        "pescoço do animal.",
                R.drawable.obj_cavalarica_arreios
        );

        final MObject obj_cavalarica_coche = new MObject(
                "Coche",
                "século XIX d.C.",
                "Ferro, Madeira e Borracha",
                "altura de 163 cm; " +
                        "largura de 161 cm e " +
                        "comprimento de 234 cm",
                "O carro de tração de dois cavalos segundo " +
                        "modelo de passeio, tem uma caixa de madeira " +
                        "e de suspensão e um rodado de ferro pintado " +
                        "a vermelho. Os seus interiores são forrados " +
                        "a couro verde e bancos estofados a feltro azul." +
                        " Sob os bancos existe espaço para " +
                        "acondicionamento de bagagem. O banco de cocheiro " +
                        "elevado e existem quatro lugares \"vis-a-vis\"," +
                        " com acesso por estribos suspensos no exterior " +
                        "e por uma pequena porta traseira. As rodas são " +
                        "revestidas a borracha, tendo no eixo a marca \"" +
                        "LABOURDETTE PARIS\". Tem guarda-lamas e travão " +
                        "de manivela e duas lanternas de folha. ",
                R.drawable.obj_cavalarica_coche
        );

        final MObject obj_sala_musica_piano = new MObject(
                "Piano",
                "________",
                "________",
                "Altura de 84,cm, " +
                        "profundidade 55cm e " +
                        "comprimento de 153,7cm",
                "O piano está apoiado em seis pernas aneladas " +
                        "e gomadas, rematadas inferiormente por rodízios e " +
                        "com aros metálicos na parte superior. \n" +
                        "Apresenta dois painéis de madeira com quadrifólios " +
                        "vazados que decoram o alçado entre as teclas e a " +
                        "estante para colocação de pautas. No interior, " +
                        "junto às cordas, alude um painel de motivos " +
                        "vegetalistas recortados. \n",
                R.drawable.piano_min
        );

        final MObject obj_sala_musica_pote = new MObject(
                "Pote de Chocolate",
                "XVIII d.C. - Dinastia Qing, reinado Qianlong",
                "________",
                "Com uma altura de 22,3cm e diâmetro 20,6cm",
                "O Pote circular de parede direita, com tampa " +
                        "de encaixe rematada por pega concavada, adapta-se " +
                        "em pequeno pé, em porcelana branca revestida de " +
                        "vidrado castanho e conhecida como porcelana " +
                        "\"chocolate\", Batávia ou \"café-au-lait\", " +
                        "decorada com esmaltes da \"família rosa\" nas " +
                        "cores rosa, verde, azul, amarelo, preto, branco " +
                        "e vermelho coral sobre o vidrado. ",
                R.drawable.pote_min
        );

        final MObject obj_sala_musica_mesa = new MObject(
                "Mesa de Jogo",
                "XVIII d.C",
                "Pau-santo e embutidos de outras madeiras",
                "Altura de 176cm, profundidade 41 cm e comprimento 88cm",
                "Mesa de jogo, de encostar, em pau-santo decorada com embutidos. " +
                        "Aro retangular saliente, com cantos anteriores em semicírculo, " +
                        "estabelecendo continuidade com o tampo, quando fechado. Na face" +
                        " anterior, uma gaveta central retangular com puxador metálico " +
                        "redondo. Tampo retangular com cantos arredondados, desdobrável," +
                        " que sobrepõe duas abas, fixas por dobradiças metálicas. ",
                R.drawable.mesa_min
        );

        final MObject obj_gabinete_tinteiro = new MObject(
                "Tinteiro",
                "XVIII d.C. ",
                "________",
                "Altura de 6cm e diâmetro de 17,7cm",
                "o Tinteiro tem um formato circular com doze gomos radiantes, " +
                        "com depósito circular central ladeado por seis cavidades " +
                        "destinadas às penas, em faiança branca pintada a azul e vinoso. \n" +
                        "Assenta em três pés esféricos. A sua decoração é pintada com " +
                        "filetes, tarjas e manchas. \n",
                R.drawable.tinteiro_min
        );

        final MObject obj_gabinete_frasco = new MObject(
                "Frasco",
                "XVIII d.C.",
                "Vidro pintado",
                "Altura de 18cm, diâmetro 8cm e superior 6,5cm",
                "Frasco octogonal em vidro transparente com decoração pintada " +
                        "a vermelho, amarelo, azul e branco. Numa das faces, o " +
                        "brasão-de-armas de D. João V. Nas faces menores, tem " +
                        "ornamentação vegetal. Apresenta tampa circular metálica, " +
                        "de rosca.",
                R.drawable.frasco_min
        );

        final MObject obj_gabinete_pote_tabaco = new MObject(
                "Pote de Tabaco",
                "________",
                "Faiança com decoração policroma",
                "Altura de 21,5cm, largura 14cm e comprimento: 18,5cm",
                "Pote para tabaco, configurando uma cabeça de preto, com base " +
                        "circular e asa na parte posterior, em faiança com decoração " +
                        "policroma. Tem o rosto negro e lábios vermelhos. O pescoço " +
                        "está \"vestido\" de verde. A cabeça é coberta por um lenço " +
                        "pontilhado a amarelo, apanhado na nuca e formando simultaneamente a asa.",
                R.drawable.tabaco_min
        );

        final MObject obj_sala_jantar_travessa = new MObject(
                "Travessa",
                "XVIII d.C. ",
                "________",
                "Altura de 3,8 com largura de 27,5 e comprimento 36,5",
                "A travessa apresenta um fundo ovalado e aba oitavada e " +
                        "modelada, em porcelana branca decorada com esmaltes da " +
                        "\"família rosa\" nas cores azul sob o vidrado e rosa, " +
                        "verde, vermelho coral, branco, cinzento e ouro sobre o " +
                        "vidrado. \n" +
                        "No centro, o brasão de armas do 1º Visconde de Mirandela, " +
                        "Francisco António da Veiga Cabral da Câmara Pimentel. \n",
                R.drawable.travessa_min
        );

        final MObject obj_sala_jantar_canape = new MObject(
                "Canapé",
                "1775 d.C. - 1825 d.C.",
                "Madeiras de pau-santo, palhinha.",
                "Altura de 98cm com largura 167,5 cm e  profundidade 18,6 cm",
                "O Canapé retangular neoclássico, com estrutura de madeira, " +
                        "assento empalhado e costas constituídas por quatro espaldares " +
                        "ovais com tabelas entalhadas e vazadas, interligadas " +
                        "superiormente por três segmentos ondulados dispostos em " +
                        "arco. Braços e respetivos apoios verticais ligeiramente " +
                        "encurvados. Cinco pernas anteriores retas molduradas, com " +
                        "ornatos vegetalistas, e cinco pernas posteriores simétricas.",
                R.drawable.canape_min
        );

        final MObject obj_sala_jantar_estojo = new MObject(
                "Estojo de Faqueiro",
                "XVIII d.C.",
                "Estrutura de madeira; interior a veludo; pés de metal e ferragens, " +
                        "dourados.",
                "Com uma altura de 34,5cm, largura 22,6cm e profundidade 21,7cm",
                "Estojo de faqueiro estruturado em madeira. Topo estreito, tampa " +
                        "inclinada integrando pega torneada, com bordo recortado acompanhando " +
                        "o desenho da caixa. Assenta em quatro pés circulares de metal. " +
                        "As pegas, dobradas em arco com anel ao meio, têm espelhos " +
                        "metálicos idênticos, recortados e decorados com motivos " +
                        "incisos. É forrado a veludo vermelho com um galão de seda " +
                        "creme aplicado em contornos.",
                R.drawable.estojo_min
        );


        rooms.add(new MRoom(1,"Sala de Entrada",
                "A Sala de Entrada " +
                "corresponde ao compartimento onde os visitantes aguardavam enquanto não " +
                "eram encaminhados, por pagens, até que os proprietários da casa, de acordo " +
                "com as fórmulas de etiqueta da época.\n" +
                " Neste espaço, encontra-se um teto neoclássico rematado por lanternim " +
                "decorado a estuque. O palácio integra uma sequência de estuques artísticos " +
                "de expressão neoclássica frequentemente observadas nos interiores abastados " +
                "a partir do século XVII.\n\n",
                new int[] {
                        R.drawable.room_entrada1,
                        R.drawable.room_entrada2
                },
                R.raw.sound_sample,
                new ArrayList<MObject>() {{
                    add(obj_entrada1);
                }}));

        rooms.add(new MRoom(2,"Salão Nobre",
                "O Salão Nobre do Palácio reúne os componentes que caracterizam" +
                        " o Barroco: a azulejaria, a talha e a pintura, constituindo um " +
                        "notável exemplar de interior civil do século XVIII. O espaço com " +
                        "toda a sua estética de pompa, esplendor e festa destinava-se às " +
                        "ocasiões de maior cerimónia.\n\n",
                new int[] {R.drawable.room_salao1,
                        R.drawable.room_salao2},
                R.raw.sound_sample,
                new ArrayList<MObject>() {{
                    add(obj_salao_nobre_teto);
                    add(obj_salao_nobre_azulejos);
                }}));

        rooms.add(new MRoom(3,"Oratório",
                "A partir do século XVII, a Capela passou a fazer parte " +
                        "integrante da Casa Senhorial Portuguesa. Deste modo, este " +
                        "é um espaço íntimo reservado à devoção. Este compartimento " +
                        "está associado ao período de intensa religiosidade vivido " +
                        "na é época, bem como aos hábitos de circunscrição da mulher " +
                        "à interioridade doméstica.\n\n",
                new int[] {R.drawable.room_oratorio1,
                        R.drawable.room_oratorio2,
                        R.drawable.room_oratorio3,
                        R.drawable.room_oratorio4},
                R.raw.sound_sample,
                new ArrayList<MObject>() {}));

        rooms.add(new MRoom(4,"Sala do Estrado",
                "A Sala do Estrado representa um hábito que se instalou em " +
                        "Portugal, desde a Idade Média e que perdurou até ao começo do " +
                        "século XIX. Esta tradição consistia no costume de a Senhora bem " +
                        "como todo o grupo feminino, filhas, familiares, criadas e escravas," +
                        " passarem o dia sentadas de pernas cruzadas no chão ou em estrados," +
                        " a fiar, a bordar e a conversar.\n\n",
                new int[] {R.drawable.room_estrado1},
                R.raw.sound_sample,
                new ArrayList<MObject>() {}));

        rooms.add(new MRoom(5,"Salão de Música e do Jogo",
                "O Salão de Música e de Jogo destinava-se a reuniões da nobreza " +
                        "durante as quais a música (cantada e/ou tocada) e o jogo eram " +
                        "frequentes.\n\n",
                new int[] {R.drawable.room_jogo1,
                        R.drawable.room_jogo2,
                        R.drawable.room_jogo3},
                R.raw.sound_sample,
                new ArrayList<MObject>() {{
                    add(obj_sala_musica_mesa);
                    add(obj_sala_musica_piano);
                    add(obj_sala_musica_pote);
                }}));

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
                new int[] {R.drawable.room_gabinete1,
                        R.drawable.room_gabinete2,
                        R.drawable.room_gabinete3},
                R.raw.sound_sample,
                new ArrayList<MObject>() {{
                    add(obj_gabinete_frasco);
                    add(obj_gabinete_pote_tabaco);
                    add(obj_gabinete_tinteiro);
                }}));

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
                new int[] {R.drawable.room_jantar1,
                        R.drawable.room_jantar2},
                R.raw.sound_sample,
                new ArrayList<MObject>() {{
                    add(obj_sala_jantar_canape);
                    add(obj_sala_jantar_estojo);
                    add(obj_sala_jantar_travessa);
                }}));

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
                new int[] {R.drawable.room_cavalaricas1,
                        R.drawable.room_cavalaricas2,
                        R.drawable.room_cavalaricas3},
                R.raw.sound_sample,
                new ArrayList<MObject>() {{
                    add(obj_cavalarica_arreios);
                    add(obj_cavalarica_coche);
                }}));

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
                new int[] {R.drawable.room_cozinha1,
                        R.drawable.room_cozinha2,
                        R.drawable.room_cozinha3},
                R.raw.sound_sample,
                new ArrayList<MObject>() {{
                    add(obj_cozinha_roda);
                    add(obj_cozinha_escano);
                    add(obj_cozinha_almofariz);
                }}));

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
                new int[] {R.drawable.room_jardins1,
                        R.drawable.room_jardins2,
                        R.drawable.room_jardins3},
                R.raw.sound_sample,
                new ArrayList<MObject>() {}));
    }


    public List<MRoom> getRooms() {
        return this.rooms;
    }
}
