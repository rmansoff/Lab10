import javax.validation.constraints.*;
import java.time.LocalDateTime;

public class LessonDTO {
    @NotNull(message = "ID cannot be null")
    private Long id;

    @NotNull(message = "Lesson name cannot be null")
    @Size(min = 3, max = 100, message = "Lesson name must be between 3 and 100 characters")
    private String name;

    @NotNull(message = "Start time cannot be null")
    private LocalDateTime startTime;

    @NotNull(message = "End time cannot be null")
    private LocalDateTime endTime;

    @NotNull(message = "Teacher name cannot be null")
    @Size(min = 3, max = 100, message = "Teacher name must be between 3 and 100 characters")
    private String teacher;

}
