import java.util.*;

/*
    - A DAG is represented in a list of pairs, the first element of the pair has a directed link to the second element.
    - Given a list of connections as parent->child (like a directed graph).
    - All elements in each pair are uniquely represented by a positive number.
    - Given 2 nodes in the graph, write a function that returns true if the graph contains
      at least one common ancestor for these 2 nodes.
 */
public class FindCommonAncestors {
    public static void main(String args[]) {
        System.out.println(hasCommonAncestors(new int[][]{{1,2}, {3,4}, {1,3}, {5,4}}, 3, 4));
        System.out.println(hasCommonAncestors(new int[][]{{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {9, 11}, {14, 4}, {13, 12}, {12, 9},{15, 13}}, 3, 8));
        System.out.println(hasCommonAncestors(new int[][]{{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {9, 11}, {14, 4}, {13, 12}, {12, 9},{15, 13}}, 5, 8));
        System.out.println(hasCommonAncestors(new int[][]{{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {9, 11}, {14, 4}, {13, 12}, {12, 9},{15, 13}}, 6, 9));
        System.out.println(hasCommonAncestors(new int[][]{{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {9, 11}, {14, 4}, {13, 12}, {12, 9},{15, 13}}, 1, 3));
        System.out.println(hasCommonAncestors(new int[][]{{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {9, 11}, {14, 4}, {13, 12}, {12, 9},{15, 13}}, 3, 1));
        System.out.println(hasCommonAncestors(new int[][]{{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {9, 11}, {14, 4}, {13, 12}, {12, 9},{15, 13}}, 7, 11));
        System.out.println(hasCommonAncestors(new int[][]{{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {9, 11}, {14, 4}, {13, 12}, {12, 9},{15, 13}}, 6, 5));

    }

    public static boolean hasCommonAncestors(int[][] graph, int nodeA, int nodeB) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int[] edge: graph) {
            map.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();
        dfs(map, nodeA, setA);
        dfs(map, nodeB, setB);
        setB.retainAll(setA);
        return setB.size() >= 1;
    }

    public static void dfs(Map<Integer, List<Integer>> map, int node, Set<Integer> set) {
        for(int ancestor: map.getOrDefault(node, Collections.emptyList())) {
            if(!set.contains(ancestor)) {
                set.add(ancestor);
                dfs(map, ancestor, set);
            }
        }
    }
}
