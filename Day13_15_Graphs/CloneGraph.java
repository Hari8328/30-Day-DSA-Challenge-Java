import java.util.*;

class Node {

    public int val;
    public List<Node> neighbors;

    public Node(int val) {
        this.val = val;
        neighbors = new ArrayList<>();
    }
}

public class CloneGraph {

    public static Node cloneGraph(Node node) {

        if (node == null)
            return null;

        Map<Node, Node> map =
                new HashMap<>();

        Queue<Node> queue =
                new LinkedList<>();

        queue.offer(node);

        map.put(
                node,
                new Node(node.val)
        );

        while (!queue.isEmpty()) {

            Node current =
                    queue.poll();

            for (Node neighbor :
                    current.neighbors) {

                if (!map.containsKey(
                        neighbor)) {

                    map.put(
                            neighbor,
                            new Node(
                                    neighbor.val
                            )
                    );

                    queue.offer(
                            neighbor
                    );
                }

                map.get(current)
                        .neighbors
                        .add(
                                map.get(
                                        neighbor
                                )
                        );
            }
        }

        return map.get(node);
    }

    public static void main(String[] args) {

        Node node1 =
                new Node(1);

        Node node2 =
                new Node(2);

        node1.neighbors.add(node2);
        node2.neighbors.add(node1);

        Node clone =
                cloneGraph(node1);

        System.out.println(
                clone.val
        );
    }
}
