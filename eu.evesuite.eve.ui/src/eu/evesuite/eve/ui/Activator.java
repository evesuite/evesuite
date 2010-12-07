package eu.evesuite.eve.ui;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

import eu.evesuite.commons.jpa.EVEMetricsModelService;
import eu.evesuite.commons.jpa.EVEModelService;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin implements PropertyChangeListener {

	// The plug-in ID
	public static final String PLUGIN_ID = "eu.evesuite.eve.ui"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;

	private ServiceTracker serviceTracker = null;
	
	private ServiceTracker eveMetricsServiceTracker = null;
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext context) throws Exception {

		System.out.println(context.getBundle().getSymbolicName() + " start");

		super.start(context);

		plugin = this;

		initServices(context);		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
	 */
	public void stop(BundleContext context) throws Exception {
		
		if (serviceTracker instanceof ServiceTracker) {
			serviceTracker.close();
			serviceTracker = null;
		}

		if (eveMetricsServiceTracker instanceof ServiceTracker) {
			eveMetricsServiceTracker.close();
			eveMetricsServiceTracker = null;
		}

		plugin = null;
		
		super.stop(context);

		System.out.println(context.getBundle().getSymbolicName() + " stop");
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	public EVEModelService getModelService() {
		
		if (serviceTracker instanceof ServiceTracker) {
			return (EVEModelService)serviceTracker.getService();
		}
		
		return null;
	}

	public EVEMetricsModelService getMetricsModelService() {
		
		if (eveMetricsServiceTracker instanceof ServiceTracker) {
			return (EVEMetricsModelService)eveMetricsServiceTracker.getService();
		}
		
		return null;
	}


	/**
	 * Returns an image descriptor for the image file at the given plug-in
	 * relative path
	 * 
	 * @param path
	 *            the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}

	private void initServices(BundleContext bundleContext) {

		serviceTracker = new ServiceTracker(bundleContext,
				EVEModelService.class.getName(), null);
		
		serviceTracker.open();

		ServiceListener serviceListener = new ServiceListener() {

			public void serviceChanged(ServiceEvent ev) {

				ServiceReference serviceReference = ev.getServiceReference();

				switch (ev.getType()) {
				case ServiceEvent.REGISTERED:
					registerEVEModelService(serviceReference);
					break;
				case ServiceEvent.UNREGISTERING:
					unregisterEVEModelService(serviceReference);
					break;
				}
			}
		};

		String filter = "(objectclass=" + EVEModelService.class.getName()
				+ ")";
		try {
			bundleContext.addServiceListener(serviceListener, filter);
			ServiceReference[] serviceReferences = bundleContext
					.getServiceReferences(null, filter);
			for (int i = 0; serviceReferences != null
					&& i < serviceReferences.length; i++) {
				serviceListener.serviceChanged(new ServiceEvent(
						ServiceEvent.REGISTERED, serviceReferences[i]));
			}
		} catch (InvalidSyntaxException e) {
			e.printStackTrace();
		}
		
		eveMetricsServiceTracker = new ServiceTracker(bundleContext,
				EVEMetricsModelService.class.getName(), null);
		
		eveMetricsServiceTracker.open();

		serviceListener = new ServiceListener() {

			public void serviceChanged(ServiceEvent ev) {

				ServiceReference serviceReference = ev.getServiceReference();

				switch (ev.getType()) {
				case ServiceEvent.REGISTERED:
					registerEVEMetricsService(serviceReference);
					break;
				case ServiceEvent.UNREGISTERING:
					unregisterEVEMetricsService(serviceReference);
					break;
				}
			}
		};

		filter = "(objectclass=" + EVEMetricsModelService.class.getName()
				+ ")";
		try {
			bundleContext.addServiceListener(serviceListener, filter);
			ServiceReference[] serviceReferences = bundleContext
					.getServiceReferences(null, filter);
			for (int i = 0; serviceReferences != null
					&& i < serviceReferences.length; i++) {
				serviceListener.serviceChanged(new ServiceEvent(
						ServiceEvent.REGISTERED, serviceReferences[i]));
			}
		} catch (InvalidSyntaxException e) {
			e.printStackTrace();
		}		
		
	}
	
	private void registerEVEModelService(ServiceReference serviceReference) {

		Object[] services = serviceTracker.getServices();

		for (int i = 0; services != null && i < services.length; i++) {
			EVEModelService service = (EVEModelService) services[i];
			try {
				service.addPropertyChangeListener(this);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private void unregisterEVEMetricsService(ServiceReference serviceReference) {

		Object[] services = serviceTracker.getServices();

		for (int i = 0; services != null && i < services.length; i++) {
			EVEMetricsModelService service = (EVEMetricsModelService) services[i];
			try {
				service.removePropertyChangeListener(this);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}	

	private void registerEVEMetricsService(ServiceReference serviceReference) {

		Object[] services = eveMetricsServiceTracker.getServices();

		for (int i = 0; services != null && i < services.length; i++) {
			EVEMetricsModelService service = (EVEMetricsModelService) services[i];
			try {
				service.addPropertyChangeListener(this);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private void unregisterEVEModelService(ServiceReference serviceReference) {

		Object[] services = eveMetricsServiceTracker.getServices();

		for (int i = 0; services != null && i < services.length; i++) {
			EVEModelService service = (EVEModelService) services[i];
			try {
				service.removePropertyChangeListener(this);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}	
	@Override
	public void propertyChange(PropertyChangeEvent event) {

	}

}
