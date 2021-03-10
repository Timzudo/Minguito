package listeners;

import Exceptions.InvalidNumberException;
import audio.PlayerManager;
import mambos.Pair;
import mambos.PairClass;
import mambos.SystemInterface;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.GenericMessageReactionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.managers.AudioManager;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.*;
import java.util.concurrent.TimeUnit;

public abstract class MinguitoListener extends ListenerAdapter {

    protected SystemInterface s;
    protected String SERVER;

    protected static boolean sound, waiting;
    protected static Pair<List<String>, Boolean> reroll;
    protected static Pair<String, String> v1;
    protected static final String IDTIMZUDO = "222675252516225024";
    protected String VERSION = "MinguitoBot v4.1 (Online)";
    protected String NOVIDADES = "esta sempre online";


    protected static String PRINTINFO =
                    "$ping: ping.\n" +
                    "$mini: para de feedar.\n" +
                    "$classico: classico mini...\n" +
                    "$meda: comando especifico para mandar o meda para o caralho.\n" +
                    "$hugana: classico hugana.\n" +
                    "$feed: mostra a cara do maior feeder da tuga.\n" +
                    "$sfeed: sugerir um feed.\n" +
                    "$suggest: sugerir um comando novo.\n" +
                    "$equipas: faz 2 equipas a toa.\n" +
                    "$1v1: faz 1v1 entre dois users.\n" +
                    "$5v5: faz equipas para 5v5.\n" +
                    "$reroll: da reroll nas equipas.\n" +
                    "$top: top 3 users por XP.\n" +
                    "$vibe: mete a vibe da sala no ponto.\n" +
                    "$mc: mete som bem rebentado na sala.\n" +
                    "$skip: da skip na musica.\n" +
                    "$stop: estraga a vibe.\n" +
                    "$water liga a proteção de water™.\n" +
                    "$say: mete o bot a falar.\n" +
                    "$sound: toggle do som do bot.(Admin)\n" +
                    "$poll: fazer polls \n" +
                    "$sugerir: sugere novos comandos para o bot.\n" +
                    "$poll: fazer polls.\n" +
                    "$simp: diz o nome de um simp.\n" +
                    "$piao: xue hua piao piao.\n" +
                    "$earrape: manda earrape num video.\n" +
                    "$mambo(deve estar fdd): faz uns mambos duvidosos com uma imagem \uD83D\uDC40.\n" +
                    "$wide(deve estar fdd): torna uma imagem thicc\uD83D\uDE29.\n" +
                    "$helplil: mostra comandos para lil.";


    public MinguitoListener(SystemInterface s){
        sound = true;
        waiting = false;
        reroll = null;
        v1 = new PairClass<>("*", "*");
        SERVER = "457643754744971266";

        this.s = s;
    }

    @Override
    public void onReady(@NotNull ReadyEvent event) {
        event.getJDA().getGuildById("723609492096549006").getTextChannelById("818881987489824768").retrieveMessageById("818905651861258320").queue(message -> {
            message.getAttachments().get(0).downloadToFile("Left.png");
        });
        event.getJDA().getGuildById("723609492096549006").getTextChannelById("818881987489824768").retrieveMessageById("819041461072429118").queue(message -> {
            message.getAttachments().get(0).downloadToFile("Top.png");
        });
        System.out.println(SERVER + " Ready");
    }

    public void processPoll(@Nonnull GenericMessageReactionEvent event) {
        super.onGenericMessageReaction(event);

        if(s.isPoll(event.getMessageId())){

            String name = s.getPoll(event.getMessageId());

            event.getChannel().retrieveMessageById(event.getMessageId()).queue(message -> {
                int pos = -1;
                for(MessageReaction emote: message.getReactions()){
                    String s = emote.getReactionEmote().getName();
                    if(s.equals("\uD83C\uDDF8")){
                        pos += emote.getCount();
                    }
                }
                int neg = -1;
                for(MessageReaction emote: message.getReactions()){
                    String n = emote.getReactionEmote().getName();
                    if(n.equals("\uD83C\uDDF3")){
                        neg += emote.getCount();
                    }
                }


                int posS;
                int negS;

                if((pos+neg) == 0){
                    posS = 0;
                    negS = 0;
                }
                else{
                    posS = (pos*100)/(pos+neg);
                    negS = (neg*100)/(pos+neg);
                }

                StringBuilder msg = new StringBuilder();
                msg.append(name).append("\n");

                msg.append("Sim:  ");
                for(int i = 0; i < (posS/5); i++){
                    msg.append("█");
                }
                msg.append(" ").append(posS).append("% \n");

                msg.append("Não: ");
                for(int i = 0; i < (negS/5); i++){
                    msg.append("█");
                }
                msg.append(" ").append(negS).append("% \n");


                message.editMessage(msg).queue();
            });
        }
    }

