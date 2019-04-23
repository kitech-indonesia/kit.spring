/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.kit.spring.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;
import id.kit.spring.vo.VoDetail;
import id.kit.spring.vo.VoHeader;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import id.kit.spring.service.KitService;

/**
 *
 * @author kit
 */
@SqlGroup(
        {
            @Sql(
                    executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD,
                    scripts = {"data/KitSqlBefore.sql"}
            ),
            @Sql(
                    executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD,
                    scripts = {"data/KitSqlAfter.sql"}
            )
        }
)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:mvc-dispatcher-servlet.xml")
@WebAppConfiguration
public class KitTest {

    @Autowired
    @Qualifier(value = "kitService")
    private KitService kitService;

    @Autowired
    private DataSource ds;

    public KitTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

//     TODO add test methods here.
//     The methods must be annotated with annotation @Test. For example:
    @Test
    public void hello() throws SQLException {
        VoHeader voHeader = new VoHeader();
        voHeader.setId("HDRTEST");
        voHeader.setTgl("22-Feb-2013");
        voHeader.setDetails(new ArrayList<VoDetail>());
        VoHeader voHeader1 = kitService.saveHeader(voHeader);
        Assert.assertEquals("HDRTEST", voHeader1.getId());
        String sql = "select count(id) jumlah from header where id = 'HDRTEST' ";
        Connection c = ds.getConnection();
        ResultSet rs = c.createStatement().executeQuery(sql);
        Assert.assertTrue(rs.next());
        Long jumlahRow = rs.getLong("jumlah");
        Assert.assertEquals(1L, jumlahRow.longValue());
        c.close();
    }
}
