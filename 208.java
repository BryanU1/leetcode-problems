class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        root.insert(word, 0);
    }
    
    public boolean search(String word) {
        return root.search(word, 0);
    }
    
    public boolean startsWith(String prefix) {
        return root.startsWith(prefix, 0);
    }

    public class Node {
        Node[] nodes;
        boolean isComplete;
        
        public Node() {
            nodes = new Node[26];
        }

        private void insert(String word, int idx) {
            if (idx >= word.length()) return;
            int i = word.charAt(idx) - 'a';
            if (nodes[i] == null) {
                nodes[i] = new Node();
            }

            if (idx == word.length() - 1) nodes[i].isComplete = true;
            nodes[i].insert(word, idx + 1);
        }

        private boolean search(String word, int idx) {
            if (idx >= word.length()) return false;
            int i = word.charAt(idx) - 'a';
            if (nodes[i] == null) return false;
            if (idx == word.length() - 1 && nodes[i].isComplete) return true;

            return nodes[i].search(word, idx + 1);
        }

        private boolean startsWith(String prefix, int idx) {
            if (idx >= prefix.length()) return false;
            int i = prefix.charAt(idx) - 'a';
            if (nodes[i] == null) return false;
            if (idx == prefix.length() - 1) return true;

            return nodes[i].startsWith(prefix, idx + 1);
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */