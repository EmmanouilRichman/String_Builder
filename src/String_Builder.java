import java.util.ArrayList;

public class String_Builder {
    private final int maxSize;
    private ArrayList<String> builder;

    public String_Builder() {
        maxSize = Integer.MAX_VALUE;
        builder = new ArrayList();
    }

    public String_Builder(int capacity) {
        maxSize = capacity;
        builder = new ArrayList<>(capacity);
    }

    public String_Builder(String str) {
        maxSize = Integer.MAX_VALUE;
        builder.add(str);
    }

    public int getMaxSize() {
        return maxSize;
    }

}
