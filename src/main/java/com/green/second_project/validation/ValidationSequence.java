package com.green.second_project.validation;

import jakarta.validation.GroupSequence;
import jakarta.validation.groups.Default;

@GroupSequence({Default.class ,ValidationGroup.NotBlankGroup.class, ValidationGroup.PatternCheckGroup.class})
public interface ValidationSequence {
}
