package listeners;

import audio.PlayerManager;
import mambos.SystemInterface;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.audit.ActionType;
import net.dv8tion.jda.api.audit.AuditLogEntry;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.member.update.GuildMemberUpdateNicknameEvent;
import net.dv8tion.jda.api.events.guild.voice.GenericGuildVoiceEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceMoveEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.GenericMessageReactionEvent;
import net.dv8tion.jda.api.exceptions.RateLimitedException;
import net.dv8tion.jda.api.managers.AudioManager;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.Objects;


public class TrutasListener extends MinguitoListener {

    private static final String HELPLILTEXT =   "$kick: kicka todos os membros com a role 'kick'.\n" +
                                                "kicklist: mostra os membros que podem levar kick com o comando $kick.\n" +
                                                "$helplil: mostra os camandos para lil.\n";

    private static final String FORAZZ = "723609492096549006";

    private static final String PING =          "$ping";
    private static final String MINI =          "$mini";
    private static final String CLASSICO =      "$classico";
    private static final String MEDA =          "$meda";
    private static final String HUGANA =        "$hugana";
    private static final String FELIZ =         "$feliz";
    private static final String EQUIPAS =       "$equipas";
    private static final String V =             "$5v5";
    private static final String REROLL =        "$reroll";
    private static final String SIMAO =         "!play";
    private static final String FEED =          "$feed";
    private static final String SUGGESTFEED =   "$sfeed";
    private static final String TOP =           "$top";
    private static final String INFO =          "$info";
    private static final String HELP =          "$help";
    private static final String VIBE =          "$vibe";
    private static final String MC =            "$mc";
    private static final String SKIP =          "$skip";
    private static final String STOP =          "$stop";
    private static final String WATER =         "$water";
    private static final String SAY =           "$say";
    private static final String SOUND =         "$sound";
    private static final String SUGGEST =       "$sugerir";
    private static final String V1 =            "$1v1";
    private static final String POLL =          "$poll";
    private static final String EARRAPE =       "$earrape";
    private static final String SIMP =          "$simp";
    private static final String PIAO =          "$piao";
    private static final String TESTE =         "$teste";
    private static final String SIMAS =         "$simao";
    private static final String FUND =          "$fund";
    private static final String MAMBO =         "$mambo";
    private static final String WIDE =          "$wide";

    private static final String KICK =          "$kick";
    private static final String KICKLIST =      "$kicklist";
    private static final String HELPLIL =       "$helplil";

    private static final String ERRO =      "Erro mamboso";
    private static final String IDSIMAO =   "513020940934971392";

    private static boolean water, moved;


