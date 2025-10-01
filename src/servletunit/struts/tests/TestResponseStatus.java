package servletunit.struts.tests;

import static org.junit.jupiter.api.Assertions.assertThrows;

import servletunit.struts.MockStrutsTestCase;

/**
 * Created by IntelliJ IDEA.
 * User: deryl
 * Date: May 20, 2003
 * Time: 5:16:57 PM
 * To change this template use Options | File Templates.
 */
public class TestResponseStatus extends MockStrutsTestCase {

    public TestResponseStatus(String testName) {
        super(testName);
    }

    public void setUp() throws Exception {
        super.setUp();
        setServletConfigFile("/WEB-INF/web.xml");
    }

    public void testResponseCode() {
        setRequestPathInfo("/badActionPath");
        assertThrows(Exception.class, () -> actionPerform());
    }


}
