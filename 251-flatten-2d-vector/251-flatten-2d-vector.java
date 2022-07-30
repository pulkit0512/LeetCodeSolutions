class Vector2D {

    int[][] vec;
    int i, j;
    public Vector2D(int[][] vec) {
        this.vec = vec;
        i = 0;
        j = 0;
    }
    
    public int next() {
        nextStep();
        return vec[i][j++];
    }
    
    public boolean hasNext() {
        nextStep();
        return i<vec.length;
    }
    
    private void nextStep() {
        while(i<vec.length && j==vec[i].length){
            i++;
            j=0;
        }
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */