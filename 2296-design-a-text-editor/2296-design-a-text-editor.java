class TextEditor {

    StringBuilder text;
    int cur;
    public TextEditor() {
        text = new StringBuilder();
        cur = 0;
    }
    
    public void addText(String text) {
        this.text.insert(cur, text);
        cur += text.length();
    }
    
    public int deleteText(int k) {
        int prev = cur;
        text.delete(Math.max(0,cur-k), cur);
        cur = Math.max(0, cur-k);
        return prev-cur;
    }
    
    public String cursorLeft(int k) {
        cur = Math.max(cur - k, 0);
        return text.substring(Math.max(0, cur-10), cur);
    }
    
    public String cursorRight(int k) {
        cur = Math.min(cur + k, text.length());
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