class FashionShop {
    public static void main(String[] args) {

        // new HomeForm().setVisible(true);

        Customer c1 = new Customer("aaaa", new Order[]{new Order(0, "xs", 10, 0), new Order(0, "xs", 10, 0)});
        Customer c2 = new Customer("bbb", new Order[]{new Order(1, "sm", 20, 0)});
        Customer c3 = new Customer("cccc", new Order[]{new Order(2, "m", 30, 0)});
        Customer c4 = new Customer("ddddd", new Order[]{new Order(2, "m", 30, 0)});


        List l = new List();

        System.out.println(l.add(c1));
        System.out.println(l.add(c2));
        System.out.println(l.add(c3));
        System.out.println(l.add(c4));

        
        System.out.println(l);

        System.out.println(l.remove(2));

        System.out.println(l);
    }
    
}