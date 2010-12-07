package eu.evesuite.eve.jpa.customizer;

import org.eclipse.persistence.config.DescriptorCustomizer;
import org.eclipse.persistence.descriptors.ClassDescriptor;
import org.eclipse.persistence.expressions.Expression;
import org.eclipse.persistence.expressions.ExpressionBuilder;
import org.eclipse.persistence.mappings.OneToManyMapping;

public class InvTypeReactionCustomizer implements DescriptorCustomizer {

	@Override
	public void customize(ClassDescriptor descriptor) throws Exception {

		OneToManyMapping mapping = (OneToManyMapping)descriptor.getMappingForAttributeName("invTypeReactions");
		
		ExpressionBuilder expressionBuilder = new ExpressionBuilder(mapping.getReferenceClass());
		
		Expression fkExp = expressionBuilder.getField("reactionTypeID").equal(expressionBuilder.getParameter("reactionTypeID"));
		Expression input = expressionBuilder.get("input").equal(1);
		
		mapping.setSelectionCriteria(fkExp.and(input));		
	}

}
