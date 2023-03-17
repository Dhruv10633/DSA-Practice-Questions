//https://leetcode.com/problems/implement-trie-prefix-tree/description/

class Trie {
    class Node{
        boolean isEnd; 
        Node[] child;

        Node(){
            child = new Node[26];
            isEnd=false;
        }
    }

    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node w = root;

        //a loop till word length we keep on adding the string char to
        for(int i=0; i<word.length(); i++){
            int index = word.charAt(i) - 'a';
            
            if(w.child[index]==null){
                w.child[index] = new Node();
            }

            w = w.child[index];
        }
        w.isEnd = true;
    }
    
    public boolean search(String word) {
        Node w = root;

        for(int i=0 ; i<word.length(); i++){
            int index = word.charAt(i) - 'a';
            
            if(w.child[index]==null){
                return false;
            }

            w = w.child[index];
        }

        //to check if the word found is actuaaly a complete word and it ends here
        return w.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        Node w = root;

        for(int i=0 ;i<prefix.length(); i++){
            int index = prefix.charAt(i) - 'a';
            
            if(w.child[index]==null){
                return false;
            }
            w = w.child[index];
        }

        //similar to above but no need to check if the the prefix ends there
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */