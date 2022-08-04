class Logger {

    Map<String, Integer> rateLimitter;
    public Logger() {
        rateLimitter = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(rateLimitter.containsKey(message)){
            if(rateLimitter.get(message) + 10 > timestamp){
                return false;
            }else{
                rateLimitter.put(message, timestamp);
                return true;
            }
        }else{
            rateLimitter.put(message, timestamp);
            return true;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */