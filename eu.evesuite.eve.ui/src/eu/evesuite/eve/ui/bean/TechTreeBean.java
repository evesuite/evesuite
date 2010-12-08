package eu.evesuite.eve.ui.bean;

import org.eclipse.draw2d.IFigure;
import org.eclipse.swt.graphics.Color;
import org.eclipse.zest.core.viewers.IEntityStyleProvider;

import eu.evesuite.eve.bean.TechTreeNode;

public class TechTreeBean implements IEntityStyleProvider {

	protected TechTreeNode entity;

	public TechTreeNode getEntity() {
		return entity;
	}

	public void setEntity(TechTreeNode entity) {
		this.entity = entity;
	}

	@Override
	public void dispose() {
		
	}

	@Override
	public Color getNodeHighlightColor(Object entity) {
		return null;
	}

	@Override
	public Color getBorderColor(Object entity) {
		return null;
	}

	@Override
	public Color getBorderHighlightColor(Object entity) {
		return null;
	}

	@Override
	public int getBorderWidth(Object entity) {
		return 0;
	}

	@Override
	public Color getBackgroundColour(Object entity) {
		return null;
	}

	@Override
	public Color getForegroundColour(Object entity) {
		return null;
	}

	@Override
	public IFigure getTooltip(Object entity) {
		return null;
	}

	@Override
	public boolean fisheyeNode(Object entity) {
		return false;
	}
	
	
}
