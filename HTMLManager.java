import java.util.*;

public class HTMLManager {
    private Queue<HTMLTag> tags;

    public HTMLManager(Queue<HTMLTag> html) {
        if (html == null) {
            throw new IllegalArgumentException("Queue cannot be null");
        } 
        
        tags = new LinkedList<>();
        int originalSize = html.size();
        
        for (int i = 0; i < originalSize; i++) {
            HTMLTag value = html.remove(); 
            tags.add(value); 
            html.add(value); 
        }
    }

    public Queue<HTMLTag> getTags() {
        return tags; 
    }

    public void fixHTML() {
        Stack<HTMLTag> opening = new Stack<>();    
        int size = tags.size(); 
        
        for (int i = 0; i < size; i++) {
            HTMLTag stored = tags.remove(); 
            
            if (stored.isSelfClosing()) {
                tags.add(stored);
            } else if (stored.isOpening()) {
                tags.add(stored);
                opening.push(stored);
            } else if (stored.isClosing()) {
                if (opening.isEmpty()) {
                } else {
                    HTMLTag tagsstored = opening.pop();
                    if (tagsstored.matches(stored)) {
                        tags.add(stored); 
                    } else {
                        tags.add(tagsstored.getMatching());
                    }
                }
            }
        }
        
        while (!opening.isEmpty()) {
            tags.add(opening.pop().getMatching());
        }
    }

    public String toString() {
        String result = "";
        int size = tags.size();
        for (int i = 0; i < size; i++) {
            HTMLTag temp = tags.remove();
            result += temp.toString().trim();
            tags.add(temp);
        }
        return result;
    }
}