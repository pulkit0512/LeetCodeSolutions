class Vector2D {

    int[][] vec;
    int i, j;
    public Vector2D(int[][] vec) {
        this.vec = vec;
        i = 0;
        j = 0;
    }
    
    public int next() {
        while(i<vec.length-1 && j==vec[i].length){
            i++;
            j=0;
        }
        return vec[i][j++];
    }
    
    public boolean hasNext() {
        while(i<vec.length && j==vec[i].length){
            i++;
            j=0;
        }
        return (i<vec.length)?true:false;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */