package hello;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.esfinge.aom.api.model.IEntity;
import org.esfinge.aom.api.model.IEntityType;
import org.esfinge.aom.api.model.IPropertyType;
import org.esfinge.aom.model.dynamic.factory.AdapterFactory;
import org.esfinge.aom.model.impl.CalculaAnos;
import org.esfinge.aom.model.impl.GenericEntityType;
import org.esfinge.aom.model.impl.GenericPropertyType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableAutoConfiguration

@Configuration
public class Application extends WebMvcConfigurerAdapter {
	
	static Object testeDyn1;

	// public static void main(String[] args) {
	// SpringApplication.run(Application.class, args);
	// }

	// @Autowired
	// TesteHandler registrador;
	
//	@Autowired
//	MeuBeanRegistration meuBeanRegistration;

	//static DispatcherServlet dispatcherServlet;

//	public MeuBeanRegistration getMeuBeanRegistration() {
//		return meuBeanRegistration;
//	}


//	public void setMeuBeanRegistration(MeuBeanRegistration meuBeanRegistration) {
//		this.meuBeanRegistration = meuBeanRegistration;
//	}

	private static String[] args;
	public static ConfigurableApplicationContext context;

	public static void main(String[] args) {
		Application.args = args;
		Application.context = SpringApplication.run(Application.class, args);
		//new InitHelloWorld();
		// try {
		// // startJettyServer(8382);
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//testeDyn1 = createTesteWr();
	}
	
	@Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new DynamicArgumentResolver());
    }

	public void createDynamicBean(Object dynamicClass) {
		
//		meuBeanRegistration.setDynamicClass(dynamicClass);
//		AutowireCapableBeanFactory factory = null;
//		factory = context.getAutowireCapableBeanFactory();
//		BeanDefinitionRegistry registry = (BeanDefinitionRegistry) factory;
//		GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
//		beanDefinition.setBeanClass(dynamicClass.getClass());
//		beanDefinition.setAutowireCandidate(true);
//		registry.registerBeanDefinition("testeWr", beanDefinition);
//		factory.autowireBeanProperties(dynamicClass, AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE, false);
	}
	

	public static Object createTesteWr() {
		try {
			AdapterFactory af = AdapterFactory.getInstance("AnnotationMapping.json");

			IEntityType tipoProduto = new GenericEntityType("ProdutoNovo1");

			// criando property types
			IPropertyType dataNascPropertyType = new GenericPropertyType("dataFabricacao", Date.class);
			IPropertyType nomePropertyType = new GenericPropertyType("nome", String.class);

			Map<String, String[]> nomeDoServico = new HashMap<String, String[]>();
			String[] nomeEndPoint = new String[1];
			nomeEndPoint[0] = "verdade3";
			nomeDoServico.put("value", nomeEndPoint);

			nomePropertyType.setProperty("requestmapping", nomeDoServico);

			// adicionando property types no tipo de entidade
			tipoProduto.addPropertyType(dataNascPropertyType);
			tipoProduto.addPropertyType(nomePropertyType);
			tipoProduto.addOperation("anosFabricacao", new CalculaAnos("dataFabricacao"));

			// Essas anotações devem ser adicionadas na rule
			tipoProduto.setProperty("ruleClass", true);
			nomePropertyType.setProperty("ruleObject", true);

			GregorianCalendar dataFabr = new GregorianCalendar();
			dataFabr.set(2010, 11, 23);
			Map<String, Object> parametersSubstring = new HashMap<String, Object>();
			parametersSubstring.put("dataFabricacao", "2016");
			parametersSubstring.put("perecivel", true);
			nomePropertyType.setProperty("ruleAttribute", parametersSubstring);

			tipoProduto.setProperty("restcontroller", true);

			IEntity produto = tipoProduto.createNewEntity();
			produto.setProperty("nome", "Notebook DELL");
			produto.setProperty("dataFabricacao", dataFabr.getTime());

			return af.generate(produto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	public static void restart() {
		// close previous context
		context.close();

		// and build new one
		Application.context = SpringApplication.run(Application.class, args);
	}

	// public static void inicializarBean(Object bean, String name) {
	// context.getBeanFactory().initializeBean(bean, name);
	// }
	//
	// public void registrar(String name, Object objeto, Method method) {
	// registrador.registerMapping(null, objeto, method);
	// }

	@RequestMapping(value = "/testes")
	public void refreshCtx(String packageName) throws Exception {
//		AnnotationConfigWebApplicationContext context = (AnnotationConfigWebApplicationContext) dispatcherServlet
//				.getWebApplicationContext();
//		context.scan(packageName);
//		context.refresh();
		//dispatcherServlet.init();
	}

//	private static ServletContextHandler getServletContextHandler() throws IOException {
//		ServletContextHandler servletContextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
//
//		servletContextHandler.setResourceBase(new ClassPathResource(WEB_DIR).getURI().toString());
//		servletContextHandler.setContextPath(SOME_PATH);
//
//		AnnotationConfigWebApplicationContext webAppContext = new AnnotationConfigWebApplicationContext();
//		webAppContext.setConfigLocations(SOME_PACKAGE);
//		dispatcherServlet = new DispatcherServlet(webAppContext);
//
//		ServletHolder springServletHolder = new ServletHolder("Verones", dispatcherServlet);
//		servletContextHandler.addServlet(springServletHolder, SOME_URL);
//		servletContextHandler.addEventListener(new ContextLoaderListener(webAppContext));
//
//		return servletContextHandler;
//	}

//	private static void startJettyServer(int port) throws Exception {
//		Server server = new Server(port);
//
//		server.setHandler(getServletContextHandler());
//
//		server.start();
//		server.join();
//	}
//
//	@Bean
//	public static Endpoint exampleEndpoint() {
//		return new Endpoint<String>() {
//			@Override
//			public String getId() {
//				return "example";
//			}
//
//			@Override
//			public boolean isEnabled() {
//				return true;
//			}
//
//			@Override
//			public boolean isSensitive() {
//				return false;
//			}
//
//			@Override
//			public String invoke() {
//				return "example";
//			}
//		};
//	}

	// @RestController
	// @RefreshScope
	// class ExampleController {
	//
	// @Value("${foo.bar}")
	// private String value;
	//
	// @RequestMapping
	// public String sayValue() {
	// try {
	// refreshCtx("hello");
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return value;
	// }
	// }
}
//
// class InitHelloWorld implements BeanPostProcessor {
//	   public Object postProcessBeforeInitialization(Object bean, String beanName) 
//	      throws BeansException {
//	      
//	      System.out.println("BeforeInitialization : " + beanName);
//	      return bean;  // you can return any other object as well
//	   }
//	   public Object postProcessAfterInitialization(Object bean, String beanName) 
//	      throws BeansException {
//	      
//	      System.out.println("AfterInitialization : " + beanName);
//	      return bean;  // you can return any other object as well
//	   }
//	}
