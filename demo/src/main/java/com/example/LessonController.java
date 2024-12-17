import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/lessons")
public class LessonController {

    @Autowired
    private LessonRepository lessonRepository;

    @PostMapping
    public ResponseEntity<?> createLesson(@Valid @RequestBody LessonDTO lessonDTO, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        // Перетворення DTO в сутність
        Lesson lesson = new Lesson();
        lesson.setName(lessonDTO.getName());
        lesson.setStartTime(lessonDTO.getStartTime());
        lesson.setEndTime(lessonDTO.getEndTime());
        lesson.setTeacher(lessonDTO.getTeacher());

        lessonRepository.save(lesson);

        return new ResponseEntity<>(lessonDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateLesson(@PathVariable Long id, @Valid @RequestBody LessonDTO lessonDTO, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        // Логіка для оновлення Lesson
        Lesson lesson = lessonRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Lesson not found"));
        lesson.setName(lessonDTO.getName());
        lesson.setStartTime(lessonDTO.getStartTime());
        lesson.setEndTime(lessonDTO.getEndTime());
        lesson.setTeacher(lessonDTO.getTeacher());

        lessonRepository.save(lesson);

        return new ResponseEntity<>(lessonDTO, HttpStatus.OK);
    }
}
