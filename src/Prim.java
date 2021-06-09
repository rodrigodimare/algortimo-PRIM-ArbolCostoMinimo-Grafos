// A Java program for Prim's Minimum Spanning Tree (MST) algorithm.
// The program is for adjacency matrix representation of the graph

import java.util.*;
import java.lang.*;
import java.io.*;

 public class Prim {
        // Number of vertices in the graph
        private int V;

        public Prim(int v){
            this.V = v;
        }

        // A utility function to find the vertex with minimum key
        // value, from the set of vertices not yet included in MST
        int minKey(int key[], Boolean mstSet[])
        {
            // Initialize min value
            int min = Integer.MAX_VALUE, min_index = -1;

            for (int v = 0; v < V; v++)
                if (mstSet[v] == false && key[v] < min) {
                    min = key[v];
                    min_index = v;
                }

            return min_index;
        }

        // A utility function to print the constructed MST stored in
        // parent[]
        void printMST(int parent[], int graph[][])
        {
            int acum = 0;
            System.out.println("Edge \tWeight");
            //Como aca lo adaptamos es V-1 pero en realidad es v...
            // es decir tomamos como root el primero como dice el algoritmo
            // Da la casualidad que la ciudad "0" (en realidad para nosotros la ciudad 1)
            // entonces se lo "saca" del grafo y luego la ciudad 3 (en el ejercicio ciudad 4, pero los grafos arrancan desde el 0)
            // tambien tiene generador la sacamos del grafo ---------> esto lo hacemos en la linea 72 y 75
            // Entonces si nosotros aca recorremos hasta i < V nos tira out of bounds
            for (int i = 1; i < V-1; i++) {
                System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
                acum += graph[i][parent[i]];
            }
            System.out.println("Minimum Cost Spanning Tree: " + acum);

        }

        // Function to construct and print MST for a graph represented
        // using adjacency matrix representation
        void primMST(int graph[][])
        {
            // Array to store constructed MST
            int parent[] = new int[V];

            // Key values used to pick minimum weight edge in cut
            int key[] = new int[V];

            // To represent set of vertices included in MST
            Boolean mstSet[] = new Boolean[V];

            // Initialize all keys as INFINITE
            for (int i = 0; i < V; i++) {
                key[i] = Integer.MAX_VALUE;
                mstSet[i] = false;
            }

            // Sacamos los nodos que tienen generador
            key[0] = 0;
            key[3] = 0;

            parent[0] = -1; // First node is always root of MST
            parent[3] = -1;

            // The MST will have V vertices
            for (int count = 0; count < V - 1; count++) {
                // Pick thd minimum key vertex from the set of vertices
                // not yet included in MST
                int u = minKey(key, mstSet);

                // Add the picked vertex to the MST Set
                mstSet[u] = true;

                // Update key value and parent index of the adjacent
                // vertices of the picked vertex. Consider only those
                // vertices which are not yet included in MST
                for (int v = 0; v < V ; v++)

                    // graph[u][v] is non zero only for adjacent vertices of m
                    // mstSet[v] is false for vertices not yet included in MST
                    // Update the key only if graph[u][v] is smaller than key[v]
                    if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
                        parent[v] = u;
                        key[v] = graph[u][v];
                    }
            }

            // print the constructed MST
            printMST(parent, graph);
        }
}
