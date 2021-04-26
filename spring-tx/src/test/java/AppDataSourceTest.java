import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class AppDataSourceTest {

    @Autowired
    DataSource ds;

    @Test
    public void dataSources() throws SQLException {
        Assert.assertNotNull(ds);
        System.out.println(ds.getConnection());
    }
}