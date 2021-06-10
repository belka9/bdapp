package ru.baburina.dbapp.app.services;

import ru.baburina.dbapp.db.repository.SQLRepository;

import java.util.List;
import java.util.Map;

public class SQLService {

    private final SQLRepository repository = new SQLRepository();

    public int getCount(String query) {
        return this.repository.getCount(query);
    }

    public List<Map<String, Object>> getItems(String query, int page, int pageSize) {
        return this.repository.performQuery(query, pageSize, page);
    }

}
