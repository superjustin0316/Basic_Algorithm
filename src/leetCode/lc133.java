package leetCode;

import java.util.*;

public class lc133 {

    public Node helper(Node node, HashMap<Node,Node> map){ //初始化加入（Node，Node）<-key/value
        List<Node> neighbors = new ArrayList<>();          //???   ①list是什么  ②list的初始化
        Node copy = new Node(node.val, neighbors);
        map.put(node , copy);
        for (Node neighbor : node.neighbors){
            if (!map.containsKey(neighbor)){
                neighbors.add(helper(neighbor,map));//递归调用
            } else {
                neighbors.add(map.get(neighbor));//？？ 双向复制
            }
        }
        return  map.get(node);
    }

    public Node cloneGraph_DFS(Node node){
        return helper(node, new HashMap<>());
    }

    public Node cloneGraph_BFS(Node node){
        if (node == null){
            return null;
        }

        HashMap<Node , Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        queue.offer(node);
        map.put(node, new Node(node.val) );

        while (!queue.isEmpty()){
            Node cur = queue.poll();
            map.get(cur).neighbors = new ArrayList<>();
            for (Node neighbor : cur.neighbors) {
                if (!map.containsKey(neighbor)){
                    map.put(neighbor, new Node(neighbor.val));
                    queue.offer(neighbor);
                }
                map.get(cur).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
}