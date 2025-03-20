package com.stupidsquad.webapp.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LootResponseDTO {
    private String status;
    private String message;
    private Object data;
}