    protected static void processEquipas(MessageReceivedEvent event, SystemInterface s){

        MessageChannel channel = event.getChannel();
        String msgContent = event.getMessage().getContentRaw();
        String[] userList = msgContent.trim().split(" ");
        List<String> nameList = new LinkedList<>();

        nameList.addAll(Arrays.asList(userList).subList(1, userList.length));

        try {

            Pair<EmbedBuilder, EmbedBuilder> pair = teamEmbedBuilder(s.getTeams(nameList));

            EmbedBuilder eb1 = pair.getFirst();
            EmbedBuilder eb2 = pair.getSecond();

            channel.sendMessage(eb1.build()).queue();
            channel.sendMessage(eb2.build()).queue();

            reroll = new PairClass<>(nameList, true);
        }

        catch(InvalidNumberException e){
            channel.sendMessage("fds mete um numero entre 1 e 20, tao ai " + (userList.length - 1)).queue();
        }
    }

    protected static Pair<EmbedBuilder, EmbedBuilder> teamEmbedBuilder(Pair<Iterator<String>, Iterator<String>> pair){


        Iterator<String> ItA = pair.getFirst();
        Iterator<String> ItB = pair.getSecond();

        EmbedBuilder eb1 = new EmbedBuilder();
        EmbedBuilder eb2 = new EmbedBuilder();

        eb1.setColor(Color.blue);
        eb1.setTitle("Team A:");

        while(ItA.hasNext()){
            eb1.appendDescription(ItA.next() + "\n");
        }


        eb2.setColor(Color.red);
        eb2.setTitle("Team B:");

        while(ItB.hasNext()){
            eb2.appendDescription(ItB.next() + "\n");
        }
        return new PairClass<>(eb1, eb2);

    }

    protected static void processReroll(MessageReceivedEvent event, SystemInterface s){
        if(reroll.getSecond() != null){

            Pair<EmbedBuilder, EmbedBuilder> pair;

            if(reroll.getSecond()){
                pair = teamEmbedBuilder(s.getTeams(reroll.getFirst()));
            }
            else {
                pair = vEmbedBuilder(s.getTeams(reroll.getFirst()));
            }

            EmbedBuilder eb1 = pair.getFirst();
            EmbedBuilder eb2 = pair.getSecond();

            event.getChannel().sendMessage(eb1.build()).queue();
            event.getChannel().sendMessage(eb2.build()).queue();

        }
        else{
            event.getChannel().sendMessage("Faz equipas crl").queue();
        }
    }

    protected static Pair<EmbedBuilder, EmbedBuilder> vEmbedBuilder(Pair<Iterator<String>, Iterator<String>> pair){


        Iterator<String> ItA = pair.getFirst();
        Iterator<String> ItB = pair.getSecond();

        EmbedBuilder eb1 = new EmbedBuilder();
        EmbedBuilder eb2 = new EmbedBuilder();

        eb1.setColor(Color.blue);
        eb1.setTitle("Team A:");


        eb1.appendDescription("TOP - " + ItA.next() + "\n");
        eb1.appendDescription("JNG - " + ItA.next() + "\n");
        eb1.appendDescription("MID - " + ItA.next() + "\n");
        eb1.appendDescription("BOT - " + ItA.next() + "\n");
        eb1.appendDescription("SUP - " + ItA.next() + "\n");


        eb2.setColor(Color.red);
        eb2.setTitle("Team B:");

        eb2.appendDescription("TOP - " + ItB.next() + "\n");
        eb2.appendDescription("JNG - " + ItB.next() + "\n");
        eb2.appendDescription("MID - " + ItB.next() + "\n");
        eb2.appendDescription("BOT - " + ItB.next() + "\n");
        eb2.appendDescription("SUP - " + ItB.next() + "\n");

        return new PairClass<>(eb1, eb2);

    }

