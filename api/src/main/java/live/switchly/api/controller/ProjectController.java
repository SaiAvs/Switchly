
package live.switchly.api.controller;

import live.switchly.api.dto.CreateProjectRequest;
import live.switchly.api.model.Project;
import live.switchly.api.service.ProjectService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ProjectController {

    private final ProjectService service;

    public ProjectController(ProjectService service) {
        this.service = service;
    }

    @PostMapping("/api/v1/orgs/{orgId}/projects")
    @ResponseStatus(HttpStatus.CREATED)
    public Project create(
            @PathVariable UUID orgId,
            @Valid @RequestBody CreateProjectRequest request) {
        return service.create(orgId, request.name());
    }

    @GetMapping("/api/v1/orgs/{orgId}/projects")
    public List<Project> findAllByOrganization(
            @PathVariable UUID orgId) {
        return service.findAllByOrganizationId(orgId);
    }

    @GetMapping("/api/v1/projects/{projectId}")
    public Project findById(@PathVariable UUID projectId) {
        return service.findById(projectId);
    }
}
