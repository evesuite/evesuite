package eu.evesuite.commons;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

import eu.evesuite.commons.utils.AbstractActivator;

public class Activator extends AbstractActivator {

	public static final String PLUGIN_ID = "eu.evesuite.commons"; 
	
	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		super.start(bundleContext);
		Activator.context = bundleContext;
		
		//TODO !!! There has the be a better way to do this !!!!
        Bundle[] bundles = bundleContext.getBundles();
        
        long id1 = 0;
        long id2 = 0;
        
        for (Bundle bundle : bundles) {
                
                if (bundle.getSymbolicName().equalsIgnoreCase("javax.persistence")) {
                        id1 = bundle.getBundleId();
                }
                if (bundle.getSymbolicName().equalsIgnoreCase("org.eclipse.persistence.jpa")) {
                        id2 = bundle.getBundleId();
                }
        }
        
        if (id1 > 0) {
                bundleContext.getBundle(id1).start();
        }
        
        if (id2 > 0) {
                bundleContext.getBundle(id2).start();
        }

	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;		
		super.stop(bundleContext);
	}

}