    public TrutasListener(SystemInterface s){
        super(s);

        water = false;
        moved = false;
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if(event.getGuild().getId().equals(SERVER) || event.getGuild().getId().equals(FORAZZ)){
            if(!waiting){
                if(!event.getAuthor().isBot() && (event.getMessage().getContentRaw().length() != 0)){
                    try{
                        String comando = processMessageEvent(event);
                        String prefixo = comando.substring(0, 1);
                        if(prefixo.equals("$")){
                            if(event.getGuild().getId().equals(SERVER)){
                                Emote emote = event.getGuild().getEmoteById("457683584610729990");
                                event.getMessage().addReaction(emote).queue();
                            }
                            switch (comando) {
                                case PING:
                                    processPing(event);
                                    break;

                                case MINI:
                                    processMini(event);
                                    break;

                                case CLASSICO:
                                    processClassico(event);
                                    break;

                                case MEDA:
                                    processMeda(event);
                                    break;

                                case HUGANA:
                                    processHugana(event);
                                    break;

                                case FELIZ:
                                    processFeliz(event, s);
                                    break;

                                case EQUIPAS:
                                    processEquipas(event, s);
                                    break;

                                case V:
                                    process5v5(event, s);
                                    break;

                                case REROLL:
                                    processReroll(event, s);
                                    break;

                                case SIMAO:
                                    processSimao(event);
                                    break;

                                case FEED:
                                    processFeed(event, s);
                                    break;

                                case SUGGESTFEED:
                                    processSuggestFeed(event);
                                    break;

                                case TOP:
                                    processTop(event, s);
                                    break;

                                case INFO:

                                case HELP:
                                    processInfo(event);
                                    break;

                                case VIBE:
                                    processVibe(event, s);
                                    break;

                                case MC:
                                    processMc(event, s);
                                    break;

                                case SKIP:
                                    processSkip(event);
                                    break;

                                case STOP:
                                    processStop(event);
                                    break;

                                case WATER:
                                    processWater(event);
                                    break;

                                case SAY:
                                    processSay(event);
                                    break;

                                case SOUND:
                                    processSound(event);
                                    break;

                                case SUGGEST:
                                    processSuggest(event, s);
                                    break;

                                case V1:
                                    processV1(event, s);
                                    break;

                                case POLL:
                                    processPoll(event, s);
                                    break;

                                case EARRAPE:
                                    processEarrape(event);
                                    break;

                                case SIMP:
                                    processSimp(event, s);
                                    break;

                                case PIAO:
                                    processPiao(event, s);
                                    break;

                                case TESTE:
                                    processTeste(event);
                                    break;

                                case SIMAS:
                                    processSimas(event);
                                    break;

                                case FUND:
                                    processFund(event);
                                    break;

                                case MAMBO:
                                    processMambo(event);
                                    break;

                                case WIDE:
                                    processWide(event);
                                    break;

                                case KICK:
                                    processKick(event);
                                    break;

                                case HELPLIL:
                                    processHelpLil(event);
                                    break;

                                default:
                                    otherCommand(event);
                                    break;
                            }
                        }
                        //System.out.println("mensagem");
                    }
                    catch (IOException | InterruptedException e){
                        MessageChannel channel = event.getChannel();
                        channel.sendMessage(ERRO).queue();
                    }
                }
            }
            else {
                String id = event.getTextChannel().getLatestMessageId();
                String name = event.getMessage().getContentRaw();

                s.addPoll(id, name);
                waiting = false;

                event.getChannel().retrieveMessageById(event.getMessageId()).queue(message -> {
                    message.addReaction("\uD83C\uDDF8").queue();
                    message.addReaction("\uD83C\uDDF3").queue();
                });
            }
        }
    }

    //NICKNAME
    @Override
    public void onGuildMemberUpdateNickname(@Nonnull GuildMemberUpdateNicknameEvent event) {
        /*if(event.getGuild().getId().equals(SERVER) || event.getGuild().getId().equals(FORAZZ)){
            super.onGuildMemberUpdateNickname(event);
            System.out.println("nick");
        }*/
    }

    //CHANGE CHANNEL
    @Override
    public void onGuildVoiceJoin(@NotNull GuildVoiceJoinEvent event) {
        if(event.getGuild().getId().equals(SERVER) || event.getGuild().getId().equals(FORAZZ)){
            super.onGuildVoiceJoin(event);
            infantario(event);
            squirt(event);
        }
    }

    @Override
    public void onGuildVoiceMove(@Nonnull GuildVoiceMoveEvent event) {
        if(event.getGuild().getId().equals(SERVER) || event.getGuild().getId().equals(FORAZZ)){
            super.onGuildVoiceMove(event);
            infantario(event);
            squirtMove(event);
        }
    }

    @Override
    public void onGuildVoiceLeave(@Nonnull GuildVoiceLeaveEvent event) {
        if(event.getGuild().getId().equals(SERVER) || event.getGuild().getId().equals(FORAZZ)){
            super.onGuildVoiceLeave(event);
            if(event.getGuild().getId().equals("457643754744971266")){
                List<AuditLogEntry> list  = null;
                try {
                    list = event.getGuild().retrieveAuditLogs().complete(true);
                } catch (RateLimitedException e) {
                    e.printStackTrace();
                }

                AuditLogEntry entry = list.get(0);
                net.dv8tion.jda.api.entities.User user = entry.getUser();

                if(!(user.getId().equals("723611612556165161") || user.isBot() || user.getId().equals("222675252516225024")) && entry.getType().equals(ActionType.MEMBER_VOICE_KICK)){
                    event.getGuild().kickVoiceMember(event.getGuild().getMember(list.get(0).getUser())).complete();
                    event.getGuild().getDefaultChannel().sendMessage("Para de ser mongo " + user.getName()).queue();
                }
            }
            removeSquirt(event);
        }
    }

    @Override
    public void onGenericMessageReaction(@Nonnull GenericMessageReactionEvent event) {
        super.onGenericMessageReaction(event);

        processPoll(event);
    }

