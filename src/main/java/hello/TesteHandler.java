package hello;

import java.lang.reflect.Method;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.boot.actuate.endpoint.Endpoint;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

//@Component
public class TesteHandler extends RequestMappingHandlerMapping implements Endpoint {

	private static Logger logger = LogManager.getLogger("TesteHandler");

	RequestMappingInfo mappingGlobal;

	// @Override
	public void registerMapping(RequestMappingInfo mapping, Object handler, Method method) {
		logger.info("@@@ method: " + method.getName());
		super.registerMapping(mapping, handler, method);
	}

	@Override
	public String getId() {
		logger.warn("hehehehehehehheheheheheh");
		return "opw";
	}

	@Override
	public Object invoke() {
		logger.warn("ihihihihihihihihihihihi");
		return DynamicFactoryBean.createTesteWr();
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean isSensitive() {
		return false;
	}
}
