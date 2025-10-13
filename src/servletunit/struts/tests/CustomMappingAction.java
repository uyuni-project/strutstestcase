package servletunit.struts.tests;

import org.apache.struts.action.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomMappingAction extends Action {

    public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws Exception {
        if (actionMapping instanceof RequestActionMapping) {
            return actionMapping.findForward("success");
        }
        else
            return actionMapping.findForward("failure");
    }

}

