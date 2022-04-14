package receipts;

import warehouse.Supply;

import java.util.Deque;
import java.util.HashMap;

public interface Receipts {
    String print(HashMap<String, Deque<Supply>> receipt);
}
