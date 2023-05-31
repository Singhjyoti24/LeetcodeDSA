class MyLinkedList {

    List<Integer> list;
    public MyLinkedList() {
        list = new ArrayList<Integer>();
    }
    public int get(int index) {
        if(index >= list.size()){
            return -1;
        }
        return list.get(index);
    }
    public void addAtHead(int val) {
        list.add(0,val);
    }
    public void addAtTail(int val) {
        list.add(val);
    }
    public void addAtIndex(int index, int val) {
        if(index <= list.size()){
            list.add(index,val);
        }
    }
    public void deleteAtIndex(int index) {
        if(index < list.size()){
            list.remove(index);
        }
    }
}