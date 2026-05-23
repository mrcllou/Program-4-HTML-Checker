import java.util.*;

public class HTMLManager {
  private Queue<HTMLTag> tags;
  
   public HTMLManager(Queue<HTMLTag> html) {
        tags = new LinkedList<>();
        
        if (html == null) {
           throw new IllegalArgumentException("null");
        } 
        
        while(!html.isEmpty()){
            HTMLTag value = html.remove; 
            tags.add(value); 
        }
    }
    
    public Queue<HTMLTag> getTags(){
      return tags; 
    }
    
    public void fixHTML(){
      
    }
    
    public String toString(){
    }
    
    
}
