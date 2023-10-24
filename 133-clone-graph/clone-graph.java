class Solution {
    public Node cloneGraph(Node node) {
        Map<Integer,Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while(q.peek() != null){
            System.out.println(q);

            Node queueCurr = q.poll();
            int queueCurrVal = queueCurr.val;

            if(map.get(queueCurrVal) == null)
                map.put(queueCurrVal, new Node(queueCurrVal));

            Node mapCurr = map.get(queueCurrVal);
                if(mapCurr.neighbors.isEmpty()){
                    for(Node neighbor : queueCurr.neighbors){
                        int neighborVal = neighbor.val;
                        if(map.get(neighborVal) == null)
                            map.put(neighborVal,new Node(neighborVal));
                        q.add(neighbor);
                        mapCurr.neighbors.add(map.get(neighborVal));

                    }
                }

        }

        return map.get(1);
    }
}