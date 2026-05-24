import java.util.*;

public class HTMLManager {
  private Queue<HTMLTag> tags;
  
   public HTMLManager(Queue<HTMLTag> html) {
        tags = new LinkedList<>();
        
        if (html == null) {
           throw new IllegalArgumentException("null");
        } 
        
        while(!html.isEmpty()){
            HTMLTag value = html.remove(); 
            tags.add(value); 
        }
    }
    
    public Queue<HTMLTag> getTags(){
      return tags; 
    }
    
    public void fixHTML(){
      Stack <HTMLTag> opening = new Stack <>();    
      Queue <HTMLTag> queue = new LinkedList<>(); 
      
      while(!tags.isEmpty()) {
         HTMLTag stored = tags.remove(); 
         
         if(stored.isSelfClosing()){
            queue.add(stored);
            
         } else if(stored.isOpening()) {
            queue.add(stored);
            opening.push(stored);
            
         } else if(stored.isClosing()) {
            if(opening.isEmpty()) {
            
            } else {
            
            HTMLTag tagsstored = opening.pop();
            
            if(tagsstored.matches(stored)) {
               queue.add(stored); 
                           
            } else {
               queue.add(tagsstored.getMatching());
               tags.add(stored);
            }
            
          }
          
         }
      }
      
      while(!opening.isEmpty()) {
      queue.add(opening.pop().getMatching());
   }
      tags = queue;
  }
    
    public String toString(){
      String result = "";

      int size = tags.size();

         for(int i = 0; i < size; i++) {

            HTMLTag temp = tags.remove();

            result += temp.toString().trim();

            tags.add(temp);
      }

        return result;
    }
       
}
 
/*
# PROGRAM OUTPUT

  ===============================
 Processing tests/test3.html...
 ===============================
 HTML: <br /></p></p>
 Checking HTML for errors...
 HTML after fix: <br />
 ----> Result matches Expected Output!
 ===============================
 Processing tests/test2.html...
 ===============================
 HTML: <a><a><a></a>
 Checking HTML for errors...
 HTML after fix: <a><a><a></a></a></a>
 ----> Result matches Expected Output!
 ==============================+
 Processing tests/test5.html...
 ===============================
 HTML: <div><h1></h1><div><img /><p><br /><br /><br /></div></div></table>
Checking HTML for errors...
HTML after fix: <div><h1></h1><div><img /><p><br /><br /><br /></p></div></div>
----> Result matches Expected Output! 
===============================
Processing tests/test4.html...
===============================
HTML: <div><div><ul><li></li><li></li><li></ul></div>
Checking HTML for errors...
HTML after fix: <div><div><ul><li></li><li></li><li></li></ul></div></div>
----> Result matches Expected Output!
===============================
Processing tests/test1.html...
===============================
HTML: <b><i><br /></b></i>
Checking HTML for errors...
HTML after fix: <b><i><br /></i></b>
----> Result matches Expected Output! 
===============================
        All tests passed!
===============================

*/
 