package mambos;

import Exceptions.InvalidNumberException;

import java.io.IOException;
import java.util.*;

public class SystemClass implements SystemInterface{

    private final List<String> vibeList;
    private final List<String> piaoList;
    private final List<String> mcList;
    private final List<String> feedList;
    private final List<String> kiriList;
    private final Map<String, String> pollList;

    public SystemClass() throws IOException {

        pollList = new HashMap<>();

        //Vibe
        vibeList = new ArrayList<>();
        vibeList.add("https://www.youtube.com/watch?v=yI6GwHgXqRc");
        vibeList.add("https://www.youtube.com/watch?v=udI21J9xY8A");
        vibeList.add("https://www.youtube.com/watch?v=epDORRdUbsM");
        vibeList.add("https://www.youtube.com/watch?v=GYaPeZKrgdg");
        vibeList.add("https://www.youtube.com/watch?v=6DPwzeDJtwc");

        //Piao
        piaoList = new ArrayList<>();
        piaoList.add("https://www.youtube.com/watch?v=W8x4m-qpmJ8");
        piaoList.add("https://www.youtube.com/watch?v=vRC70dUurI4");
        piaoList.add("https://www.youtube.com/watch?v=3Y6rzhMNiA0");
        piaoList.add("https://www.youtube.com/watch?v=jRk1rBICEZ8");
        piaoList.add("https://www.youtube.com/watch?v=V7A2bx7HAJc");
        piaoList.add("https://www.youtube.com/watch?v=uxXLXCN2DpM");
        piaoList.add("https://www.youtube.com/watch?v=vPMFolLJGEw");
        piaoList.add("https://www.youtube.com/watch?v=GzrhPGHsNeo");
        piaoList.add("https://www.youtube.com/watch?v=OBrvuEJBebU");
        piaoList.add("https://www.youtube.com/watch?v=ruTNl1Wi3-8");
        piaoList.add("https://www.youtube.com/watch?v=yGTUPQ-6tg8");
        piaoList.add("https://www.youtube.com/watch?v=e1vRmL6HMME");
        piaoList.add("https://www.youtube.com/watch?v=Wpd8edP88_Q");
        piaoList.add("https://www.youtube.com/watch?v=qAsX37ceFwE");

        //Timzudo
        mcList = new ArrayList<>();
        mcList.add("https://www.youtube.com/watch?v=i2vhBI0rtF4");
        mcList.add("https://www.youtube.com/watch?v=lIWvrfPbpck");
        mcList.add("https://www.youtube.com/watch?v=oTTYLRiSEoU");
        mcList.add("https://www.youtube.com/watch?v=RtVnr4gaaYk");
        mcList.add("https://www.youtube.com/watch?v=JhaxdRcvhZk");
        mcList.add("https://www.youtube.com/watch?v=LGDdN5Ks4AY");
        mcList.add("https://www.youtube.com/watch?v=hgwC3DNvcBU");
        mcList.add("https://www.youtube.com/watch?v=4RXGGeEx9Ow");
        mcList.add("https://www.youtube.com/watch?v=tYwNQsjeQlU");
        mcList.add("https://www.youtube.com/watch?v=rReWmFBo47k&t");
        mcList.add("https://www.youtube.com/watch?v=qPrxIivaOs4&t");

        //KiriList
        kiriList = new ArrayList<>();
        kiriList.add("https://cdn.discordapp.com/attachments/723609492096549009/792462877487398932/maxresdefault.jpg");
        kiriList.add("https://cdn.discordapp.com/attachments/723609492096549009/792462265298190356/0096de7b35b467faad47be9a24ae4b4e.jpg");
        kiriList.add("https://cdn.discordapp.com/attachments/723609492096549009/792462286706180106/63673153cd83db290f81ee2a974f7d61.jpg");
        kiriList.add("https://cdn.discordapp.com/attachments/723609492096549009/792462290757746708/original_1.jpg");
        kiriList.add("https://cdn.discordapp.com/attachments/723609492096549009/792462291886407720/SmrmRF3H.jpg");
        kiriList.add("https://cdn.discordapp.com/attachments/723609492096549009/792462293841346560/4a24b5352211330437d432d13b4dd791.jpg");
        kiriList.add("https://cdn.discordapp.com/attachments/723609492096549009/792462293878964264/tumblr_pldf3vY50s1ws7f7q_1280.png");
        kiriList.add("https://cdn.discordapp.com/attachments/723609492096549009/792462295182999590/7e951f24549cfa69398c435f48247c9b.jpg");
        kiriList.add("https://cdn.discordapp.com/attachments/723609492096549009/792462296394760232/066b6e38b8b2f699d4a0ca3ce69e8e88.jpg");
        kiriList.add("https://cdn.discordapp.com/attachments/723609492096549009/792462379606474772/294cf70f6b7d2944cae45f790b75413d.gif");
        kiriList.add("https://cdn.discordapp.com/attachments/723609492096549009/792462390700670986/original_1.gif");
        kiriList.add("https://cdn.discordapp.com/attachments/723609492096549009/792462420546813972/2e0d67629487b0eef6adcf5d7090598a.gif");
        kiriList.add("https://cdn.discordapp.com/attachments/723609492096549009/792462547043221554/EnyQ27vVoAYpeOe.jpg");
        kiriList.add("https://cdn.discordapp.com/attachments/723609492096549009/792462888131493938/jskoa1cquov01.png");
        kiriList.add("https://cdn.discordapp.com/attachments/723609492096549009/792462889029599252/Kirishima.Eijirou.full.2236154.jpg");
        kiriList.add("https://cdn.discordapp.com/attachments/723609492096549009/792462889130000454/nz9904ua2zx41.jpg");
        kiriList.add("https://cdn.discordapp.com/attachments/723609492096549009/792462914043772958/Y_6xXq7z_400x400.jpg");
        kiriList.add("https://cdn.discordapp.com/attachments/723609492096549009/792462924470812702/8b95818ce14df118d3940eb3b1910359.jpg");
        kiriList.add("https://cdn.discordapp.com/attachments/723609492096549009/792462924442370058/6e20b9cd10077d24a9905031cf2280070e23814cr1-1242-1196v2_uhq.jpg");
        kiriList.add("https://cdn.discordapp.com/attachments/723609492096549009/792462926052196352/Dl52m2dU0AArRHH.jpg");
        kiriList.add("https://cdn.discordapp.com/attachments/723609492096549009/792462934584197160/vj9bs0ny3mv41.jpg");

        //Feed
        feedList = new ArrayList<>();
        feedList.add("https://cdn.discordapp.com/attachments/457643755223384066/726599848463171604/unknown.png");
        feedList.add("https://cdn.discordapp.com/attachments/457643755223384066/726603075044900944/unknown.png");
        feedList.add("https://cdn.discordapp.com/attachments/457643755223384066/726605788793143456/arseniga.png");
        feedList.add("https://cdn.discordapp.com/attachments/457643755223384066/726607024808263720/gg.png");
        feedList.add("https://cdn.discordapp.com/attachments/457643755223384066/726606001834426449/magik.png");
        feedList.add("https://cdn.discordapp.com/attachments/457643755223384066/726607870078091394/unknown.png");
        feedList.add("https://cdn.discordapp.com/attachments/457643755223384066/726608311931240488/unknown.png");
        feedList.add("https://cdn.discordapp.com/attachments/457643755223384066/726608645533728799/unknown.png");
        feedList.add("https://cdn.discordapp.com/attachments/457643755223384066/726608671756517456/unknown.png");
        feedList.add("https://cdn.discordapp.com/attachments/457643755223384066/726608902874988664/unknown.png");
        feedList.add("https://cdn.discordapp.com/attachments/457643755223384066/726609178948534278/unknown.png");
        feedList.add("https://cdn.discordapp.com/attachments/457643755223384066/726609244165505094/unknown.png");
        feedList.add("https://cdn.discordapp.com/attachments/457643755223384066/730892529695850637/unknown.png");
        feedList.add("https://cdn.discordapp.com/attachments/457643755223384066/731310112404144145/unknown.png");
        feedList.add("https://cdn.discordapp.com/attachments/690369979253784578/732704264526233650/truta3.png");
        feedList.add("https://cdn.discordapp.com/attachments/457643755223384066/732628719121989662/Capturar1.PNG");
        feedList.add("https://cdn.discordapp.com/attachments/457643755223384066/733035045807325265/unknown.png");
        feedList.add("https://cdn.discordapp.com/attachments/457643755223384066/734781907404980264/unknown.png");
        feedList.add("https://cdn.discordapp.com/attachments/457643755223384066/734936324628283502/unknown.png");
        feedList.add("https://cdn.discordapp.com/attachments/457643755223384066/735276768834879618/unknown.png");
        feedList.add("https://cdn.discordapp.com/attachments/457643755223384066/735277438388404254/unknown.png");
        feedList.add("https://cdn.discordapp.com/attachments/457643755223384066/735571672895193128/unknown.png");
        feedList.add("https://cdn.discordapp.com/attachments/457643755223384066/735623801202802696/unknown.png");
        feedList.add("https://cdn.discordapp.com/attachments/457643755223384066/736328770453110854/unknown.png");
        feedList.add("https://cdn.discordapp.com/attachments/457643755223384066/737442122701078629/unknown.png");
        feedList.add("https://media.discordapp.net/attachments/457643755223384066/737078577224482969/unknown.png");
        feedList.add("https://cdn.discordapp.com/attachments/457643755223384066/737716501121073252/unknown.png");
        feedList.add("https://cdn.discordapp.com/attachments/457643755223384066/746141064636661860/unknown.png");
        feedList.add("https://cdn.discordapp.com/attachments/457643755223384066/747250375744290866/unknown.png");
        feedList.add("https://cdn.discordapp.com/attachments/457643755223384066/747250625770815648/unknown.png");
        feedList.add("https://cdn.discordapp.com/attachments/457643755223384066/754131627528945695/unknown.png");
        feedList.add("https://cdn.discordapp.com/attachments/457643755223384066/761771869694328852/unknown.png");
        feedList.add("https://cdn.discordapp.com/attachments/457643755223384066/763139866283737108/unknown.png");
        feedList.add("https://cdn.discordapp.com/attachments/457643755223384066/803756216068604005/unknown.png");
        feedList.add("https://cdn.discordapp.com/attachments/457643755223384066/803782165594636358/unknown.png");
        feedList.add("https://cdn.discordapp.com/attachments/457643755223384066/808891123610812426/unknown.png");

    }

