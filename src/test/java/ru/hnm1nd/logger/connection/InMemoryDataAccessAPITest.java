package ru.hnm1nd.logger.connection;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import ru.hnm1nd.base.connection.DataAccessAPI;
import ru.hnm1nd.logger.model.FanInfo;
import ru.hnm1nd.logger.model.GPUInfo;
import ru.hnm1nd.logger.model.RigInfo;
import ru.hnm1nd.logger.model.TemperatureInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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

    @Test
    public void testClone() {
        RigInfo info = new RigInfo();
        GPUInfo gpuInfo = new GPUInfo();
        gpuInfo.setFanInfo(new FanInfo(new double[]{1}, new int[]{1}));
        gpuInfo.setTemperatureInfo(new TemperatureInfo(0));
        GPUInfo[] gpuInfos = new GPUInfo[]{gpuInfo};
        info.setGpus(gpuInfos);
        info.setId(UUID.randomUUID().toString());
        info.setStatus("KEK");
        Gson gson = new Gson();
        System.out.println(gson.toJson(info));
        System.out.println(info.toString());
        RigInfo cln = info.clone();
        System.out.println(gson.toJson(cln));
        System.out.println(cln.toString());
        System.out.println(info.toString());
    }

}
