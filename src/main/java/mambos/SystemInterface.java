package mambos;

import java.util.Iterator;
import java.util.List;

public interface SystemInterface {

    boolean isPoll(String id);

    void addPoll(String id, String name);

    public String getPoll(String id);

    String getVibe();

    String getPiao();

    String getMc();

    String getFeed();

    String getFeliz();

    String getKiri();

    Pair<Iterator<String>, Iterator<String>> getTeams(List<String> teamList);

}
