import java.util.*;

public class HTMLManager {
  private Queue<HTMLTag> tags;
  
   public HTMLManager(Queue<HTMLTag> html) {
        if (html == null) {
           throw new IllegalArgumentException("null");
        } 
        
        tags = new LinkedList<Integers>();
        
        while(!html.isEmpty()){
        }
    }
    
    public Queue<HTMLTag> getTags(){
    }
    
    public String toString(){
    }
    
    public void fixHTML(){
    }
}
