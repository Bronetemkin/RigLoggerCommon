package ru.hnm1nd.logger.connection;

import org.junit.jupiter.api.Test;
import ru.hnm1nd.base.connection.DataAccessAPI;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryDataAccessAPITest {

    @Test
    public void test() {
        InMemoryDataAccessAPI api = new InMemoryDataAccessAPI();
        testInit(api);
        System.out.println();
        testGet(api);
        System.out.println();
        testRemove(api);
    }

    private void testInit(DataAccessAPI api) {
        Map<String, Object> entry = new HashMap<>();
        entry.put("some", "kek");
        entry.put("some1", "kek1");
        api.insert("testObject", entry);

        Map<String, Object> entry1 = new HashMap<>();
        entry1.put("some", "kek3");
        entry1.put("some1", "kek3");
        api.insert("testObject", entry1);

        Map<String, Object> entry2 = new HashMap<>();
        entry2.put("some", "kek3");
        entry2.put("some1", "kek5");
        api.insert("testObject", entry2);
        System.out.println("Count result: " + api.count("testObject", new HashMap<>()));
    }

    private void testGet(DataAccessAPI api) {
        Map<String, Object> conditions = new HashMap<>();
        conditions.put("some", "kek3");
        System.out.println("Get count result: " + api.count("testObject", conditions));
        printValues(api.get("testObject", conditions));
    }

    private void testRemove(DataAccessAPI api) {
        Map<String, Object> conditions = new HashMap<>();
        conditions.put("some", "kek3");
        api.remove("testObject", conditions);
        System.out.println("Remove count result: " + api.count("testObject", new HashMap<>()));
        printValues(api.get("testObject", new HashMap<>()));
    }

    private static void printValues(List<Map<String, Object>> data) {
        for (Map<String, Object> some : data) {
            for (Map.Entry<String, Object> e : some.entrySet()) {
                System.out.println(e.getKey() + ": " + e.getValue());
            }
            System.out.println();
        }
    }

}
