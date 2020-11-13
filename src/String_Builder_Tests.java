import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;

public class String_Builder_Tests {

    @Test
    public void checkCapacityError(){
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
    public void checkIfCanAddCharacters(){
        String_Builder builder = new String_Builder(2);
        builder.append('c');
        builder.append('e');
        Assertions.assertEquals("ce", builder.getString());
    }


    @Test
    public void checkAddCharacterArray(){
        String_Builder builder = new String_Builder();
        char[] c = {'a', 'b', 'c', 'd'};
        builder.append(c);
        Assertions.assertEquals("abcd", builder.getString());

    }

    @Test
    public void checkAddCharacterArrayWithOffset(){
        String_Builder builder = new String_Builder();
        char[] c = {'a', 'b', 'c', 'd'};
        builder.append(c, 1, c.length);
        Assertions.assertEquals("bcd", builder.getString());
    }

    @Test
    public void checkAddDouble(){
        String_Builder builder = new String_Builder();
        builder.append(45.0);
        builder.append(22.6);
        Assertions.assertEquals("45.022.6", builder.getString());
    }

    @Test
    public void checkRestAdding(){
        String_Builder builder = new String_Builder();
        builder.append(45.67543);
        builder.append(5);
        builder.append("hi");
        Assertions.assertEquals("45.675435hi", builder.getString());
    }

    @Test
    public void CheckGetCharAtIndexWhenOutOfBounds(){
        String_Builder builder = new String_Builder();
        builder.append("ccc");
        Throwable exception = Assertions.assertThrows(StringIndexOutOfBoundsException.class,
                ()->{builder.charAt(5);} );
    }

    @Test
    public void CheckDeleteWithOneIndex(){
        String_Builder builder = new String_Builder();
        builder.append("My Name is Manny");
        builder.delete(6);
        Assertions.assertEquals("My Nam is Manny", builder.getString());
    }





}
