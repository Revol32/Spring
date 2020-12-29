package com.epam.edu.spring.core.template.validator;

import com.epam.edu.spring.core.template.entity.Color;
import com.epam.edu.spring.core.template.entity.Item;

import java.util.Arrays;
import java.util.regex.Matcher;

import static java.util.regex.Pattern.compile;

public class SimpleItemValidator implements ItemValidator {

    @Override
    public boolean isItemValid(Item item) {
        Matcher matcher = compile ("([^a-zA-Z0-9])").matcher(item.getName());
        return !matcher.find() || Arrays.asList(Color.values()).contains(item.getColor());
    }
}
