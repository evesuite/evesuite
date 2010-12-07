package eu.evesuite.client;

import org.eclipse.core.runtime.IExtension;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.internal.WorkbenchPlugin;
import org.eclipse.ui.internal.registry.ActionSetRegistry;
import org.eclipse.ui.internal.registry.IActionSetDescriptor;

@SuppressWarnings("restriction")
public class ApplicationActionBarAdvisor extends ActionBarAdvisor {

    public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
        super(configurer);
        
        ActionSetRegistry reg = WorkbenchPlugin.getDefault().getActionSetRegistry();
        IActionSetDescriptor[] actionSets = reg.getActionSets();
        
        String actionSetId = "org.eclipse.ui.edit.text.actionSet.annotationNavigation"; //$NON-NLS-1$
        for (int i = 0; i <actionSets.length; i++)
        {
                
            if (!actionSets[i].getId().equals(actionSetId))
                continue;
            IExtension ext = actionSets[i].getConfigurationElement()
                .getDeclaringExtension();
            reg.removeExtension(ext, new Object[] { actionSets[i] });
        }
        
        actionSetId = "org.eclipse.ui.edit.text.actionSet.navigation"; //$NON-NLS-1$
        for (int i = 0; i <actionSets.length; i++)
        {
                
            if (!actionSets[i].getId().equals(actionSetId))
                continue;
            IExtension ext = actionSets[i].getConfigurationElement()
                .getDeclaringExtension();
            reg.removeExtension(ext, new Object[] { actionSets[i] });
        }
        
        actionSetId = "org.eclipse.ui.edit.text.actionSet.convertLineDelimitersTo"; //$NON-NLS-1$
        for (int i = 0; i <actionSets.length; i++)
        {
            if (!actionSets[i].getId().equals(actionSetId))
                continue;
            IExtension ext = actionSets[i].getConfigurationElement()
                    .getDeclaringExtension();
           reg.removeExtension(ext, new Object[] { actionSets[i] });
        }
        
        actionSetId = "org.eclipse.ui.actionSet.openFiles"; //$NON-NLS-1$
        for (int i = 0; i <actionSets.length; i++)
        {
            if (!actionSets[i].getId().equals(actionSetId))
                continue;
            IExtension ext = actionSets[i].getConfigurationElement()
                    .getDeclaringExtension();
           reg.removeExtension(ext, new Object[] { actionSets[i] });
        }    
        actionSetId = "org.eclipse.ui.actionSet.keyBindings"; //$NON-NLS-1$
        for (int i = 0; i <actionSets.length; i++)
        {
            if (!actionSets[i].getId().equals(actionSetId))
                continue;
            IExtension ext = actionSets[i].getConfigurationElement()
                    .getDeclaringExtension();
           reg.removeExtension(ext, new Object[] { actionSets[i] });
        }    

    }

    protected void makeActions(IWorkbenchWindow window) {
    	 register(ActionFactory.SAVE.create(window));
    }

    protected void fillMenuBar(IMenuManager menuBar) {
    }
    
}