    @Override
    public void onGuildMemberJoin(@Nonnull GuildMemberJoinEvent event) {
        if(event.getGuild().getId().equals(SERVER) || event.getGuild().getId().equals(FORAZZ)){
            super.onGuildMemberJoin(event);
            event.getUser().openPrivateChannel().queue((channel)->{
                if(event.getGuild().getId().equals("457643754744971266")){
                    channel.sendMessage("Dja bu sabi " + event.getMember().getEffectiveName() + ", espera que alguem te de roles para poderes falar.").queue();
                }

            });
        }
    }

    private static void otherCommand(MessageReceivedEvent event){
        Role lilRole = event.getGuild().getRoleById("457956034997387284");



        if(event.getMember().getRoles().contains(lilRole)){
            lilCommands(event);
        }
        else{
            unknownCommand(event);
        }

    }

    private static void lilCommands(MessageReceivedEvent event){

        String[] comandoV = event.getMessage().getContentRaw().split(" ");
        String comando = comandoV[0];

        switch (comando){
            case HELPLIL:
                processHelpLil(event);
                break;
            case KICK:
                processKick(event);
                break;
            case KICKLIST:
                processKickList(event);
                break;
            default:
                unknownCommand(event);
                break;
        }



    }

    private static void unknownCommand(MessageReceivedEvent event){
        event.getChannel().sendMessage("? Usa $help").queue();
    }

    private static void processPing(MessageReceivedEvent event){
        MessageChannel channel = event.getChannel();
        long time = System.currentTimeMillis();
        channel.sendMessage("Pong!") /* => RestAction<Message> */.queue(response /* => Message */ -> response.editMessageFormat("Pong: %d ms", System.currentTimeMillis() - time).queue());
    }

    private static void processMini(MessageReceivedEvent event){
        MessageChannel channel = event.getChannel();
        channel.sendMessage("Juro para de feedar mini! omg").queue();
    }

    private static void processClassico(MessageReceivedEvent event){
        MessageChannel channel = event.getChannel();
        channel.sendMessage("Classico mini, CLASSICO").queue();
    }

    private static void processMeda(MessageReceivedEvent event){
        MessageChannel channel = event.getChannel();
        channel.sendMessage("vai la pro caralho").queue();
    }

    private static void processHugana(MessageReceivedEvent event){
        MessageChannel channel = event.getChannel();
        channel.sendMessage("o meu pc custa 300000 paus").queue();
    }

    private static void processFeliz(MessageReceivedEvent event, SystemInterface s){
        MessageChannel channel = event.getChannel();
        channel.sendMessage(s.getFeliz()).queue();
    }

    private static void processSimao(MessageReceivedEvent event){
        MessageChannel channel = event.getChannel();

        String msgContent = event.getMessage().getContentRaw();

        if(msgContent.equals("!play eu sou peixeiro") && event.getAuthor().getId().equals(IDSIMAO)){
            channel.sendMessage("cala a boca preto filha da puta").queue();
        }
    }

    private static void processSuggestFeed(MessageReceivedEvent event){
        event.getTextChannel().sendMessage("bacano").queue();

        Message msg = event.getMessage();
        event.getJDA().getGuildById("723609492096549006").getTextChannelById("818882523941175377").sendMessage(msg).queue();
    }

