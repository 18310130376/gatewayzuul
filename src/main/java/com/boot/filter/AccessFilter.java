package com.boot.filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 *抽象类和接口的区别
 * */
@Component
public class AccessFilter extends ZuulFilter {
	
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {//过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
		 RequestContext ctx = RequestContext.getCurrentContext();
         HttpServletRequest request = ctx.getRequest();
         Object accessToken = request.getParameter("accessToken");
         if(accessToken == null) {
             ctx.setSendZuulResponse(false);
             ctx.setResponseStatusCode(401);
             return null;
         }
         return null;
	}

	@Override
	public String filterType() {
		return "pre";//路由之前 routing：路由之时 post： 路由之后 error：发送错误调用
	}

	@Override
	public int filterOrder() {
		return 0;
	}

}
