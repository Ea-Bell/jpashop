package jpabook.jpashop;

class Connetion {
    static private Connetion _inst = null;
    private int count = 0;

    static public Connetion get() {
        if (_inst == null) {
            _inst = new Connetion();
            return _inst;
        }
        return _inst;
    }

    public void count() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

public class test {
    public static void main(String[] args) {
        Connetion conn1 = Connetion.get();
        conn1.count();
        Connetion conn2 = Connetion.get();
        conn2.count();
        Connetion conn3 = Connetion.get();
        conn3.count();
        System.out.println(conn3.getCount());
        
    }
}
