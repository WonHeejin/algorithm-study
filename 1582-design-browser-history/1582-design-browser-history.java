class BrowserHistory {

    LinkedList<String> link = new LinkedList<String>();
    int current = 0;
    public BrowserHistory(String homepage) {
        link.addFirst(homepage);
    }
    
    public void visit(String url) {
        //visit after 'back' or 'foward'
        while(link.size()-1>current) {
            link.removeLast();
        }
        ++current;
        link.add(url);
    }
    
    public String back(int steps) {
        current=Math.max(current-steps,0);
        return link.get(current);
    }
    
    public String forward(int steps) {
        current=Math.min(current+steps,link.size()-1);
        return link.get(current);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */