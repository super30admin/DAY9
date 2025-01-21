#include <bits/stdc++.h>
#include <vector>
#include <iostream>
using namespace std;


int minFallingPathSum(vector<vector<int>>& matrix) {
    int m = matrix.size(), n = matrix[0].size();
    for(int i=m-2;i>=0;i--){
        for(int j=0;j<=n-1;j++){
            int next = INT_MAX;
            if(j-1>=0) next = min(next,matrix[i+1][j-1]);
            next = min(next,matrix[i+1][j]);
            if(j+1<=n-1) next = min(next,matrix[i+1][j+1]);
            matrix[i][j] += next;
        }
    }
    return *min_element(matrix[0].begin(),matrix[0].end());
}

int main(){
    vector<vector<int>> matrix = {{2,1,3},{6,5,4},{7,8,9}};
    cout<<minFallingPathSum(matrix);
    return 0;
}