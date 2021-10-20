public class BitwiseOperators {

  public void explanation() {
    //source: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op3.html
    int val = 200;
    System.out.println("\nBitshift left: Shifts bit pattern left by adding a 0 to the right side.");
    int i = val << 1; // bitshift left. Equivalent to val*2.
    System.out.println(Integer.toBinaryString(i));
    System.out.println(i);
    int e = val << 2; // equivalent to val(2*2)
    System.out.println(Integer.toBinaryString(e));
    System.out.println(e);
    int j = val << 3; // equivalent to val(2*2*2)
    System.out.println(Integer.toBinaryString(j));
    System.out.println(j);
    int o = val << 4; // equivalent to val(2*2*2*2)
    System.out.println(Integer.toBinaryString(o));
    System.out.println(o);
    int p = val << 5; // equivalent to val(2*2*2*2*2)
    System.out.println(Integer.toBinaryString(p));
    System.out.println(p);

    System.out.println("\nBitshift right: Shifts bit pattern right by removing a 0 from the right side.");
    int v = p >> 1; //equivalent to val/2
    System.out.println(Integer.toBinaryString(v));
    System.out.println(v);
    int vo = p >> 2; //equivalent to val/(2*2)
    System.out.println(Integer.toBinaryString(vo));
    System.out.println(vo);

    System.out.println("\nUnsigned right shift operator: Not sure what this does exactly or why it's useful.");
    System.out.println(Integer.toBinaryString(-400 >>> 1));
    System.out.println(-400 >>> 1);
    System.out.println(Integer.toBinaryString(-400 >>> 2));
    System.out.println(-400 >>> 2);

    System.out.println("\nUnary bitwise complement operator: Inverts bit patterns. 00000 becomes 11111");
    int no = ~p;
    System.out.println(Integer.toBinaryString(no));
    System.out.println(no);
  }
}
