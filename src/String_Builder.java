import java.util.ArrayList;
import java.util.List;

public class String_Builder {
    private final int maxSize;
    private final List<String> builder;

    /**
     * Initialize an empy String Builder
     */
    public String_Builder() {
        maxSize = Integer.MAX_VALUE;
        builder = new ArrayList<>();
    }

    /**
     * Inititalize a String Builder with a set capacity
     *
     * @param capacity size of String Builder
     */
    public String_Builder(int capacity) {
        maxSize = capacity;
        builder = new ArrayList<>();
    }

    /**
     * Initialize a String Builder with a String
     *
     * @param str String to add
     */
    public String_Builder(String str) {
        maxSize = Integer.MAX_VALUE;
        builder = new ArrayList<>();
        builder.add(str);
    }

    /**
     * Adds a boolean
     *
     * @param b Boolean to add
     */
    public void append(boolean b) {
        if (!checkCapacity(1)) {
            System.out.println("Not enough space");
        }
        if (b) {
            builder.add("true");
        } else {
            builder.add("false");
        }
    }

    /**
     * Adds the desired character
     *
     * @param c character to add
     */
    public void append(char c) {
        if (!checkCapacity(1)) {
            System.out.println("Not enough space");
        } else {
            builder.add(Character.toString(c));
        }
    }

    /**
     * Adds the values in a character array
     *
     * @param c character array to add
     */
    public void append(char[] c) {
        if (!checkCapacity(c.length)) {
            System.out.println("Not enough space");
        } else {
            for (char character : c) {
                builder.add(Character.toString(character));
            }
        }
    }

    /**
     * Adds the values in a character array according to a
     * desired offset
     *
     * @param str    array to add
     * @param offset where to start
     * @param len    length of the array
     */
    public void append(char[] str, int offset, int len) {
        if (!checkCapacity(len - offset)) {
            System.out.print("Not Enough space");
        } else {
            for (int i = offset; i < len; i++) {
                char item = str[i];
                builder.add(Character.toString(item));
            }
        }
    }

    /**
     * Adds the desired double value
     *
     * @param d double value to add
     */
    public void append(double d) {
        if (!checkCapacity(1)) {
            System.out.println("Not Enough Space");
        } else {
            builder.add(Double.toString(d));
        }
    }

    /**
     * Adds the desired flat value
     *
     * @param f float value to add
     */
    public void append(float f) {
        if (!checkCapacity(1)) {
            System.out.println("Not Enough Space");
        } else {
            builder.add(Float.toString(f));
        }
    }

    /**
     * Adds the desired integer value
     *
     * @param i Integer value to add
     */
    public void append(int i) {
        if (!checkCapacity(1)) {
            System.out.println("Not Enough Space");
        } else {
            builder.add(Integer.toString(i));
        }
    }

    /**
     * Adds the desired long value
     *
     * @param l long to add
     */
    public void append(long l) {
        if (!checkCapacity(1)) {
            System.out.println("Not Enough Space");
        } else {
            builder.add(Long.toString(l));
        }
    }

    /**
     * Adds the desired object
     *
     * @param obj Object to add
     */
    public void append(Object obj) {
        if (!checkCapacity(1)) {
            System.out.println("Not Enough Space");
        } else {
            builder.add(obj.toString());
        }
    }


    /**
     * Adds the desired String
     *
     * @param str String to add
     */
    public void append(String str) {
        if (!checkCapacity(1)) {
            System.out.println("Not enough space");

        } else {
            builder.add(str);
        }
    }

    /**
     * Gets the character at the desired index
     *
     * @param index index desired
     * @return character at the index
     * @throws StringIndexOutOfBoundsException thrown when desired index is out of range
     */
    public char charAt(int index) throws StringIndexOutOfBoundsException {
        String wholeString;

        wholeString = getString();
        if (index < 0 || index >= wholeString.length()) {
            throw new StringIndexOutOfBoundsException();
        }

        return wholeString.charAt(index);
    }

