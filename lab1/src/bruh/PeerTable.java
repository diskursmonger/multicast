package bruh;

import java.util.HashMap;

public class PeerTable {
    private final HashMap<String, Long> table = new HashMap<>();

    public void add(String address) {
        table.put(address, System.currentTimeMillis());
    }

    public void delete(String address) {
        table.remove(address);
    }

    public HashMap<String, Long> getTable() {
        return table;
    }

    public void print() {
        for (var address: table.keySet()) {
            System.out.println(address + " " + (System.currentTimeMillis() - table.get(address)));
        }
    }
}
