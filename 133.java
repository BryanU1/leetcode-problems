/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (node.neighbors.size() == 0) return new Node(node.val);
        return dfs(node, new HashMap<>());
    }

    public Node dfs(Node curr, HashMap<Node, Node> map) {
        List<Node> neighbor = new ArrayList<>();
        Node clone = new Node(curr.val);
        map.put(curr, clone);
        for (int i = 0; i < curr.neighbors.size(); i++) {
            Node temp = curr.neighbors.get(i);
            if (map.containsKey(temp)) {
                neighbor.add(map.get(temp));
            } else {
                neighbor.add(dfs(temp, map));
            }
        }
        clone.neighbors = neighbor;
        return clone;
    }
}