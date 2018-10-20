package hello;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class DynamicArgumentResolver implements HandlerMethodArgumentResolver {

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		System.out.println("-------------------- NUOSSA ----------------");
		if (parameter.getParameterIndex() == 0) {
			return parameter.getParameterType().equals(String.class);
		} else {
			return true; // parameter.getParameterType().equals(java.lang.Object[]);
		}
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		System.out.println(" OPA -------------------- NUOSSA ----------------");
		if (parameter.getParameterIndex() == 0) {
			return new String("ruleName");
		} else {
			return null;
		}
	}
}