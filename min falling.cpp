// min falling
class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        int n = matrix.size();
        vector<int> vec(n);
        int result = INT_MAX;
        int left;
        for(int i = 0; i < n; i++) {
            vec[i] = matrix[0][i];
            result = min(result, vec[i]);
        }
        for(int i = 1; i < n; i++) {
            result = INT_MAX;
            for(int j = 0; j < n; j++) {
                cout<<vec[j]<<" ";
                if(j == 0) {
                    left = vec[j];
                    vec[j] = min(left + matrix[i][j], vec[j+1] + matrix[i][j]);
                    result = min(result, vec[j]);
                }
                else if(j == n-1) {
                    vec[j] = min(left + matrix[i][j], vec[j] + matrix[i][j]);
                    result = min(result, vec[j]);
                }
                else {
                    int temp = vec[j];
                    int minTemp = min(left + matrix[i][j], vec[j] + matrix[i][j]);
                    vec[j] = min(minTemp, vec[j+1] + matrix[i][j]);
                    left = temp;
                    result = min(result, vec[j]);
                }
                cout<<vec[j]<<endl;
            }
        }
        return result;
    }
};