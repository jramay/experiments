package org.jaffar.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameValidator implements ConstraintValidator<NameConstraint, String>{

    private NameConstraint nameConstraint;
    
    @Override
    public void initialize(NameConstraint nameConstraint) {
	this.nameConstraint = nameConstraint;
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext validatorContext) {
	if( nameConstraint.caseSensitive() )
            return name.equals(nameConstraint.nameAllowed());
        else
            return name.equalsIgnoreCase(nameConstraint.nameAllowed());
    }

}