    protected static void process5v5(MessageReceivedEvent event, SystemInterface s){


        String[] msg = event.getMessage().getContentRaw().split(" ");

        List<Member> memberList = event.getGuild().getVoiceChannelById("731256824786845803").getMembers();
        List<String> nameList = new LinkedList<>();

        boolean deuMerda = false;

        if(memberList.size() == 10){
            for (Member member: memberList){
                nameList.add(member.getEffectiveName());
            }
        }
        else{
            if(msg.length == 11){
                Collections.addAll(nameList, msg);
                nameList.remove(0);
            }
            else{
                deuMerda = true;
                event.getChannel().sendMessage("Mete ai 10 nomes crl").queue();
            }
        }


        if(!deuMerda){
            Pair<EmbedBuilder, EmbedBuilder> pair = vEmbedBuilder(s.getTeams(nameList));

            EmbedBuilder eb1 = pair.getFirst();
            EmbedBuilder eb2 = pair.getSecond();

            event.getChannel().sendMessage(eb1.build()).queue();
            event.getChannel().sendMessage(eb2.build()).queue();

            reroll = new PairClass<>(nameList, false);
        }

    }

    protected static void processFeed(MessageReceivedEvent event, SystemInterface s){
        String feed = s.getFeed();

        MessageChannel channel = event.getChannel();
        channel.sendMessage(feed).queue();
    }


    protected static void processTop(MessageReceivedEvent event, SystemInterface s){
        MessageChannel channel = event.getChannel();
        try{

            String text = "Lil Sugas feat MC Pirilampo - 4457 xp" + "\n" + "Hugana - 1344 xp" + "\n" + "Vasco - 587 xp";

            EmbedBuilder eb = new EmbedBuilder();
            eb.setColor(Color.orange);
            eb.setTitle("Top 3 XP:");
            eb.setDescription(text);

            channel.sendMessage(eb.build()).queue();
        }
        catch (InvalidNumberException e){
            channel.sendMessage("Erro mamboso").queue();
        }

    }

    protected static void processSuggest(MessageReceivedEvent event, SystemInterface s) throws IOException {

        String[] message = event.getMessage().getContentRaw().split(" ", 2);
        String nickName = event.getAuthor().getName();

        event.getChannel().sendMessage("bacano").queue();

        event.getJDA().getGuildById("723609492096549006").getTextChannelById("818882523941175377").sendMessage(nickName + ": \n" + message[1]).queue();
    }


    /*protected void processLoad(MessageReceivedEvent event, SystemInterface s) throws IOException, InvalidFileException {
        File folder = new File("xp");
        folder.mkdir();

        File file = new File(folder, (event.getGuild().getName() + ".txt"));

        Scanner in = new Scanner(file);


        while(in.hasNext()){
            String id = in.nextLine().trim();
            String name = in.nextLine().trim();
            int xp = Integer.parseInt(in.nextLine().trim());
            s.loadUser(id, name, xp);
        }

        in.close();
    }

    protected static void processSave(MessageReceivedEvent event, SystemInterface s) throws IOException{
        File folder = new File("xp");


        File file = new File(folder, (event.getGuild().getName() + ".txt"));

        FileWriter out = new FileWriter(file);

        Iterator<User> it = s.userIterator();

        while(it.hasNext()){
            User user = it.next();
            out.write(user.getId() + "\n" + user.getName() + "\n" + user.getXp() + "\n");
        }
        out.close();
    }*/

    protected abstract void processInfo(MessageReceivedEvent event);

    protected static void processVibe(MessageReceivedEvent event, SystemInterface s){

        if(sound){
            if(Objects.requireNonNull(event.getMember()).getVoiceState().inVoiceChannel()){

                String url = s.getVibe();

                play(event, url);
            }
            else{
                event.getTextChannel().sendMessage("Entra numa sala wi").queue();
            }
        }
        else{
            event.getChannel().sendMessage("Som inativo, contacte o Timzudo").queue();
        }
    }

    protected static void processPiao(MessageReceivedEvent event, SystemInterface s){

        if(sound){
            if(Objects.requireNonNull(event.getMember()).getVoiceState().inVoiceChannel()){

                String url = s.getPiao();

                play(event, url);
            }
            else{
                event.getTextChannel().sendMessage("Entra numa sala wi").queue();
            }
        }
        else{
            event.getChannel().sendMessage("Som inativo, contacte o Timzudo").queue();
        }

    }

    protected static void processStop(MessageReceivedEvent event){

        Guild guild = event.getGuild();

        AudioManager audioManager = guild.getAudioManager();
        audioManager.closeAudioConnection();

        PlayerManager manager = PlayerManager.getInstance();
        manager.stop(event.getTextChannel());
    }

    protected static void processSkip(MessageReceivedEvent event){

        PlayerManager manager = PlayerManager.getInstance();
        manager.next(event.getTextChannel());
    }

