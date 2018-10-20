package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	@Autowired
	@Qualifier(value="testeWr")
	MeuBeanRegistration meuBeanRegistration;

	//
	// @Autowired
	// private Environment env;
	//
	// private static final String template = "Hello, %s!";
	// private final AtomicLong counter = new AtomicLong();
	//
	// // @Value("${parametro.qtddiashistorico}")
	// private String qtdDiasHistorico;
	//
//	@RequestMapping("/insere")
//	public Object greeting(@RequestParam(value = "nome", required=true) String nome, 
//			@RequestParam(value = "regra", required=false) String regra,
//			@RequestParam(value = "data", required=false) String data) {
//		System.out.println("nome: " + nome);
//		meuBeanRegistration.createNewWebservice(nome);
//		meuBeanRegistration.readFile("nomeendpoint2=exercicio1/" + nome);
//		return "succesfull";
//	}
//	

	
	//
	// @RequestMapping("/greeting2")
	// @RefreshScope
	// public Object greeting2(@RequestParam(value = "name", defaultValue =
	// "World") String name) {
	// Object exemploJavaBean = createDynamicProduct();
	// return exemploJavaBean;
	// }
	//
	// private Object createDynamicProduct() {
	// Object exemploJavaBean = null;
	// IEntityType tipoProduto = new GenericEntityType("Produto2");
	//
	// // criando property types
	// GenericPropertyType dataNascPropertyType = new
	// GenericPropertyType("dataFabricacao", Date.class);
	// tipoProduto.addOperation("periodoConsumo", new
	// PeriodoConsumo("dataFabricacao"));
	//
	// try {
	// AdapterFactory af = AdapterFactory.getInstance("AnnotationMapping.json");
	//
	// dataNascPropertyType.setProperty("notempty", true);
	//
	// GenericPropertyType nomePropertyType = new GenericPropertyType("nome",
	// String.class);
	// nomePropertyType.setProperty("notempty", true);
	//
	// GenericPropertyType perecivel = new GenericPropertyType("perecivel",
	// Boolean.class);
	// perecivel.setProperty("notempty", true);
	//
	// GenericPropertyType validade = new GenericPropertyType("validade",
	// Integer.class);
	// validade.setProperty("range.min", 1);
	// validade.setProperty("range.min", 730);
	//
	// GenericPropertyType valido = new GenericPropertyType("valido",
	// Boolean.class);
	//
	// // adicionando property types no tipo de entidade
	// tipoProduto.addPropertyType(dataNascPropertyType);
	// tipoProduto.addPropertyType(nomePropertyType);
	// tipoProduto.addPropertyType(perecivel);
	// tipoProduto.addPropertyType(validade);
	// tipoProduto.addPropertyType(valido);
	//
	// IEntity produto = tipoProduto.createNewEntity();
	// produto.setProperty("nome", "Yogurt X");
	// GregorianCalendar dataFabr = new GregorianCalendar();
	// dataFabr.set(2017, 2, 23);
	// produto.setProperty("dataFabricacao", dataFabr.getTime());
	// produto.setProperty("perecivel", Boolean.TRUE);
	// produto.setProperty("validade", 90);
	//
	// Object resultOperation = produto.executeOperation("periodoConsumo");
	// Long days = (Long) resultOperation;
	// System.out.println("validade por: " + days + " dias");
	// produto.setProperty("valido", days < 730);
	// exemploJavaBean = af.generate(produto);
	//
	// } catch (EsfingeAOMException e) {
	// e.printStackTrace();
	// } catch (AdapterFactoryFileReaderException |
	// AdapterFactoryClassConstructionException e) {
	// e.printStackTrace();
	// }
	// return exemploJavaBean;
	// }
	//
	// private Object createDynamicProduct(Map<String, Object> props) {
	// Object exemploJavaBean = null;
	//
	// try {
	// AdapterFactory af = AdapterFactory.getInstance("AnnotationMapping.json");
	// // int valor = (int) (Math.random() * 10000);
	// String objectName = "Produto4";
	// IEntityType tipoProduto = new GenericEntityType(objectName);
	//
	// IEntity produto = createPropertyAndSetValues(props, tipoProduto);
	//
	// Object resultOperation = produto.executeOperation("ruleName");
	//
	// System.out.println("validade por: " + resultOperation);
	// produto.setProperty("valido", String.valueOf(resultOperation));
	// exemploJavaBean = af.generate(produto);
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return exemploJavaBean;
	// }
	//
	// @SuppressWarnings({ "rawtypes", "unchecked" })
	// private IEntity createPropertyAndSetValues(Map<String, Object> props,
	// IEntityType tipoProduto) throws Exception {
	// Set<String> keySet = props.keySet();
	// for (String key : keySet) {
	// GenericPropertyType propertyType = new GenericPropertyType(key,
	// String.class);
	// tipoProduto.addPropertyType(propertyType);
	// if (key.contains("@")) {
	// String partes[] = key.split("@");
	// System.out.println(" chave: " + partes[0] + " regra: " + partes[1]);
	// String ruleObject = "org.esfinge.aom.model.impl." + partes[1];
	// // Object instance = Class.forName(ruleObject).newInstance();
	//
	// Class[] type = { String.class };
	// Class classDefinition = Class.forName(ruleObject);
	// Constructor cons = classDefinition.getConstructor(type);
	// Object[] obj = new Object[1];// { "JLabel"};
	// obj[0] = key;
	// Object ruleObjectInstance = cons.newInstance(obj);
	// // tipoProduto.addOperation(partes[0], new PeriodoConsumo(key));
	// tipoProduto.addOperation("ruleName", (RuleObject) ruleObjectInstance);
	// }
	// }
	// IEntity produto = tipoProduto.createNewEntity();
	// for (String key : keySet) {
	// Object value = props.get(key);
	// produto.setProperty(key, value);
	// }
	// return produto;
	// }
	//
	// @RequestMapping(value = "/results/**")
	// public Object handleResults(HttpServletRequest request) {
	// String path = request.getRequestURI();
	// String command = getLastPath(path);
	// String property = env.getProperty("exercicio1.produto.nome");
	// Map<String, Object> allProperties = getAllKnownProperties(command);
	// // Map<String, Object> allProperties =
	// // getAllKnownProperties("exercicio1");
	// Object exercicio1 = createDynamicProduct(allProperties);
	// System.out.println(path + " command: " + command + " segunda prop: " +
	// property);
	//
	// return exercicio1;
	// }
	//
	// private String getLastPath(String path) {
	// String[] split = path.split("/");
	// if (split.length == 3) {
	// return split[2];
	// }
	// return path;
	// }
	// //
	// // @RequestMapping(value = "/{endPoint}", method = RequestMethod.POST)
	// // public Object endPoint(HttpServletRequest request, @PathVariable
	// String
	// // endPoint) {
	// //
	// // String path = request.getRequestURI();
	// // String property = env.getProperty("endPoint");
	// // Map<String, Object> allProperties =
	// getAllKnownProperties("exercicio1");
	// // Object exercicio1 = createDynamicProduct(allProperties);
	// // System.out.println(path + " endPoint dinamico parametro: " +
	// property);
	// // // Object exemploJavaBean = null;
	// // // exemploJavaBean = createDynamicProduct(exemploJavaBean);
	// // return exercicio1;
	// // }
	//
	// // @RequestMapping(value="/{var1}/{var2}", method=RequestMethod.GET)
	// // public Object handleRequest(@PathVariable String var1, @PathVariable
	// // String var2) {
	// // String path = var2;
	// // String command = getLastPath(path);
	// // String property = env.getProperty("exercicio1.produto.nome");
	// // Map<String, Object> allProperties = getAllKnownProperties(command);
	// // Object exercicio1 = createDynamicProduct(allProperties);
	// // System.out.println(path + " command: " + command + " segunda prop: " +
	// // property);
	// //
	// // return exercicio1;
	// // }
	//
	// @SuppressWarnings("rawtypes")
	// public Map<String, Object> getAllKnownProperties(String wildCard) {
	// Map<String, Object> rtn = new HashMap<>();
	// if (env instanceof ConfigurableEnvironment) {
	// for (PropertySource<?> propertySource : ((ConfigurableEnvironment)
	// env).getPropertySources()) {
	// if (propertySource instanceof EnumerablePropertySource) {
	// for (String key : ((EnumerablePropertySource)
	// propertySource).getPropertyNames()) {
	// if (key.contains(wildCard)) {
	// Object value = propertySource.getProperty(key);
	// key = getLastPeriodOfKey(key);
	// System.out.println("key: " + key + " value: " + value);
	// rtn.put(key, value);
	// }
	// }
	// }
	// }
	// }
	// return rtn;
	// }
	//
	// private String getLastPeriodOfKey(String key) {
	// String keyResult = key;
	// int lastIndexOf = key.lastIndexOf(".");
	// if (lastIndexOf > 0) {
	// keyResult = key.substring(lastIndexOf + 1);
	// }
	// return keyResult;
	// }
	//
	// @GetMapping("/restart")
	// @RequestMapping(value = "/restart", method = { RequestMethod.GET,
	// RequestMethod.POST })
	// void restart() {
	// System.out.println("@@@@@@@@@ -- restarting ");
	// Thread restartThread = new Thread(() -> {
	// try {
	// Thread.sleep(10);
	// Application.restart();
	// } catch (InterruptedException ignored) {
	// }
	// });
	// restartThread.setDaemon(false);
	// restartThread.start();
	// }
}
