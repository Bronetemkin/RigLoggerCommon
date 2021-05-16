package ru.hnm1nd.logger.connection;

import ru.hnm1nd.base.connection.DataAccessAPI;
import ru.hnm1nd.base.utils.EntityMapper;

import java.util.*;
import java.util.stream.Collectors;

public class InMemoryDataAccessAPI implements DataAccessAPI {

    private Map<String, List<Map<String, Object>>> data = new HashMap<>();

    @Override
    public List<Map<String, Object>> get(String objectType, Map<String, Object> conditions, String... selectableFields) {
        List<Map<String, Object>> result;

        if (!this.data.containsKey(objectType)) return Collections.emptyList();
        if (conditions.size() > 0) {
            List<Map<String, Object>> data = this.data.get(objectType);
            List<Integer> index = findElementByCondition(data, conditions, false);
            result = new ArrayList<>();
            for (int i : index) {
                result.add(data.get(i));
            }
        } else {
            result = this.data.get(objectType);
        }

        return result;
    }

    @Override
    public <T> List<T> get(String objectType, Map<String, Object> conditions, EntityMapper<T> mapper, String... selectableFields) {
        return get(objectType, conditions, selectableFields).stream().map(e -> mapper.map(e, 0)).collect(Collectors.toList());
    }

    @Override
    public int insert(String objectType, Map<String, Object> data) {
        List<Map<String, Object>> objectList;
        if (!this.data.containsKey(objectType)) {
            objectList = new ArrayList<>();
        } else {
            objectList = this.data.get(objectType);
        }
        objectList.add(data);
        this.data.put(objectType, objectList);
        return 1;
    }

    @Override
    public int update(String objectType, Map<String, Object> data, Map<String, Object> conditions) {
        if (!this.data.containsKey(objectType)) return 0;
        if (conditions.size() > 0) {
            List<Map<String, Object>> dbData = this.data.get(objectType);
            List<Integer> indexes = findElementByCondition(dbData, conditions, false);
            indexes.sort((o1, o2) -> o2 - o1);
            for (int index : indexes) {
                dbData.set(index, data);
            }
            this.data.put(objectType, dbData);
            return indexes.size();
        } else {
            int size = this.data.get(objectType).size();
            this.data.put(objectType, new ArrayList<>());
            return size;
        }
    }

    @Override
    public int remove(String objectType, Map<String, Object> conditions) {
        if (!this.data.containsKey(objectType)) return 0;
        if (conditions.size() > 0) {
            List<Map<String, Object>> data = this.data.get(objectType);
            List<Integer> indexes = findElementByCondition(data, conditions, false);
            indexes.sort((o1, o2) -> o2 - o1);
            for (int index : indexes) {
                data.remove(index);
            }
            this.data.put(objectType, data);
            return indexes.size();
        } else {
            int size = this.data.get(objectType).size();
            this.data.put(objectType, new ArrayList<>());
            return size;
        }
    }

    @Override
    public long count(String objectType, Map<String, Object> conditions) {
        if (!this.data.containsKey(objectType)) return 0;
        if (conditions.size() > 0) {
            List<Map<String, Object>> data = this.data.get(objectType);
            return findElementByCondition(data, conditions, false).size();
        } else {
            return this.data.get(objectType).size();
        }
    }

    @Override
    public Object getDriver() {
        return data;
    }

    private int findElementByCondition(List<Map<String, Object>> data, Map<String, Object> conditions) {
        List<Integer> result = findElementByCondition(data, conditions, true);
        return result.size() > 0 ? result.get(0) : -1;
    }

    private List<Integer> findElementByCondition(List<Map<String, Object>> data, Map<String, Object> conditions, boolean findOnlyFirst) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            Map<String, Object> entity = data.get(i);
            boolean conditionsProceeded = true;
            for (Map.Entry<String, Object> entry : conditions.entrySet()) {
                if (entity.containsKey(entry.getKey())) {
                    if (!(
                            (entity.get(entry.getKey()) == null &&  entry.getValue() == null) ||
                                    entity.get(entry.getKey()).equals(entry.getValue()))) {
                        conditionsProceeded = false;
                        break;
                    }
                } else {
                    conditionsProceeded = false;
                    break;
                }
            }
            if (conditionsProceeded) {
                if (findOnlyFirst) {
                    return Collections.singletonList(i);
                } else {
                    result.add(i);
                }
            }
        }
        return result;
    }


}
