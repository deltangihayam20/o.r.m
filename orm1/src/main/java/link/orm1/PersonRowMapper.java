package link.orm1;

import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonRowMapper implements RowMapper<Person>{

    @Override
    public Person mapRow(ResultSet resultSet , int i) throws SQLException{
        Person p = new Person();
        p.id = resultSet.getInt("id");
        p.name = resultSet.getString("name");
        p.email = resultSet.getString("email");
        return p;
    }
}