    protected void processSound(MessageReceivedEvent event){
        JDA jda = event.getJDA();
        if(event.getAuthor().getId().equals(IDTIMZUDO)){
            sound = !sound;
            if(sound){
                event.getChannel().sendMessage("Som ativo").queue();
                jda.getPresence().setStatus(OnlineStatus.ONLINE);
            }
            else{
                event.getChannel().sendMessage("Som inativo").queue();
                jda.getPresence().setStatus(OnlineStatus.DO_NOT_DISTURB);
            }
        }
        else {
            if(sound){
                event.getChannel().sendMessage("Estado: Som ativo").queue();
            }
            else{
                event.getChannel().sendMessage("Estado: Som inativo").queue();
            }
        }
    }

    protected static void processV1(MessageReceivedEvent event, SystemInterface s){

        if(v1.getFirst().equals("*") && v1.getSecond().equals("*")){
            v1 = new PairClass<>(event.getMember().getNickname(), "*");
        }
        else if(!v1.getFirst().equals("*") && v1.getSecond().equals("*") && !v1.getFirst().equals(event.getMember().getId())){
            v1 = new PairClass<>(v1.getFirst(), event.getMember().getNickname());
            int random = new Random().nextInt(2);
            switch (random){
                case 0:
                    event.getChannel().sendMessage(v1.getFirst() + " tem mambo superior").queue();
                    break;
                case 1:
                    event.getChannel().sendMessage(v1.getSecond() + " tem mambo superior").queue();
                    break;
            }
            v1 = new PairClass<>("*", "*");
        }

    }

    protected static void processPoll(MessageReceivedEvent event, SystemInterface s) {
        String[] message = event.getMessage().getContentRaw().split(" ", 2);
        String name = message[1];


        event.getChannel().sendMessage(name + "\n(Pode demorar uns segundos a atualizar)").queue();
        waiting = true;
        /*String id = event.getTextChannel().getLatestMessageId();

        s.addPoll(id, name);*/
    }

    protected static void processEarrape(MessageReceivedEvent event){
        if(sound){
            String[] message = event.getMessage().getContentRaw().split(" ");
            if(message.length == 2){
                if(Objects.requireNonNull(event.getMember()).getVoiceState().inVoiceChannel()){

                    String url = message[1];

                    playEarrape(event, url);
                }
                else{
                    event.getTextChannel().sendMessage("Entra numa sala wi").queue();
                }
            }
            else{
                event.getChannel().sendMessage("Mete ai um link fds").queue();
            }
        }
        else{
            event.getChannel().sendMessage("Som inativo, contacte o Timzudo").queue();
        }
    }

    protected static void processSimp(MessageReceivedEvent event, SystemInterface s){
        List<Member> userList = event.getGuild().getMembers();

        int random = new Random().nextInt(userList.size());

        event.getChannel().sendMessage(userList.get(random).getEffectiveName() + " é simp.").queue();
    }


    protected static void processTeste(MessageReceivedEvent event){
        //List<Member> memberList = event.getGuild().getMembers();

        /*for(Member member: memberList){
            if(member.getId().equals("287769628439085056")){
                member.getUser().openPrivateChannel().queue((channel)->{
                    channel.sendMessage(event.getAuthor().getName() + " yau").queue();
                });
            }
        }*/
    }
    protected static void processSimas(MessageReceivedEvent event){
        event.getChannel().sendMessage("Olá , \n" +
                "preciso da tua ajuda! Podes meter like nessa foto e partilhar? Não custa nada e é uma grande ajuda para mim !!! :slight_smile::slight_smile:\n" + "Obrigado!\n" + "https://m.facebook.com/story.php?story_fbid=3145342268907755&id=100002960384957&sfnsn=mo").queue();
    }


    protected static void playEarrape(MessageReceivedEvent event, String url){

        String channelId = Objects.requireNonNull(event.getMember()).getVoiceState().getChannel().getId();
        Guild guild = event.getGuild();
        VoiceChannel channel = event.getGuild().getVoiceChannelById(channelId);

        AudioManager audioManager = guild.getAudioManager();
        audioManager.openAudioConnection(channel);

        PlayerManager manager = PlayerManager.getInstance();
        manager.loadAndPlay(event.getTextChannel(), url);
        manager.getGuildMusicManager(event.getGuild()).player.setVolume(10000);
    }


