import java.util.ArrayList;

public class String_Builder {
    private int maxSize;
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
        builder.add(str);
    }

    public void append(boolean b) {
        if(!checkCapacity(1)){
            System.out.println("Not enough space");
        }
        if (b == true) {
            builder.add("true");
        } else {
            builder.add("false");
        }
    }

    public void append(char c) {
        if(!checkCapacity(1)){
            System.out.println("Not enough space");
        }
        builder.add(Character.toString(c));
    }

    public void append(char[] c){
        if(!checkCapacity(c.length)){
            System.out.println("Not enough space");
        }
        else{
            for(char character : c ){
                builder.add(Character.toString(character));
            }
        }
    }

    public void append(char[] str, int offset, int len){
        if(!checkCapacity(len - offset)){
            System.out.printf("Not Enough space");
        }
        else{
            for(int i = offset; i < len; i++){
                Character item = str[i];
                builder.add(item.toString());
            }
        }
    }

    public void append(double d){
        if(!checkCapacity(1)){
            System.out.println("Not Enough Space");
        }
        else{
            builder.add(Double.toString(d));
        }
    }

    public void append(float f){
        if(!checkCapacity(1)){
            System.out.println("Not Enough Space");
        }
        else{
            builder.add(Float.toString(f));
        }
    }

    public void append(int i){
        if(!checkCapacity(1)){
            System.out.println("Not Enough Space");
        }
        else{
            builder.add(Integer.toString(i));
        }
    }

    public void append(long l){
        if(!checkCapacity(1)){
            System.out.println("Not Enough Space");
        }
        else{
            builder.add(Long.toString(l));
        }
    }

    public void append(Object obj){
        if(!checkCapacity(1)){
            System.out.println("Not Enough Space");
        }
        else{
            builder.add(obj.toString());
        }
    }


    public void append(String str){
        if(!checkCapacity(1)){
            System.out.println("Not enough space");

        }
        else{
            builder.add(str);
        }
    }

    public char charAt(int index) throws StringIndexOutOfBoundsException{
        String wholeString = "";

        wholeString = getString();
        if(index <= 0 || index >= wholeString.length()){
            throw new StringIndexOutOfBoundsException();
        }

        return wholeString.charAt(index);
    }

    public void delete(int index){

        String theString = builder.toString();
        if(index < 0 || index > theString.length() - 1) {
            System.out.print("Not a valid index");
        }
        else{
         String newString = "";
         newString = theString.substring(1, index + 1);
         newString += theString.substring(index + 2,theString.length() - 1);
         builder.clear();
         builder.add(newString);
        }

    }

    public int getMaxSize() {
        return maxSize;
    }

    public boolean checkCapacity(int size){
        if(builder.size() != Integer.MAX_VALUE && (builder.size() + size) <= getMaxSize()){
            return true;
        }
        else{
            return false;
        }
    }

    public String getString()
    {
        String answer = "";
        for(String s : builder)
        {
            answer += s;
        }
        return answer;
    }

    public void clear(){
        builder.clear();
    }
}
