package node;

public class Node <E>{
    private Node <E> next=null;
    private E elem;

    public Node(E elem) {
        this.elem=elem;
    }

    public Node(E elem, Node <E> next) {
        this.elem=elem;
        this.next=next;
    }

    public Node <E> next ()    {
        return this.next;
    }

    public E getElem() {
        return this.elem;
    }

    public void setNext (Node<E> next) {
        this.next=next;
    }

    public void setElem(E elem){
        this.elem = elem;
    }

    public E element(){
        return elem;
    }
}
