/*
@author Timzudo
version 3.10
TODO playlist mambo grosso / library youtube playlist youtube data api / bugs meter a funcionar em todos os servers / meter roles / cooldown mover / dm / comando chorae
ideias minigame /
 */


import listeners.BoaVibeListener;
import listeners.MerendasListener;
import listeners.TrutasListener;
import mambos.SystemClass;
import mambos.SystemInterface;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import org.apache.log4j.BasicConfigurator;

import javax.security.auth.login.LoginException;
import java.io.IOException;


public class Main {



    private static final String TOKEN =     "yourToken";

    private static SystemInterface s;
    private static JDA jda;

    public Main() throws IOException {
    }

    public static void main(String[] args) throws LoginException, IOException, InterruptedException {
        s = new SystemClass();

        JDABuilder builder = JDABuilder.createDefault(TOKEN);

        BasicConfigurator.configure();

        jda = builder
                .setChunkingFilter(ChunkingFilter.ALL)
                .setMemberCachePolicy(MemberCachePolicy.ALL)
                .enableIntents(GatewayIntent.GUILD_MEMBERS)
                .addEventListeners(new TrutasListener(s))
                .addEventListeners(new MerendasListener(s))
                .addEventListeners(new BoaVibeListener(s))
                .setActivity(Activity.listening("Jvst Fly"))
                .build().awaitReady();
    }
    /*TODO  categorias help
    *       poll
    *       emoji
    *       otimizar codigo
    * */


}
