package dao.sql;

import dao.SqlDAO;
import model.GoodType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by comp on 03.09.2017.
 */
@Repository
public class SqlDAOImpl implements SqlDAO {
    private static final RowMapper ROW_MAPPER= BeanPropertyRowMapper.newInstance(GoodType.class);
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public SqlDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<GoodType> getGoodTypesWithMoreThan5Models() {
        return jdbcTemplate.query("SELECT y.id ,y.typeName FROM (" +
                        "SELECT COUNT(x.id) AS cnt, goodtypes.typeName AS typeName, x.typeId AS id FROM inputdevices AS x JOIN goodtypes WHERE goodtypes.id=x.typeId " +
                        "UNION "+
                        "SELECT COUNT(x.id) AS cnt,goodtypes.typeName AS typeName, x.typeId AS id FROM components AS x JOIN goodtypes WHERE goodtypes.id=x.typeId " +
                        "UNION "+
                        "SELECT COUNT(x.id) AS cnt,goodtypes.typeName AS typeName, x.typeId AS id FROM monitors AS x JOIN goodtypes WHERE goodtypes.id=x.typeId " +
                        "UNION "+
                        "SELECT COUNT(x.id) AS cnt,goodtypes.typeName AS typeName, x.typeId AS id FROM storagedevices AS x JOIN goodtypes WHERE goodtypes.id=x.typeId " +
                        "UNION "+
                        "SELECT COUNT(x.id) AS cnt,goodtypes.typeName AS typeName, x.typeId AS id FROM peripheraldevices AS x JOIN goodtypes WHERE goodtypes.id=x.typeId " +
                        ") y WHERE y.cnt>=5 ORDER BY y.id"
                ,ROW_MAPPER);
    }
}
