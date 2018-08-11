package data;

import java.util.Arrays;
import java.util.List;

public class GenericData {

    List<String> stringList = Arrays.asList("a","b","c","d");

    public List<String> getStringList(){
        return this.stringList;
    }

    public void setStringList(List<String> list){
        this.stringList = list;
    }
}