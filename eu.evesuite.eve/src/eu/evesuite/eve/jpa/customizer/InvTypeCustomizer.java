package eu.evesuite.eve.jpa.customizer;

import org.eclipse.persistence.config.DescriptorCustomizer;
import org.eclipse.persistence.descriptors.ClassDescriptor;
import org.eclipse.persistence.expressions.Expression;
import org.eclipse.persistence.expressions.ExpressionBuilder;
import org.eclipse.persistence.mappings.OneToOneMapping;

public class InvTypeCustomizer implements DescriptorCustomizer {

	@Override
	public void customize(ClassDescriptor descriptor) throws Exception {

		OneToOneMapping mapping = (OneToOneMapping)descriptor.getMappingForAttributeName("planetSchematicsTypeMap");
		
		ExpressionBuilder expressionBuilder = new ExpressionBuilder(mapping.getReferenceClass());
		
		Expression fkExp = expressionBuilder.getField("typeID").equal(expressionBuilder.getParameter("typeID"));
		Expression input = expressionBuilder.get("isInput").equal(0);
		
		mapping.setSelectionCriteria(fkExp.and(input));
		
		mapping = (OneToOneMapping)descriptor.getMappingForAttributeName("invTypeReaction");
		
		expressionBuilder = new ExpressionBuilder(mapping.getReferenceClass());
		
		fkExp = expressionBuilder.getField("typeID").equal(expressionBuilder.getParameter("typeID"));
		input = expressionBuilder.get("input").equal(0);
		
		mapping.setSelectionCriteria(fkExp.and(input));
	}

}
