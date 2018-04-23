package atul.algos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created by agosain on 4/15/18.
 */
public class IPv4SubnetAddress {
  private int address;
  private int netMask;
  
  public IPv4SubnetAddress(int address, int netMask){
    this.address = address;
    this.netMask = netMask;
  }
  
  public static boolean overlap(int address1, int netMask1, int address2, int netMask2){
    int minAddress1 = address1;
    int maxAddress1 = address1 |~netMask1;
  
    int minAddress2 = address2;
    int maxAddress2 = address2 |~netMask2;
  
    boolean firstInSecond = minAddress1<minAddress2 && maxAddress1>minAddress2 ||
                            minAddress1>minAddress2 && maxAddress1<maxAddress2 ||
                            minAddress1>minAddress2 && minAddress1<maxAddress2;
  
    boolean secondInFirst = minAddress2<minAddress1 && maxAddress2>minAddress1 ||
                            minAddress2>minAddress1 && maxAddress2<maxAddress1 ||
                            minAddress2>minAddress1 && minAddress2<maxAddress1;
    return firstInSecond || secondInFirst;
  }
  
  
}

class TestSubnet{
  
  @Test
  public void testOverlap(){
    int address1 = 0x0A000000;
    int netMask1 = 0xFF000000;
    
    int address2 = 0x0A010000;
    int netMask2 = 0xFF000000;
    
    Assertions.assertTrue(IPv4SubnetAddress.overlap(address1, netMask1, address2, netMask2));
  }
  
  @Test
  public void testOverlap2(){
    int address2 = 0x0A000000;
    int netMask2 = 0xFF000000;
    
    int address1 = 0x0A010000;
    int netMask1 = 0xFF000000;
    
    Assertions.assertTrue(IPv4SubnetAddress.overlap(address1, netMask1, address2, netMask2));
  }
  
}