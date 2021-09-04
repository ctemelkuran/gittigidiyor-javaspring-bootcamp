package dev.patika.patika0401.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WalletAppErrorResponse {
    private int status;
    private String message;
    private long timestamp;

}
