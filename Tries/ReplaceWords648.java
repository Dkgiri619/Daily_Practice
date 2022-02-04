import java.util.*;
public class ReplaceWords648 {
    public static void main(String[] args) {
        
    }
}
class Solution {
    static class Node{
        Node children[];
        boolean isEnd;
        Node(){
            children = new Node[26];
            isEnd = false;
        }
    }
    Node root;
    public  void insert(String word){
        Node cur = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(cur.children[ch-'a']==null){
                cur.children[ch-'a']=new Node();
            }
            cur = cur.children[ch-'a'];
        }
        cur.isEnd = true;
    }
    public String search(String word){
        String res = "";
        Node cur = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(cur.children[ch-'a']==null){
                res = word;
                break;
            }
            res+=ch;
            cur = cur.children[ch-'a'];
            if(cur.isEnd==true){
                break;
            }
        }
        return res;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        root= new Node();
        for(String word:dictionary){
            insert(word);
        }
        String words[] = sentence.split(" ");
        for(int i=0;i<words.length;i++){
            words[i]=search(words[i]);
            
        }
        return String.join(" ", words);
    }
}