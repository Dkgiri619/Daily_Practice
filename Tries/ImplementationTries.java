package classes;
class Tries{
    static class Node{
        Node children[];
        boolean isEnd;
        Node(){
            children = new Node[26];
            isEnd = false;
        }
    }
    Node root;
    Tries(){
        root = new Node();
    }
    public void add(String word){
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
    public boolean search(String word){
        Node cur = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(cur.children[ch-'a']==null){
                return false;
            }
            cur = cur.children[ch-'a'];
        }
        return cur.isEnd;
    }
    public boolean searchPrefix(String word){
        Node cur = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(cur.children[ch-'a']==null){
                return false;
            }
            cur = cur.children[ch-'a'];
        }
        return true;
    }

}
public class ImplementationTries {
    public static void main(String[] args) {
        Tries tr = new Tries();
        tr.add("apple");
        tr.add("ape");
        tr.add("appear");
        tr.add("cat");
        tr.add("cattle");
        System.out.println(tr.search("appear"));
        System.out.println(tr.search("app"));
        System.out.println(tr.searchPrefix("app"));

    }
}
