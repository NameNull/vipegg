package vip.vipegg.controller.common;

import vip.vipegg.common.Constants;
import vip.vipegg.model.Admin;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yujie on 2017/8/18.
 * 招股金服
 */
public class BaseController {
    public Admin getSessionAdmin(HttpServletRequest request){
        return (Admin) request.getSession().getAttribute(Constants.Admin_SESSION);
    }
}
