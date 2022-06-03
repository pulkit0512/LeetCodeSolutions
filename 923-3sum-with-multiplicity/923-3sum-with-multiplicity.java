class Solution {
    int mod = 1000000007;
    public int threeSumMulti(int[] arr, int target) {
        int[] map = new int[101];
        for(int x:arr){
            map[x]++;
        }
        int ans = 0;
        for(int i=0;i<=100;i++) {
            if(map[i]==0) {
                continue;
            }
            int j = i, k = 100;
            while(j<=k){
                while(map[j]==0){
                    j++;
                }
                while(map[k]==0){
                    k--;
                }
                if(j>k){
                    break;
                }
                if(i+j+k==target){
                    //System.out.println(i+" "+j+" "+k);
                    //System.out.println(map[i]+" "+map[j]+" "+map[k]);
                    if(i==j && j==k) {
                        ans = (ans + calculate(map[i], 3))%mod;
                    }else if(i==j && i!=k) {
                        ans = (ans + (calculate(map[i], 2)*calculate(map[k], 1))%mod)%mod;
                    }else if(i==k && i!=j) {
                        ans = (ans + (calculate(map[i], 2)*calculate(map[j], 1))%mod)%mod;
                    }else if(j==k && j!=i) {
                        ans = (ans + (calculate(map[j], 2)*calculate(map[i], 1))%mod)%mod;
                    }else {
                        ans = (ans + (((calculate(map[i], 1)*calculate(map[j], 1))%mod)*calculate(map[k],1))%mod)%mod;
                    }
                    j++;
                    k--;
                }else if(i+j+k<target){
                    j++;
                }else{
                    k--;
                }
            }
        }
        return ans;
    }
    
    private int calculate(int n, int k) {
        if(n<k){
            return 0;
        }
        if(k==1){
            return n;
        }else if(k==2) {
            if(n%2==0){
                return (n/2)*(n-1);
            }else{
                return n*((n-1)/2);
            }
        }else{
            long x = n;
            x = ((x*(x-1)*(x-2))/6)%mod;
            return (int)x;
        }
    }
}