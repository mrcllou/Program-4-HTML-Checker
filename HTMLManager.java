import java.util.*;

public class HTMLManager {
  private Queue<HTMLTag> tags;
  
   public HTMLManager(Queue<HTMLTag> html) {
        tags = new LinkedList<>();
        if (html == null) {
           throw new IllegalArgumentException("null");
        } 
        
        while(!html.isEmpty()){
        }
    }
    
    public Queue<HTMLTag> getTags(){
      return tags; 
    }
    
    public void fixHTML(){
      Stack<HTMLTag> openings = new Stack<HTMLtag>();
      int size = this.tags.size();
      for(int i = 0; i < size; i++){
      }
    }
    
    public String toString(){
    }
    
    
}