    protected static void play(MessageReceivedEvent event, String url){

        String channelId = Objects.requireNonNull(event.getMember()).getVoiceState().getChannel().getId();
        Guild guild = event.getGuild();
        VoiceChannel channel = guild.getVoiceChannelById(channelId);

        AudioManager audioManager = guild.getAudioManager();
        audioManager.openAudioConnection(channel);

        PlayerManager manager = PlayerManager.getInstance();
        manager.loadAndPlay(event.getTextChannel(), url);
        manager.getGuildMusicManager(event.getGuild()).player.setVolume(20);
    }

    protected static void processFund(MessageReceivedEvent event){
        MessageChannel channel = event.getChannel();

        channel.sendMessage("https://www.gofundme.com/f/nitro-para-os-trutas?utm_medium=copy_link&utm_source=customer&utm_campaign=p_lico+share-sheet").queue();
    }

    protected static void processSay(MessageReceivedEvent event){

        if(sound){
            String[] message = event.getMessage().getContentRaw().split(" ", 2);
            if(message.length != 1 && message[1].length() <= 50){
                MessageBuilder msg = new MessageBuilder();
                msg.append(message[1]);
                msg.setTTS(true);
                msg.sendTo(event.getChannel()).queue();
            }
            else{
                event.getChannel().sendMessage("Tamanho de mensagem bem cansado.").queue();
            }
        }
        else{
            event.getChannel().sendMessage("Som inativo, contacte o Timzudo").queue();
        }

    }

    protected static String processMessageEvent(MessageReceivedEvent event){
        Message msg = event.getMessage();
        String msgContent = msg.getContentRaw();
        String[] id = msgContent.split(" ", 2);

        int random = new Random().nextInt(500);

        if(random == 100){
            event.getChannel().sendMessage("cala so a boca fds").queue();
        }

        return id[0];
    }

    protected static void processMambo(MessageReceivedEvent event) throws InterruptedException, IOException {
        if(event.getMessage().getAttachments().isEmpty()){
            event.getTextChannel().sendMessage("Mete ai uma imagem fds").queue();
        }
        else{
            event.getMessage().getAttachments().get(0).downloadToFile("In.png");

            TimeUnit.MILLISECONDS.sleep(500);

            File discFile = new File("In.png");
            BufferedImage discImage = ImageIO.read(discFile);

            BufferedImage newImage = resize(discImage,657, 379);
            newImage = bottomImage(newImage);
            newImage = topImage(newImage);

            ImageIO.write(newImage, "png", new File("column.png"));
            File Out = new File("column.png");

            event.getTextChannel().sendFile(Out).queue();

            discFile.delete();

        }
    }

    protected static BufferedImage bottomImage(BufferedImage img) throws IOException, InterruptedException {
        File bottomFile = new File("Left.png");
        BufferedImage defaultImage = ImageIO.read(bottomFile);

        final BufferedImage rowImage = new BufferedImage(1332,378,BufferedImage.TYPE_INT_RGB);

        Graphics2D g2dColumn = rowImage.createGraphics();
        g2dColumn.drawImage(defaultImage,0,0, null);
        g2dColumn.drawImage(img,671,4, null);

        return rowImage;
    }

    protected static BufferedImage topImage(BufferedImage img) throws IOException {
        File topFile = new File("Top.png");
        BufferedImage defaultImage = ImageIO.read(topFile);

        final BufferedImage columnImage = new BufferedImage(1332,757,BufferedImage.TYPE_INT_RGB);

        Graphics2D g2dColumn = columnImage.createGraphics();
        g2dColumn.drawImage(defaultImage,0,0, null);
        g2dColumn.drawImage(img,0,379, null);

        return columnImage;
    }

    protected static BufferedImage resize(BufferedImage img, int newW, int newH) {
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }

    protected static void processWide(MessageReceivedEvent event) throws InterruptedException, IOException {
        if(event.getMessage().getAttachments().isEmpty()){
            event.getTextChannel().sendMessage("Mete ai uma imagem fds").queue();
        }
        else{
            event.getMessage().getAttachments().get(0).downloadToFile("Wide.png");

            TimeUnit.SECONDS.sleep(1);

            File discFile = new File("Wide.png");
            BufferedImage discImage = ImageIO.read(discFile);

            BufferedImage newImage = resize(discImage,discImage.getWidth(), discImage.getHeight()/2);

            ImageIO.write(newImage, "png", new File("WideOut.png"));
            File Out = new File("WideOut.png");

            event.getTextChannel().sendFile(Out).queue();

            discFile.delete();

        }
    }

}