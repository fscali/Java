package effectivejava.chapter2.staticfactory.serviceprovider.interfaces.provider;

import effectivejava.chapter2.staticfactory.serviceprovider.interfaces.Service.IService;

public interface IProvider {
	IService newService();

}
