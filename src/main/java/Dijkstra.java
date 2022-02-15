
/** CS610851: Programming Assignment 3
 *  Submitted by: Rimpalbahen Suthar
 *  NJIT ID: 31481275
 */
public class Dijkstra {
    int w[][] = null;
    int d[] = null;
    int n;
    int adj[][] = null;
    static final int INFINITY = Integer.MAX_VALUE / 2;
    
    public Dijkstra(int n) {
        this.n = n;
        w = new int[n+5][];
        d = new int[n+5];
        for (int i = 0; i < n+5; i++) {
            w[i] = new int[n+5];
            for (int j = 0; j < n+5; j++) {
                w[i][j] = INFINITY;
            }
        }
    }
    
    public void setEdge(int st, int ed, int weight) {
        w[st][ed] = weight;
    }
    
    public int[] calcDijkstra(int st, int ed, boolean dijk) {
        boolean[] vis = new boolean[n+5];
        
        for (int i = 0; i < n+5; i++) {
            d[i] = INFINITY;
            vis[i] = false;
        }
        
        d[st] = 0;
        
        for (int i = 0; i < n; i++) {
            int mnid = -1, mndist = INFINITY;
            
            for (int j = 1; j <= n; j++) {
                if (!vis[j] && mndist > d[j]) {
                    mndist = d[j];
                    mnid = j;
                }
            }
            
            if (mnid == -1) {
                break;
            }
            
            vis[mnid] = true;
            
            if (ed != -1 && mnid == ed) {
                break;
            }
            
            for (int j = 1; j <= n; j++) {
                if (!vis[j] && d[j] > mndist + w[mnid][j]) {
                    d[j] = mndist + w[mnid][j];
                }
            }
        }
        
        if (dijk) {
            String result;
            if (vis[ed]) {
                result = String.format("Dijkstra's Algorithm: \n---------------------  \nStarting node = %d,\nEnding node = %d, \nShortest Distance = %d\n", st, ed, d[ed]);
            } else {
                result = String.format("Dijkstra's Algorithm: \n---------------------  \nStarting node = %d,\nEnding node = %d,\nNo available path\n", st, ed);
            }

            System.out.println(result);
            return null;
        } else {
            return d;
        }
    }
    
    public void calcTransitiveClosure() {
        adj = new int[n+5][];
        
        for (int i = 1; i <= n; i++) {
            int dist[] = calcDijkstra(i, -1, false);
            adj[i] = new int[n+5];
            
            for (int j = 1; j<= n; j++) {
                adj[i][j] = dist[j];
            }
        }
    }
    
    public void showEdges() {
        System.out.println("Adjacency Matrix for given graph");
        System.out.println("---------------------------------");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (w[i][j] != INFINITY) {
                    System.out.print(1);
                } else {
                    System.out.print(0);
                }
                
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public void showTransitiveClosure() {
        System.out.println("Transitive Closure Matrix");
        System.out.println("--------------------------");
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(adj[i][j] != INFINITY ? 1 : 0);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
