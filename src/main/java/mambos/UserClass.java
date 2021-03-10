package mambos;

public class UserClass implements User{

    private final String id;
    private final String name;
    private String chinese;
    private int xp;

    public UserClass(String id, String name){
        this.id = id;
        this.name = name;
        this.xp = 0;
    }

    public UserClass(String id, String name, int xp){
        this.id = id;
        this.name = name;
        this.xp = xp;
    }

    @Override
    public void increaseXp() {
        xp += 1;
    }

    @Override
    public void setChinese(String chinese) {
        this.chinese = chinese;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getChinese() {
        return chinese;
    }

    @Override
    public int getXp() {
        return xp;
    }

    @Override
    public String toString(){
        return getName() + " " + getXp();
    }

    @Override
    public int compareTo(User other){
        if(other.getXp() - xp != 0){
            return other.getXp() - xp;
        }
        if(id.compareTo(other.getId()) != 0){
            return id.compareTo(other.getId());
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserClass userClass = (UserClass) o;
        return xp == userClass.xp &&
                id.equals(userClass.id);
    }
}
