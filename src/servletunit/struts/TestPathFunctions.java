package servletunit.struts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPathFunctions {

    @Test
    public void testStripSessionId() {
        String path = "/my/path;jsessionid=123456789";
        path = Common.stripJSessionID(path);
        assertEquals("/my/path",path);
    }

    @Test
    public void testStripLongSessionId() {
        String path = "/my/path;jsessionid=99999999999999999999999999999999999999999999999999999999999";
        path = Common.stripJSessionID(path);
        assertEquals("/my/path",path);
    }

    @Test // todo everywhere
    public void testStripSessionIdWithQueryString() {
        String path = "/my/path;jsessionid=123456789?param=\"true\"";
        path = Common.stripJSessionID(path);
        assertEquals("/my/path?param=\"true\"",path);
    }
}
