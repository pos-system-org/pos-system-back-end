package com.pos_system.pos_system.util;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StandardResponse {
    private int status;
    private String message;
    private Object data;
}
