class Node {
    String data;
    Node prev;
    Node next;
    public Node(String data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
class BrowserHistory {
    Node currentPage;
    public BrowserHistory(String homepage) {
        currentPage = new Node(homepage);
    }
    
    public void visit(String url) {
        Node newPage = new Node(url);
        newPage.prev = currentPage;
        currentPage.next = newPage;
        currentPage = newPage;
    }
    
    public String back(int steps) {
        while(steps-->0&&currentPage.prev!=null) {
            currentPage = currentPage.prev;
        }
        return currentPage.data;
    }
    
    public String forward(int steps) {
        while(steps-->0&&currentPage.next!=null) {
            currentPage = currentPage.next;
        }
        return currentPage.data;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */