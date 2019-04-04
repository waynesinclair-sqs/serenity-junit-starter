package starter.steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.sql.*;

public class DatabaseSteps {
    Statement stmt;
    ResultSet result;

    @Step
    public void connectsTo(String DB_URL, String USER, String PASS) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        stmt = conn.createStatement();
    }

    @Step
    public void countWithSql(String sqlCount) throws SQLException {
        result = stmt.executeQuery(sqlCount);
    }

    @Step
    public void returnCountShouldEqual(int r) throws SQLException {
        int numrows = 0;
        if (result.next()) numrows = result.getInt(1);
        Assert.assertEquals("Row count does not match", numrows, r);
    }
}