    @Override
    public boolean isPoll(String id) {
        return pollList.containsKey(id);
    }


    @Override
    public void addPoll(String id, String name) {
        pollList.put(id, name);
    }

    @Override
    public String getPoll(String id) {
        return pollList.get(id);
    }

    @Override
    public String getVibe() {
        int random = new Random().nextInt(vibeList.size());
        return vibeList.get(random);
    }

    @Override
    public String getPiao() {
        int random = new Random().nextInt(piaoList.size());
        return piaoList.get(random);
    }

    @Override
    public String getMc() {
        int random = new Random().nextInt(mcList.size());
        return mcList.get(random);
    }

    @Override
    public String getFeed() {
        int random = new Random().nextInt(feedList.size());
        return feedList.get(random);
    }

    @Override
    public String getFeliz() {
        int random = new Random().nextInt(101);
        String feliz = null;

        if(random<=20){
            feliz = random + "% - J ta bue triste";
        }
        if(random>20 && random<=40){
            feliz = random + "% - J ta triste";
        }
        if(random>40 && random<=60){
            feliz = random + "% - J ta com mood normal";
        }
        if(random>60 && random<=80){
            feliz = random + "% - J ta com vibe feliz";
        }
        if(random>80){
            feliz = random + "% - J ta super contente";
        }
        return feliz;
    }


    @Override
    public String getKiri() {
        int random = new Random().nextInt(kiriList.size());
        return kiriList.get(random);
    }


    @Override
    public Pair<Iterator<String>, Iterator<String>> getTeams(List<String> teamList) throws InvalidNumberException {

        if((teamList.size() > 21) || teamList.size() < 2){
            throw new InvalidNumberException();
        }

        LinkedList<String> teamA, teamB;

        Collections.shuffle(teamList);

        teamA = new LinkedList<>();
        teamB = new LinkedList<>();

        for(int i = 0; i<(teamList.size()/2); i++){
            teamA.add(teamList.get(i));
        }

        for(int i = (teamList.size()/2); i<teamList.size(); i++){
            teamB.add(teamList.get(i));
        }

        Pair pair = new PairClass(teamB.iterator(), teamA.iterator());

        return pair;

    }

}
