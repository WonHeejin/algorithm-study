class BrowserHistory {

    LinkedList<String> link = new LinkedList<String>();
    int current = 0;
    public BrowserHistory(String homepage) {
        link.addFirst(homepage);
    }
    
    public void visit(String url) {
        //visit after 'back' or 'foward'
        for(int i=link.size()-1; i>current; i--) {
            link.removeLast();
        }
        ++current;
        link.add(url);
    }
    
    public String back(int steps) {
        current=current-steps<=0?0:current-steps;
        return link.get(current);
    }
    
    public String forward(int steps) {
        current=current+steps>=link.size()-1?link.size()-1:current+steps;
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