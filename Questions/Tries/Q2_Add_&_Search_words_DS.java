//https://leetcode.com/problems/design-add-and-search-words-data-structure/

class WordDictionary {
    class Node{
        boolean end;
        Node[] children;

        Node(){
            end = false;
            children = new Node[26];
        } 
    }

    Node root;

    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {

        Node r = root;

        for(int i=0;i<word.length();i++){
            int index = word.charAt(i)-'a';

            if(r.children[index]==null){
                r.children[index] = new Node();
            }
            r=r.children[index];
        }

        r.end=true;
    }
    
    public boolean search(String word){
        return search(word, root);
    }
    
    //DFS Search for the word
    public boolean search(String word, Node root) {
        if(word.isEmpty()){
            //returns whether word ends here or not
            return (root.end);
        }

        boolean ans = false;

        //if word char at 1st ='.' then we check for all the children
        if(word.charAt(0)=='.'){
            for(Node x : root.children){
                if(x!=null){
                    ans = ans || search(word.substring(1), x);
                }
            }
            
        }

        //if the word char is there in the root children array
        else if(root.children[word.charAt(0)-'a']!=null){
            ans = search(word.substring(1), root.children[word.charAt(0)-'a']);
        }

        //word char not there
        else{
            ans = false;
        }
        return ans;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */