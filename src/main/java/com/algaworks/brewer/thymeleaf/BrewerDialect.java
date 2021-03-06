package com.algaworks.brewer.thymeleaf;

import com.algaworks.brewer.thymeleaf.processor.ClassForErrorAttributeTagProcessor;
import org.springframework.stereotype.Component;
import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;

import java.util.HashSet;
import java.util.Set;

@Component
public class BrewerDialect extends AbstractProcessorDialect {
    public BrewerDialect() {
        super("Algoworks Brewer", "brewer", StandardDialect.PROCESSOR_PRECEDENCE);
    }

    @Override
    public Set<IProcessor> getProcessors(String s) {
        final Set<IProcessor> processors = new HashSet<>();
        processors.add(new ClassForErrorAttributeTagProcessor(s));

        return processors;
    }
}