    /**
     * Delete a character at a desired location
     *
     * @param index index of character to delete
     */
    public void deleteCharAt(int index) {

        String theString = getString();
        if (index < 0 || index > theString.length() - 1) {
            System.out.print("Not a valid index");
        } else {
            String newString;
            newString = theString.substring(0, index);
            newString += theString.substring(index + 1);
            clear();
            append(newString);
        }

    }

    /**
     * Deleting a range of characters
     *
     * @param start start index
     * @param end   end index
     */
    public void delete(int start, int end) {
        String theString = getString();
        if (start < 0 || end > theString.length() - 1) {
            System.out.print("Not a valid index");
        } else {
            String newString;
            String first = theString.substring(0, start);
            String last = theString.substring(end + 1);
            newString = first + last;
            clear();
            append(newString);
        }
    }

    /**
     * Place items in desired range into a destination array at the desired starting index
     *
     * @param srcBegin index to start copying
     * @param srcEnd   index to stop copying
     * @param dest     the destination array
     * @param dstBegin index to start copying items into
     * @return the destination array with the desired values
     */
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

    /**
     * Find the index of a certain String
     *
     * @param str String to find
     * @return the location of the String
     */
    public int indexOf(String str) {
        int index = -1;
        int totalSize = 0;
        String theString = getString();
        if (theString.contains(str)) {
            index = theString.indexOf(str);
        }
        return index;
    }

    /**
     * Find the index of a String after a certain index
     *
     * @param str       String to find
     * @param fromIndex Index to start from
     * @return the index that has the location of the desired String
     */
    public int indexOf(String str, int fromIndex) {
        int index = -1;
        int totalSize = 0;
        String theString = getString();
        if (fromIndex < 0 || fromIndex >= theString.length()) {
            throw new NullPointerException();
        } else {
            theString = theString.substring(fromIndex, theString.length() - 1);
            if (theString.contains(str)) {
                return index = theString.indexOf(str);
            }
        }
        return index;
    }

    /**
     * Insert the String value of a boolean at the desired offset
     *
     * @param offset the index of the offset
     * @param b      the boolean to add
     */
    public void insert(int offset, boolean b) {
        String answer = "";
        String boolAsString;
        String stringOfBuilder = getString();
        if (!checkCapacity(1)) {
            System.out.println("Not enough space");
        } else {
            clear();
            if (b == true) {
                boolAsString = "true";
            } else {
                boolAsString = "false";
            }
            if (offset == 0) {
                answer = boolAsString + stringOfBuilder;
            } else if (offset == stringOfBuilder.length() - 1) {
                answer = stringOfBuilder + boolAsString;
            } else {
                answer = stringOfBuilder.substring(0, offset) + boolAsString +
                        stringOfBuilder.substring(offset);
            }
        }
        append(answer);
    }

    /**
     * Insert a character at the desired offset
     *
     * @param offset Index to place character
     * @param c      the desired character to add
     */
    public void insert(int offset, char c) {
        String answer = "";
        String stringOfBuilder = getString();
        clear();
        if (!checkCapacity(1)) {
            System.out.println("Not enough space");
        }
        if (offset == 0) {
            answer = c + stringOfBuilder;
        } else if (offset == stringOfBuilder.length() - 1) {
            answer = stringOfBuilder + c;
        } else {
            answer = stringOfBuilder.substring(0, offset) + c +
                    stringOfBuilder.substring(offset);
        }
        append(answer);
    }


    /**
     * Get the total size of the String Builder
     *
     * @return the total size
     */
    public int getMaxSize() {
        return maxSize;
    }

    /**
     * Checking capacity and ability to add new items
     *
     * @param size the desired amout of words to add
     * @return if it is possible to add the desired items
     */
    public boolean checkCapacity(int size) {
        return builder.size() != Integer.MAX_VALUE && (builder.size() + size) <= getMaxSize();
    }

    /**
     * Returns a String representation of String Builder
     *
     * @return String Builder as String
     */
    public String getString() {
        String answer = "";
        for (String s : builder) {
            answer += s;
        }
        return answer;
    }

    /**
     * Clears the String Builder
     */
    public void clear() {
        builder.clear();
    }
}
