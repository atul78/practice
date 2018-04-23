package atul.algos;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class MACTable {
    // Mapping of mac address to port
    private Map<String, String> fib ;

    public MACTable(){
       fib = new ConcurrentHashMap<>();
    }

    public void addEntry(String mac_address, String port_id) throws ConflictException, ValueNotSupportedException{
        if(port_id==null || mac_address==null)
            throw new ValueNotSupportedException("Unable to add an entry. null not supported");
        String value = fib.get(mac_address);
        if(fib.containsValue(port_id))
            throw new RuntimeException("Port already mapped");
        if(value == null)
           fib.put(mac_address, port_id);
        else if(!value.equals(port_id))
           throw new ConflictException("Conflict: Mapping for MAC Address: "+mac_address+" already exists.");
    }

    public void remEntry(String mac_address){
        if(mac_address==null)
            throw new ValueNotSupportedException();
        if(fib.containsKey(mac_address))
            fib.remove(mac_address);
    }

    // Returns null if no mapping found.
    public String lookupEntry(String mac_address){
        if(mac_address==null)
            throw new ValueNotSupportedException();
        return fib.getOrDefault(mac_address, null);
    }
    
}

class ConflictException extends RuntimeException{
    public ConflictException(String message){
        super(message);
    }
}

class ValueNotSupportedException extends RuntimeException{
    public ValueNotSupportedException(){
        super("Value not supported");
    }

    public ValueNotSupportedException(String message){
        super(message);
    }
}

class TestMACTable{
    MACTable table ;

    @BeforeEach
    public void setup(){
       table = new MACTable();
    }

    @Test
    public void testAddEntry(){
       String mac_address = "00:14:21:54:33:22";
       String port_id = "fe/1";
       table.addEntry(mac_address, port_id);
    }

    @Test
    public void testAddEntryIdemp(){
        String mac_address = "00:14:21:54:33:22";
        String port_id = "fe/1";
        table.addEntry(mac_address, port_id);

        table.addEntry(mac_address, port_id);
        Assertions.assertEquals(port_id, table.lookupEntry(mac_address));
    }

    @Test
    public void testAddEntryWithConflict(){
       String mac_address = "00:14:21:31:54:33:22";
       String port_id = "fe/1";
       table.addEntry(mac_address, port_id);

       // Test conflict
       Executable executable = ()-> table.addEntry(mac_address, "fe/2");
       Assertions.assertThrows(ConflictException.class, executable);
    }

    @Test
    public void testLookupEntry(){
        String mac_address = "00:14:21:31:54:33:22";
        String port_id = "fe/1";
        table.addEntry(mac_address, port_id);

        String port_lookup = table.lookupEntry(mac_address);
        Assertions.assertEquals(port_id, port_lookup);
    }

    @Test
    public void testLookupEntryNotFound(){
        String mac_address = "00:14:21:31:54:33:22";
        String port_id = "fe/1";
        table.addEntry(mac_address, port_id);

        String mac_address_2 = "00:14:21:31:54:33:21";
        Assertions.assertNull(table.lookupEntry(mac_address_2));
    }

    @Test
    public void testRemovePresent(){
        String mac_address = "00:14:21:31:54:33:22";
        String port_id = "fe/1";
        table.addEntry(mac_address, port_id);

        table.remEntry(mac_address);

        Assertions.assertNull(table.lookupEntry(mac_address));
    }

    @Test
    public void testRemoveIdemp(){
        String mac_address = "00:14:21:31:54:33:22";
        String port_id = "fe/1";
        table.addEntry(mac_address, port_id);

        table.remEntry(mac_address);

        Assertions.assertNull(table.lookupEntry(mac_address));

        table.remEntry(mac_address);
    }

}
