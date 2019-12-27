package excel;

/**
 * @author Lim
 * @date 2019/11/20
 */
@lombok.Data
public class Data implements Comparable<Data> {
    Double a;
    Double b;
    Double c;

    @Override
    public int compareTo(Data o) {
        return b.compareTo(o.getB());
    }
}
