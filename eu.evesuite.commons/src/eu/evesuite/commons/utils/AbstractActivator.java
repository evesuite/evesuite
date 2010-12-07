package eu.evesuite.commons.utils;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

abstract public class AbstractActivator implements BundleActivator {

	protected BundleContext bundleContext;
	
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {		
		
		System.out.println(bundleContext.getBundle().getSymbolicName() + " start");
		
		this.bundleContext = bundleContext;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		
		this.bundleContext = null;
		
		System.out.println(bundleContext.getBundle().getSymbolicName() + " stop");
	}
}
