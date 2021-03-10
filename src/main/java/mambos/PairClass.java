package mambos;

public class PairClass<F, S> implements Pair{
    private F first;
    private S second;

    public PairClass(F first, S second){
        this.first = first;
        this.second = second;
    }

    public F getFirst(){
        return first;
    }

    public S getSecond(){
        return second;
    }

}
