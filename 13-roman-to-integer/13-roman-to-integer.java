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
			ans = ans + map.get(s.charAt(i));
			if (i != 0 && (s.charAt(i) == 'X' || s.charAt(i) == 'V') && s.charAt(i - 1) == 'I') {
				ans = ans - 2;
			} else if (i != 0 && (s.charAt(i) == 'L' || s.charAt(i) == 'C') && s.charAt(i - 1) == 'X') {
				ans = ans - 20;
			} else if (i != 0 && (s.charAt(i) == 'D' || s.charAt(i) == 'M') && s.charAt(i - 1) == 'C') {
				ans = ans - 200;
			}
		}
		return ans;
    }
}