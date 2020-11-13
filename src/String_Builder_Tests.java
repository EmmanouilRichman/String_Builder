import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class String_Builder_Tests {

    @Test
    public void checkCapacityError() {
        String_Builder builder = new String_Builder(2);
        builder.append("Hello");
        builder.append("Hello");
        builder.append("Hello");
        builder.append("Hello");

        Assertions.assertEquals("HelloHello", builder.getString());

    }

    @Test
    public void checkIfAppendGenerallyWorks() {
        String_Builder builder = new String_Builder();
        builder.append("Hello");
        Assertions.assertEquals("Hello", builder.getString());
    }

    @Test
    public void checkIfCanAddCharacters() {
        String_Builder builder = new String_Builder(2);
        builder.append('c');
        builder.append('e');
        Assertions.assertEquals("ce", builder.getString());
    }


    @Test
    public void checkAddCharacterArray() {
        String_Builder builder = new String_Builder();
        char[] c = {'a', 'b', 'c', 'd'};
        builder.append(c);
        Assertions.assertEquals("abcd", builder.getString());

    }

    @Test
    public void checkAddCharacterArrayWithOffset() {
        String_Builder builder = new String_Builder();
        char[] c = {'a', 'b', 'c', 'd'};
        builder.append(c, 1, c.length);
        Assertions.assertEquals("bcd", builder.getString());
    }

    @Test
    public void checkAddDouble() {
        String_Builder builder = new String_Builder();
        builder.append(45.0);
        builder.append(22.6);
        Assertions.assertEquals("45.022.6", builder.getString());
    }

    @Test
    public void checkRestAdding() {
        String_Builder builder = new String_Builder();
        builder.append(45.67543);
        builder.append(5);
        builder.append("hi");
        Assertions.assertEquals("45.675435hi", builder.getString());
    }

    @Test
    public void CheckGetCharAtIndexWhenOutOfBounds() {
        String_Builder builder = new String_Builder();
        builder.append("ccc");
        Throwable exception = Assertions.assertThrows(StringIndexOutOfBoundsException.class,
                () -> {
                    builder.charAt(5);
                });
    }

    @Test
    public void CheckDeleteWithOneIndex() {
        String_Builder builder = new String_Builder();
        builder.append("My Name is Manny");
        builder.deleteCharAt(6);
        Assertions.assertEquals("My Nam is Manny", builder.getString());
    }

    @Test
    public void CheckDeleteWithTwoIndexes() {
        String_Builder builder = new String_Builder();
        builder.append("abcdefg");
        builder.delete(1, 4);
        Assertions.assertEquals("afg", builder.getString());
    }


    @Test
    public void CheckGetChars(){
        String_Builder builder = new String_Builder();
        builder.append("HelloWorld");
        char[] answer = new char[6];
        builder.getChars(0, 5, answer, 0);
        String returnedValue = "";
        for(char c : answer){
            returnedValue += Character.toString(c);
        }
        returnedValue = returnedValue.substring(0, returnedValue.length() - 1);
        Assertions.assertEquals("Hello", returnedValue);
    }

    @Test
    public void CheckIndexOf(){
        String_Builder builder = new String_Builder();
        builder.append("Hello I Hope You Are Enjoyng My Program");
        Assertions.assertEquals(8, builder.indexOf("Hope"));
        Assertions.assertEquals(-1, builder.indexOf("Dog"));
    }

    @Test
    public void CheckIndexOfWithIndexFrom(){
        String_Builder builder = new String_Builder();
        builder.append("Hello I Hope You Are Enjoying My Program");
        Assertions.assertEquals(-1, "Dog");
        Assertions.assertEquals(-1, "Hello");
        Assertions.assertEquals(6, builder.indexOf("Hope", 6));
        Assertions.assertEquals(0, builder.indexOf("Hello", 0));
    }


}
