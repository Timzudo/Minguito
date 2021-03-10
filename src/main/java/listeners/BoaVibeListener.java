package listeners;

import mambos.SystemInterface;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Emote;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.GenericMessageReactionEvent;

import javax.annotation.Nonnull;
import java.awt.*;
import java.io.IOException;
import java.util.Random;

public class BoaVibeListener extends MinguitoListener {

    private static final String PRINTINFO =
            "$feed: mostra a cara do maior feeder da tuga.\n" +
            "$equipas: faz 2 equipas a toa.\n" +
            "$1v1: faz 1v1 entre dois users.\n" +
            "$5v5: faz equipas para 5v5.\n" +
            "$reroll: da reroll nas equipas.\n" +
            "$top: top 3 users por XP.\n" +
            "$vibe: mete a vibe da sala no ponto.\n" +
            "$skip: da skip na musica.\n" +
            "$stop: estraga a vibe.\n" +
            "$say: mete o bot a falar.\n" +
            "$sound: toggle do som do bot.(Admin)\n" +
            "$poll: fazer polls \n" +
            "$sugerir: sugere novos comandos para o bot.\n" +
            "$simp: diz o nome de um simp.\n" +
            "$piao: xue hua piao piao.\n" +
            "$earrape: manda earrape num video.\n" +
            "$kiri: comando para simpar \uD83D\uDC40.\n" +
            "$mambo(beta): faz uns mambos duvidosos com uma imagem \uD83D\uDC40.\n" +
            "$wide(beta): torna uma imagem thicc\uD83D\uDE29.";



    private static final String EQUIPAS =       "$equipas";
    private static final String V =             "$5v5";
    private static final String REROLL =        "$reroll";
    private static final String FEED =          "$feed";
    private static final String TOP =           "$top";
    private static final String INFO =          "$info";
    private static final String HELP =          "$help";
    private static final String VIBE =          "$vibe";
    private static final String SKIP =          "$skip";
    private static final String STOP =          "$stop";
    private static final String SAY =           "$say";
    private static final String SOUND =         "$sound";
    private static final String SUGGEST =       "$sugerir";
    private static final String SUGGESTLIST =   "$slista";
    private static final String V1 =            "$1v1";
    private static final String POLL =          "$poll";
    private static final String EARRAPE =       "$earrape";
    private static final String SIMP =          "$simp";
    private static final String PIAO =          "$piao";
    private static final String TESTE =         "$teste";
    private static final String SIMAS =         "$simao";
    private static final String FUND =          "$fund";
    private static final String KIRI =          "$kiri";
    private static final String UWU =           "uwu";
    private static final String MAMBO =         "$mambo";
    private static final String WIDE =         "$wide";

    private static final String ERRO =      "Erro mamboso";

    public BoaVibeListener(SystemInterface s){
        super(s);

        SERVER = "761008190091034635";
        VERSION = "MinguitoBot v4.1 (Boa Vibe)";
        this.s = s;
    }


    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if(event.getGuild().getId().equals("761008190091034635")){
            if(!waiting){
                if(!event.getAuthor().isBot() && (event.getMessage().getContentRaw().length() != 0)){
                    Message msg = event.getMessage();
                    String msgContent = msg.getContentRaw();
                    if(msgContent.equalsIgnoreCase(UWU) && event.getMember().getId().equals("283304461789822986")){
                        event.getChannel().sendMessage("https://cdn.discordapp.com/attachments/761008190091034638/784462592928120842/isnowillegal.gif").queue();
                    }
                    String[] id = msgContent.split(" ", 2);

                    if(msgContent.length() > 0 && msgContent.startsWith("#")){
                        event.getChannel().sendMessage("Novo prefixo: $").queue();
                    }

                    int random = new Random().nextInt(200);
                    if(random == 100){
                        event.getChannel().sendMessage("cala so a boca fds").queue();
                    }

                    try{
                        //processLoad(event, s); //Heroku
                        String prefixo = id[0].substring(0, 1);
                        if(prefixo.equals("$")){
                            Emote emote = event.getGuild().getEmoteById("806964637123477515");
                            event.getMessage().addReaction(emote).queue();
                            switch (id[0]) {
                                case EQUIPAS:
                                    processEquipas(event, s);
                                    break;

                                case V:
                                    process5v5(event, s);
                                    break;

                                case REROLL:
                                    processReroll(event, s);
                                    break;

                                case FEED:
                                    processFeed(event, s);
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

                                case SKIP:
                                    processSkip(event);
                                    break;

                                case STOP:
                                    processStop(event);
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

                                case KIRI:
                                    processKiri(event, s);
                                    break;

                                case MAMBO:
                                    processMambo(event);
                                    break;

                                case WIDE:
                                    processWide(event);
                                    break;

                                default:
                                    unknownCommand(event);
                                    break;
                            }
                        }

                        System.out.println("mensagem");
                        //processSave(event, s); //Heroku
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

    @Override
    public void onGenericMessageReaction(@Nonnull GenericMessageReactionEvent event) {
        super.onGenericMessageReaction(event);

        processPoll(event);
    }

    private static void unknownCommand(MessageReceivedEvent event){
        event.getChannel().sendMessage("? Usa $help").queue();
    }

    protected void processInfo(MessageReceivedEvent event){
        MessageChannel channel = event.getChannel();

        EmbedBuilder eb = new EmbedBuilder();
        eb.setColor(Color.orange);
        eb.setTitle(VERSION);

        eb.addField("Comandos:", PRINTINFO, false);
        eb.addField("Novidades:", NOVIDADES, false);

        channel.sendMessage(eb.build()).queue();
    }

    private static void processKiri(MessageReceivedEvent event, SystemInterface s){
        event.getChannel().sendMessage(s.getKiri()).queue();
    }

}
