package Commands;

public class Gen<T> {
    T ob;
    public Gen(T o){
        ob = o;
    }
    public static <T> T getMiddle(T... a) {
        return a[a.length / 2];
    }
}
