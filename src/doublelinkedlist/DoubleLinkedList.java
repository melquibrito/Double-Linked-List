package doublelinkedlist;

public class DoubleLinkedList<T extends Item> {

    public T getPrevious(int index) {
        T t = null;
        if(index > 0) {
            return getElement(index).previous.object;
        }
        return t;
    }

    public class Element {

        Element(Element previous, T object, Element next) {
            this.object = object;
            this.next = next;
        }

        T object;
        Element previous, next;
    }
    private Element first = null;

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        int size = 0;
        if (!isEmpty()) {
            Element node = first;
            while (node != null) {
                size++;
                node = node.next;
            }
        }
        return size;
    }
    
    public synchronized void add(T object) {
        Element added = new Element(null, object, null);
        if (!isEmpty()) {
            int index = 0;
            Element node = first;
            while (node != null) {
                if (object.compareTo(node.object) < 0) {
                    break;
                }
                node = node.next;
                index++;
            }
            if (index == 0) {
                added.next = first;
                first.previous = added;
                first = added;
            } else {
                added.next = node;
                added.previous = getElement(index - 1);
                if(node != null) {
                    node.previous = added;
                }
                getElement(index - 1).next = added;
                
            }
        } else {
            first = added;
        }
    }
    
    
    
    public T get(String keyword) {
        if(!isEmpty()) {
            Element node = first;
            while (node != null) {
                if (keyword.equalsIgnoreCase(node.object.key()) || keyword.equalsIgnoreCase(node.object.toString())) {
                   return node.object; 
                }
                node = node.next;
            }
        }
        return null;
    }
    
    public Element getElement(int index) {
        if (!isEmpty()) {
            if (index == 0) {
                return first;
            } else {
                Element node = first;
                for (int i = 1; i < this.size(); i++) {
                    node = node.next;
                    if (i == index) {
                        return node;
                    }
                }
            }
        }
        return null;
    }
    
    public boolean remove(String key) {
        if(!isEmpty()) {
            Element node = first;
            while (node != null) {
                if(node.object.key().equalsIgnoreCase(key)) {
                    if(node == first) {
                        node.next.previous = null;
                        first = node.next;
                    }else{
                        node.previous.next = node.next;
                    }
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }
    
    public boolean contains(String keyword) {
        if(!isEmpty()) {
            Element node = first;
            while (node != null) {
                if (keyword.equalsIgnoreCase(node.object.key()) || keyword.equalsIgnoreCase(node.object.toString())) {
                   return true; 
                }
                node = node.next;
            }
        }
        return false;
    }
    
    @Override
    public String toString() {
        String list = "[Empty]";
        if(!isEmpty()) {
            list = "[" + first.object;
            if(this.size() > 1) {
                for(int i = 1; i < this.size(); i++) {
                    list = list + ", " + getElement(i).object;
                }
            }
            list = list + "]";
        }
        return list;
    }
    
}
