//  StrutsTestCase - a JUnit extension for testing Struts actions
//  within the context of the ActionServlet.
//  Copyright (C) 2002 Deryl Seale
//
//  This library is free software; you can redistribute it and/or
//  modify it under the terms of the Apache Software License as
//  published by the Apache Software Foundation; either version 1.1
//  of the License, or (at your option) any later version.
//
//  This library is distributed in the hope that it will be useful,
//  but WITHOUT ANY WARRANTY; without even the implied warranty of
//  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//  Apache Software Foundation Licens for more details.
//  You may view the full text here: http://www.apache.org/LICENSE.txt

package servletunit.struts.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMessage;

import servletunit.struts.MockStrutsTestCase;

public class TestMessageAction extends MockStrutsTestCase {

    public TestMessageAction(String testName) {
        super(testName);
    }

    public void setUp() throws Exception {
        super.setUp();
        setServletConfigFile("/WEB-INF/web.xml");
    }

    public void testNoMessages() {
        addRequestParameter("username","deryl");
        addRequestParameter("password","radar");
        setRequestPathInfo("/login");
        actionPerform();
        verifyForward("success");
        verifyForwardPath("/main/success.jsp");
        assertEquals("deryl",getSession().getAttribute("authentication"));
        verifyNoActionMessages();
    }

    public void testMessageExists() {
        setRequestPathInfo("test","/testActionMessages");
        actionPerform();
        verifyForward("success");
        verifyActionMessages(new String[] {"test.message"});
    }

     public void testMessageExistsExpectedNone() {
        setRequestPathInfo("test","/testActionMessages");
        actionPerform();
        verifyForward("success");
        assertThrows(Exception.class, () -> verifyNoActionMessages());
    }

    public void testMessageMismatch() {
        setRequestPathInfo("test","/testActionMessages");
        actionPerform();
        verifyForward("success");
        assertThrows(Exception.class, () -> verifyActionMessages(new String[] {"error.password.mismatch"}));
    }

    public void testExpectedMessagesNoneExist() {
        addRequestParameter("username","deryl");
        addRequestParameter("password","radar");
        setRequestPathInfo("/login");
        actionPerform();
        verifyForward("success");
        verifyForwardPath("/main/success.jsp");
        assertEquals("deryl",getSession().getAttribute("authentication"));
        assertThrows(Exception.class, () -> verifyActionMessages(new String[] {"test.message"}));
    }

    public void testVerifiesComplexErrorMessageScenario() {
        ActionErrors errors = new ActionErrors();
        errors.add("error1",new ActionMessage("error1"));
        errors.add("error2",new ActionMessage("error2"));
        errors.add("error1",new ActionMessage("error1"));
        getRequest().setAttribute(Globals.ERROR_KEY,errors);
        assertThrows(Exception.class, () -> verifyActionErrors(new String[] {"error1","error2","error2"}));
    }

}