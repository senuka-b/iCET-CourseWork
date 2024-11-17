class List {
    private Node start;
    
    class Node {
        Customer customer;
        Node next;

        Node(Customer customer) {
            this.customer = customer;
        }
    }

    public int add(Customer customer) {
        
        return add(size(), customer);
    }
    
    public int add(int index, Customer customer) {
        
        if (!(index >= 0 && index <= size())) return -1;
        
        if (isEmpty()) {
            start = new Node(customer);
            return 0;
        }
        
        if (index == 0) {
            Node newNode = new Node(customer);
            newNode.next = start;
            start = newNode;

            return 0;
        }
        
        Node newNode = new Node(customer);

        Node tempNode = start;
        int count = 0;

        while (count != index-1) {
            tempNode = tempNode.next;
            count++;
        }

        newNode.next = tempNode.next;
        tempNode.next = newNode;

        return index;

    }

    public Customer get(int index) {
        if (index < 0 || index >= size()) return null;

        Node tempNode = start;
        int count = 0;
        while (count != index) {
            tempNode = tempNode.next;
            count++;
        }

        return tempNode.customer;
    }

    public int set(int index, Customer customer) {

        if (isEmpty() || (index < 0 && index >= size())) return -1;

        Node newNode = new Node(customer);

        if (index == 0) {
            newNode.next = start.next;
            start = newNode;
            return 0;
        }

        Node temp = start;
        int count = 0;
        while (count != index-1) {
            temp = temp.next;
            count++;
        }

        newNode.next = temp.next.next;
        temp.next = newNode;

        return index;
    }

    public int search(Customer customer) {
        if (isEmpty()) return -1;

        Node tempNode = start;
        int index = 0;
        while (tempNode != null) {

            if (tempNode.customer.getCustomerID().equals(customer.getCustomerID())) {
                return index;
            }

            tempNode = tempNode.next;
            index++;
            
        }

        return -1;
    }

    public boolean isExists(Customer customer) {
        return search(customer) != -1;
    }

    public Customer remove(int index) {

        if (isEmpty()) return null;

        if (index == 0) {
            Customer customer = start.customer;

            start = start.next;
            return customer;
        }

        Node tempNode = start;
        int count = 0;
        while (count != index-1) {
            tempNode = tempNode.next;
            count++;
        }

        Customer customer = tempNode.next.customer;
        tempNode.next = tempNode.next.next;
        
        return customer;
    }

    public Customer remove(Customer customer) {
        int index = search(customer);

        if (index == -1) return null;

        return remove(index);
    }

    public void clear() {
        start = null;
    }

    public boolean isEmpty() {
        return start == null;
    }

    public int size() {

        int size = 0;

        Node temp = start;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        return size;
    }

    public String toString() {

        if (isEmpty()) return "[empty]";

        Node temp = start;

        String str = "[";

        while (temp != null) {
            str += temp.customer.toString() + " -- ";
            temp = temp.next;
        }

        str += "\b\b\b]";

        return str;


    }

    public Customer[] toArray() {
        int length = size();
        Customer[] array = new Customer[length];

        Node tempNode = start;
        for (int i = 0; i < array.length; i++) {
            array[i] = tempNode.customer;
            tempNode = tempNode.next;
        }

        return array;
    }

    public void printList() {
        System.out.println(toString());
    }

}
