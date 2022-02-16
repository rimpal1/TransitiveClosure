import java.util.Scanner;

/** CS610851: Programming Assignment 3
 *  Submitted by: Rimpalbahen Suthar
 */
public class TransitiveClosure {
    public static void main(String...args) {
        System.out.println("\nPlease enter an oriented graph to compute its shortest distance and transitive closure:\n ");
        
        int n, st, ed;
        Scanner sc = new Scanner(System.in);
        
        String line = sc.nextLine();
        n = Integer.parseInt(line);
        
        line = sc.nextLine();
        String nums[] = line.split(" ");
        
        st = Integer.parseInt(nums[0]);
        ed = Integer.parseInt(nums[1]);
        
        Dijkstra dij = new Dijkstra(n);
        
        while (true) {
            line = sc.nextLine();
            nums = line.split(" ");
            if ("#".equals(line)) {
                break;
            }
            
            int x = Integer.parseInt(nums[0]);
            int y = Integer.parseInt(nums[1]);
            int w = Integer.parseInt(nums[2]);
            dij.setEdge(x, y, w);
        }
        
        dij.calcDijkstra(st, ed, true);
        dij.calcTransitiveClosure();
        dij.showEdges();
        dij.showTransitiveClosure();
    }
}
/**
SAMPLE INPUT DATA

Given input data:

Graph 1:

6
3 6
1 2 2
2 3 3
3 1 1
4 5 4
5 6 3
6 4 1
#

Graph 2:

6
1 4
1 2 1
2 1 3
3 4 2
4 3 1
5 6 3
6 5 2
#

Graph 3:

8
1 7
1 2 2
2 3 1
3 4 3
4 5 2
5 6 4
6 7 2
7 8 3
#

Graph 4:

8
1 6
1 2 4
2 3 5
3 4 2
5 6 3
6 7 2
7 8 1
#

Graph 5:

8
5 8
1 2 3
2 3 1
3 4 1
4 5 2
5 6 3
6 7 4
7 8 2
8 1 6
#

*/