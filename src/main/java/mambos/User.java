package mambos;

public interface User extends Comparable<User>{

    void increaseXp();

    void setChinese(String chinese);

    String getId();

    String getName();

    String getChinese();

    int getXp();
}
