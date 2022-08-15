class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		int ans = 0;
		int n = s.length();
		for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
			ans = ans + map.get(ch);
            if(i==0){
                continue;
            }
            if(s.charAt(i-1)=='I' && (ch=='V' || ch=='X')){
                ans = ans - 2;
            }else if(s.charAt(i-1)=='X' && (ch=='L' || ch=='C')){
                ans = ans - 20;
            }else if(s.charAt(i-1)=='C' && (ch=='D' || ch=='M')){
                ans = ans - 200;
            }
		}
		return ans;
    }
}