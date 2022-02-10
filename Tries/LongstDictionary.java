public class LongstDictionary {
    static class Node{
        Node[] children;
        boolean isEnd;
        String word;
        Node(){
            children = new Node[26];
            isEnd = false;
        }
    }
    static Node root;
    static String res; 
    public static String longestWord(String[] words) {
        root = new Node();
        res = "";
        for(String word:words){
            Node cur = root;
            for(int i=0;i<word.length();i++){
                char ch = word.charAt(i);
                if(cur.children[ch-'a']==null){
                    cur.children[ch-'a']=new Node();
                }
                cur = cur.children[ch-'a'];
            }
            cur.isEnd = true;
            cur.word = word;
        }
        dfs(root);
        return res;
    }
    public static void dfs(Node cur){
        for(int i=0;i<26;i++){
            if(cur.children[i]!=null && cur.children[i].isEnd){
                res = res.length()<cur.children[i].word.length()?cur.children[i].word:res;
                dfs(cur.children[i]);
            }
        }
    }
}
