package effectivejava.chapter2.staticfactory.serviceprovider.registration;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import effectivejava.chapter2.staticfactory.serviceprovider.interfaces.Service.IService;
import effectivejava.chapter2.staticfactory.serviceprovider.interfaces.provider.IProvider;

public class Services {

	
	private Services(){};
	
	private static final Map<String,IProvider> providers = new ConcurrentHashMap<>();
	public static final String DEFAULT_PROVIDER_NAME = "<def>";
	
	public static void registerDefaultProvider(IProvider p){
		registerProvider(DEFAULT_PROVIDER_NAME,p);
	}

	private static void registerProvider(String name, IProvider p) {
		// TODO Auto-generated method stub
		providers.put(name,p);
	}
	
	public static IService newInstance(){
		return newInstance(DEFAULT_PROVIDER_NAME);
	}

	public static IService newInstance(String name) {
		IProvider p = providers.get(name);
		if (p==null){
			throw new IllegalArgumentException("No provider registered with name: " + name);
			
		}
		
		return p.newService();
	}

}
