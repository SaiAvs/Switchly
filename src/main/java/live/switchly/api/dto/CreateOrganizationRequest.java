
package live.switchly.api.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateOrganizationRequest(
        @NotBlank(message = "Name must not be blank")
        String name
) {}
