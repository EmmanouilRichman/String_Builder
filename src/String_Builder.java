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
        builder = new ArrayList<>();
    }

    public String_Builder(String str) {
        maxSize = Integer.MAX_VALUE;
        builder = new ArrayList<>();
        builder.add(str);
    }

    public void append(boolean b) {
        if (!checkCapacity(1)) {
            System.out.println("Not enough space");
        }
        if (b == true) {
            builder.add("true");
        } else {
            builder.add("false");
        }
    }

    public void append(char c) {
        if (!checkCapacity(1)) {
            System.out.println("Not enough space");
        } else {
            builder.add(Character.toString(c));
        }
    }

    public void append(char[] c) {
        if (!checkCapacity(c.length)) {
            System.out.println("Not enough space");
        } else {
            for (char character : c) {
                builder.add(Character.toString(character));
            }
        }
    }

    public void append(char[] str, int offset, int len) {
        if (!checkCapacity(len - offset)) {
            System.out.printf("Not Enough space");
        } else {
            for (int i = offset; i < len; i++) {
                Character item = str[i];
                builder.add(item.toString());
            }
        }
    }

    public void append(double d) {
        if (!checkCapacity(1)) {
            System.out.println("Not Enough Space");
        } else {
            builder.add(Double.toString(d));
        }
    }

    public void append(float f) {
        if (!checkCapacity(1)) {
            System.out.println("Not Enough Space");
        } else {
            builder.add(Float.toString(f));
        }
    }

    public void append(int i) {
        if (!checkCapacity(1)) {
            System.out.println("Not Enough Space");
        } else {
            builder.add(Integer.toString(i));
        }
    }

    public void append(long l) {
        if (!checkCapacity(1)) {
            System.out.println("Not Enough Space");
        } else {
            builder.add(Long.toString(l));
        }
    }

    public void append(Object obj) {
        if (!checkCapacity(1)) {
            System.out.println("Not Enough Space");
        } else {
            builder.add(obj.toString());
        }
    }


    public void append(String str) {
        if (!checkCapacity(1)) {
            System.out.println("Not enough space");

        } else {
            builder.add(str);
        }
    }

    public char charAt(int index) throws StringIndexOutOfBoundsException {
        String wholeString = "";

        wholeString = getString();
        if (index < 0 || index >= wholeString.length()) {
            throw new StringIndexOutOfBoundsException();
        }

        return wholeString.charAt(index);
    }

    public void deleteCharAt(int index) {

        String theString = getString();
        if (index < 0 || index > theString.length() - 1) {
            System.out.print("Not a valid index");
        } else {
            String newString = "";
            newString = theString.substring(0, index);
            newString += theString.substring(index + 1);
            clear();
            builder.add(newString);
        }

    }

    public void delete(int start, int end) {
        String theString = getString();
        if (start < 0 || end > theString.length() - 1) {
            System.out.print("Not a valid index");
        } else {
            String newString = "";
            String first = theString.substring(0, start);
            String last = theString.substring(end + 1);
            newString = first + last;
            clear();
            builder.add(newString);
        }
    }

    public char[] getChars(int srcBegin, int srcEnd, char[] dest, int dstBegin) {
        String toParse = getString();
        if (srcBegin < 0 || srcEnd > toParse.length() - 1) {
            System.out.print("Not a valid index range");
        } else {
            int j = dstBegin;
            for (int i = srcBegin; i < srcEnd; i++) {
                dest[j] = charAt(i);
                j++;
            }
        }
        return dest;
    }

    public int indexOf(String str){
        int index = -1;
        int totalSize = 0;
        String theString = getString();
       if(theString.contains(str)){
          index = theString.indexOf(str);
       }
       return index;
    }


    public int getMaxSize() {
        return maxSize;
    }

    public boolean checkCapacity(int size) {
        return builder.size() != Integer.MAX_VALUE && (builder.size() + size) <= getMaxSize();
    }

    public String getString() {
        String answer = "";
        for (String s : builder) {
            answer += s;
        }
        return answer;
    }

    public void clear() {
        builder.clear();
    }
}
