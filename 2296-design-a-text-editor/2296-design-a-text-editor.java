class TextEditor {

    StringBuilder text;
    int cur;
    public TextEditor() {
        text = new StringBuilder();
        cur = 0;
    }
    
    public void addText(String text) {
        String last = this.text.substring(cur);
        this.text.delete(cur, this.text.length());
        this.text.append(text).append(last);
        cur = cur + text.length();
        //System.out.println(this.text+" ADD "+cur);
    }
    
    public int deleteText(int k) {
        int prev = cur;
        text.delete(Math.max(0,cur-k), cur);
        cur = Math.max(0, cur-k);
        //System.out.println(text+" DELETE "+cur);
        return prev-cur;
    }
    
    public String cursorLeft(int k) {
        cur = Math.max(cur - k, 0);
        //System.out.println(text+" CL "+cur);
        return text.substring(Math.max(0, cur-10), cur);
    }
    
    public String cursorRight(int k) {
        cur = Math.min(cur + k, text.length());
        //System.out.println(text+" CR "+cur);
       return text.substring(Math.max(0, cur-10), cur);
    }
}

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */