package com.bondarenko.int20h2020.domain.output;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Form {
    private int id;
    private BriefDescription briefDescription;
    private FullDescription fullDescription;
}
