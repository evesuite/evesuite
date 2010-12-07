package eu.evesuite.commons.utils;

public class DefaultDeferredAdapter extends AbstractDeferredAdapter {
	
	 @Override
     public Object[] getChildren(Object o) {

             IModelContentProvider provider = (IModelContentProvider) o;

             return provider.getElements();
     }

     @Override
     public String getLabel(Object o) {

             IModelContentProvider provider = (IModelContentProvider) o;

             return provider.getName();
     }


}
