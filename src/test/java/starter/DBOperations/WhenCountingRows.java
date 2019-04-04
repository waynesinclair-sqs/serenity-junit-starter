package starter.DBOperations;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.Steps;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import starter.steps.DatabaseSteps;
import starter.steps.MathWizSteps;

import java.sql.SQLException;

@RunWith(SerenityRunner.class)
@Narrative(text={"Inserting into Database."})
public class WhenCountingRows {

    final String DB_URL = "jdbc:sqlite:C:\\SQLliteDatabases\\chinook.db";
    final String USER = "";
    final String PASS = "";

    @Steps
    DatabaseSteps counter;
//    String sqlInsert = "insert into artists (Name, ArtistId)" + Overall Test Results
// Requirements
// Features
// Stories
// Report generated 04-04-2019 10:59
//                        "values (\"The Breaks286\", 286)";

 String sqlCount = "select count(*) from albums";

    @Test
    public void connectingToDB() throws SQLException {
        // Given
        counter.connectsTo(DB_URL ,USER,PASS);

        // When
        System.out.println("sqlCount is: " + sqlCount);
        counter.countWithSql(sqlCount);

        // Then
        counter.returnCountShouldEqual(359  );
    }
}