    private static void processMc(MessageReceivedEvent event, SystemInterface s){

        if(sound){
            if(Objects.requireNonNull(event.getMember()).getVoiceState().inVoiceChannel()){

                String url = s.getMc();

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

    private static void processWater(MessageReceivedEvent event){
        Role waterRole = event.getGuild().getRoleById("738110296370970735");

        if(!event.getMember().getRoles().contains(waterRole)){
            water = !water;
            if(water){
                event.getTextChannel().sendMessage("proteção de water™ ligada.").queue();
            }
            else{
                event.getTextChannel().sendMessage("proteção de water™ desligada.").queue();
            }
        }else{
            event.getChannel().sendMessage("lida " + event.getMember().getEffectiveName()).queue();
        }

    }

    private static void infantario(GenericGuildVoiceEvent event){
        if(water){
            Member member = event.getMember();
            //criar metodo remove water
            Role water = event.getGuild().getRoleById("738110296370970735");

            if(event.getMember().getRoles().contains(water)){
                event.getGuild().moveVoiceMember(member, event.getGuild().getVoiceChannelById("727233940284506193")).complete();
                if(!moved){
                    event.getGuild().getTextChannelById("724758690636365834").sendMessage(event.getMember().getEffectiveName() + " removido com sucesso.").queue();
                }

                AudioManager audioManager = event.getGuild().getAudioManager();
                audioManager.openAudioConnection(event.getGuild().getVoiceChannelById("727233940284506193"));

                PlayerManager manager = PlayerManager.getInstance();
                manager.loadAndPlay(event.getGuild().getDefaultChannel(), "https://www.youtube.com/watch?v=nHvo-aoN-Zc");
                manager.getGuildMusicManager(event.getGuild()).player.setVolume(20);
            }
            moved = !moved;
        }
    }

    private static void squirt(GuildVoiceJoinEvent event){
        if(event.getChannelJoined().getId().equals("747157430508716042")){
            event.getMember().modifyNickname(event.getMember().getEffectiveName() + " \uD83D\uDCA6").complete();
        }
    }

    private static void squirtMove(GuildVoiceMoveEvent event){
        if(event.getChannelJoined().getId().equals("747157430508716042")){
            event.getMember().modifyNickname(event.getMember().getEffectiveName() + " \uD83D\uDCA6").complete();
        }
        else{
            event.getMember().modifyNickname(event.getMember().getEffectiveName().replace(" \uD83D\uDCA6", "")).complete();
        }
    }

    private static void removeSquirt(GuildVoiceLeaveEvent event){
        if(event.getChannelLeft().getId().equals("747157430508716042")) {
            event.getMember().modifyNickname(event.getMember().getEffectiveName().replace(" \uD83D\uDCA6", "")).complete();
        }
    }


    protected void processInfo(MessageReceivedEvent event){
        MessageChannel channel = event.getChannel();

        EmbedBuilder eb = new EmbedBuilder();
        eb.setColor(Color.YELLOW);
        eb.setTitle(VERSION);

        eb.addField("Comandos:", PRINTINFO, false);
        eb.addField("Novidades:", NOVIDADES, false);

        channel.sendMessage(eb.build()).queue();
    }

    private static void processKick(MessageReceivedEvent event){
        Role kickRole = event.getGuild().getRoleById("818538802028085288");
        Role trutasRole = event.getGuild().getRoleById("457937025430192129");

        List<Member> memberList = event.getGuild().getMembers();

        for(Member m: memberList){
            if(m.getRoles().contains(kickRole)){
                if(!m.getRoles().contains(trutasRole)){
                    m.kick().queue();
                    event.getTextChannel().sendMessage("O membro " + m.getEffectiveName() + " foi kickado pelo lil :" + event.getAuthor().getName()).queue();
                }
                else{
                    event.getTextChannel().sendMessage("O membro " + m.getEffectiveName() + " nao pode ser kickado").queue();
                }
            }
        }
    }
    private static void processKickList(MessageReceivedEvent event){
        Role kickRole = event.getGuild().getRoleById("818538802028085288");
        Role trutasRole = event.getGuild().getRoleById("457937025430192129");

        List<Member> memberList = event.getGuild().getMembers();

        StringBuilder msg = new StringBuilder();

        for(Member m: memberList){
            if(m.getRoles().contains(kickRole)){
                if(!m.getRoles().contains(trutasRole)){
                    msg.append("\n" + m.getUser().getName());
                }
            }
        }

        if(msg.toString().equals("")){
            event.getTextChannel().sendMessage("Nao existem membros que podem levar kick.").queue();
        }
        else{
            EmbedBuilder eb = new EmbedBuilder();
            eb.setColor(Color.yellow);
            eb.addField("Membros que podem levar kick:", msg.toString(), false);
            event.getTextChannel().sendMessage(eb.build()).queue();
        }
    }

    private static void processHelpLil(MessageReceivedEvent event){
        EmbedBuilder eb = new EmbedBuilder();
        eb.setColor(Color.yellow);
        eb.setTitle("MinguitoBot v4.1 (Online)");
        eb.addField("Comandos exclusivos Lil", HELPLILTEXT, false);
        event.getTextChannel().sendMessage("Vai aos dms").queue();

        event.getMember().getUser().openPrivateChannel().queue((channel)->{
            channel.sendMessage(eb.build()).queue();
        });



    }






}
