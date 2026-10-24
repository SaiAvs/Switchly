
package live.switchly.api.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateProjectRequest(
        @NotBlank(message = "Name must not be blank")
        String name
) {}
