class Solution {
    public String nextClosestTime(String time) {
        int num[] = new int[4];
        num[0] = time.charAt(0)-'0';
        num[1] = time.charAt(1)-'0';
        num[2] = time.charAt(3)-'0';
        num[3] = time.charAt(4)-'0';
        Arrays.sort(num);
        char ch[] = new char[5];
        ch[0] = (char)(num[0]+'0');
        ch[1] = (char)(num[0]+'0');
        ch[2] = ':';
        ch[3] = (char)(num[0]+'0');
        ch[4] = (char)(num[0]+'0');
        char temp = help(time, num, 4);
        if(temp!='x'){
            ch[4] = temp;
            ch[0] = time.charAt(0);
            ch[1] = time.charAt(1);
            ch[3] = time.charAt(3);
            return String.valueOf(ch);
        }
        temp = help(time, num, 3);
        if(temp!='x'){
            ch[3] = temp;
            ch[0] = time.charAt(0);
            ch[1] = time.charAt(1);
            return String.valueOf(ch);
        }
        temp = help(time, num, 1);
        if(temp!='x'){
            ch[1] = temp;
            ch[0] = time.charAt(0);
            return String.valueOf(ch);
        }
        temp = help(time, num, 0);
        if(temp!='x'){
            ch[0] = temp;
            return String.valueOf(ch);
        }
        return String.valueOf(ch);
    }
    
    private char help(String time, int num[], int idx){
        int val = time.charAt(idx) - '0';
        int temp = val;
        for(int i=0;i<4;i++){
            if(val<num[i]){
                temp = num[i];
                break;
            }
        }
        if(temp==val){
            return 'x';
        }
        if(idx==3 && temp>=6){
            return 'x';
        }
        if(idx==1 && time.charAt(0)=='2' && temp>=4){
            return 'x';
        }
        if(idx==0 && temp>=3){
            return 'x';
        }
        return (char)(temp + '0');
    }
}