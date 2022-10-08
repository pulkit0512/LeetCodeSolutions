class FileSystem {
    class Data {
        Map<String, Data> subDirs; // Contains info about all subdirectories for current key directory.
        Map<String, String> fileMap; // Contains info about all fileNames and their content present in current dir.
        
        public Data() {
            subDirs = new HashMap<>();
            fileMap = new HashMap<>();
        }
    }

    Data root;
    public FileSystem() {
        root = new Data();
        root.subDirs.put("", new Data());
    }
    
    public List<String> ls(String path) {
        String[] dirs = path.split("/");
        Data curDir = root;
        
        for(int i=0;i<dirs.length-1;i++){
            curDir = curDir.subDirs.get(dirs[i]);
        }
        
        String last = dirs.length==0? "" : dirs[dirs.length-1];
        
        return getResult(curDir, last);
    }
    
    private List<String> getResult(Data curDir, String last) {
        if(curDir.fileMap.containsKey(last)){
            return Arrays.asList(last);
        }else{
            curDir = curDir.subDirs.get(last);
            List<String> lsContent = new ArrayList<>();
            
            for(String file:curDir.fileMap.keySet()){
                lsContent.add(file);
            }
            
            for(String subDir:curDir.subDirs.keySet()){
                lsContent.add(subDir);
            }
            
            lsContent.sort(Comparator.naturalOrder());
            return lsContent;
        }
    }
    
    public void mkdir(String path) {
        String[] dirs = path.split("/");
        
        mkdirUtil(dirs, dirs.length);
    }
    
    private Data mkdirUtil(String[] dirs, int length) {
        Data curDir = root;
        for(int i=0;i<length;i++) {
            if(!curDir.subDirs.containsKey(dirs[i])){
                curDir.subDirs.put(dirs[i], new Data());
            }
            
            curDir = curDir.subDirs.get(dirs[i]);
        }
        
        return curDir;
    }
    
    public void addContentToFile(String filePath, String content) {
        String[] dirs = filePath.split("/");
        
        Data curDir = mkdirUtil(dirs, dirs.length-1);
        String fileName = dirs[dirs.length-1];
        
        curDir.fileMap.put(fileName, curDir.fileMap.getOrDefault(fileName, "") + content);
    }
    
    public String readContentFromFile(String filePath) {
        String[] dirs = filePath.split("/");
        Data curDir = root;
        
        for(int i=0;i<dirs.length-1;i++){
            curDir = curDir.subDirs.get(dirs[i]);
        }
        return curDir.fileMap.get(dirs[dirs.length-1]);
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */