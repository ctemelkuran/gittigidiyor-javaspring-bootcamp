package dev.patika.patika0401.util;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Data
@NoArgsConstructor
@Component // Spring tarafından yönetilmesini sağlar, Application kontext kapsamında container tarafından bindlanır
@SessionScope // Sessiondaki güncel halleriyle erişiriz
public class ClientRequestInfo {
    // Headerda önemli bilgiler bulunur
    // Kullanıcı hangi url ve IP'den geliyor gibi
    private String clientIpAddress;
    private String clientUrl;
    private String sessionActivityId;
}