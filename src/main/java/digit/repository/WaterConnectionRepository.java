package digit.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import digit.repository.querybuilder.WaterConnectionQueryBuilder;
import digit.repository.rowmapper.WaterConnectionRowMapper;
import digit.web.models.WaterConnection;
import digit.web.models.WaterConnectionSearchCriteria;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class WaterConnectionRepository {

    @Autowired
    private WaterConnectionQueryBuilder queryBuilder;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private WaterConnectionRowMapper rowMapper;

    public List<WaterConnection> getConnections(WaterConnectionSearchCriteria searchCriteria) {
        List<Object> preparedStmtList = new ArrayList<>();
        String query = queryBuilder.getWaterConnectionSearchQuery(searchCriteria, preparedStmtList);
        log.info("Final query: " + query);
        return jdbcTemplate.query(query, preparedStmtList.toArray(), rowMapper);
    }
}