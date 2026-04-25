class Solution {
public:
    void dfs(int node, vector<vector<int>> &adjlist, vector<bool> &visited,
             int &vertexCount, int &edgeCount) {
        visited[node] = true;
        vertexCount++;

        for (int neighbor : adjlist[node]) {
            edgeCount++; // count edge occurrence
            if (!visited[neighbor]) {
                dfs(neighbor, adjlist, visited, vertexCount, edgeCount);
            }
        }
    }

    int countCompleteComponents(int n, vector<vector<int>>& edges) {
        vector<vector<int>> adjlist(n);
        for (auto &e : edges) {
            int u = e[0], v = e[1];
            adjlist[u].push_back(v);
            adjlist[v].push_back(u);
        }

        vector<bool> visited(n, false);
        int completeCount = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int vertexCount = 0, edgeCount = 0;
                dfs(i, adjlist, visited, vertexCount, edgeCount);

                // Each edge counted twice (u->v and v->u)
                edgeCount /= 2;

                // Check if component is complete
                if (edgeCount == (vertexCount * (vertexCount - 1)) / 2) {
                    completeCount++;
                }
            }
        }
        return completeCount;
    }
};
