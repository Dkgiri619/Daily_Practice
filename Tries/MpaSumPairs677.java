import java.util.*;
public class MpaSumPairs677 {
    public static void main(String[] args) {

    }
}
class MapSum {
    static class Node{
        Node children[];
        int sum;
        Node(){
            children = new Node[26];
            sum=0;
        }
    }
    HashMap<String, Integer> map;
    Node root;
    public MapSum() {
        root= new Node();
        map = new HashMap<>();
    }
    public void insert(String key, int val) {
        Node cur = root;
        int delta = val - map.getOrDefault(key,0);
        map.put(key,val);
        for(int i=0;i<key.length();i++){
            char ch = key.charAt(i);
            if(cur.children[ch-'a']==null){
                cur.children[ch-'a']= new Node();
            }
            cur = cur.children[ch-'a'];
            cur.sum+=delta;
        }
    }
    
    public int sum(String prefix) {
        Node cur = root;
        for(int i=0;i<prefix.length();i++){
            char ch = prefix.charAt(i);
            if(cur.children[ch-'a']==null){
                return 0;
            }
            cur = cur.children[ch-'a'];
        }
        return cur.sum;
    }
}