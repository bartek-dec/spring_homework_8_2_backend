package dom.dec.noteapp.api;

import dom.dec.noteapp.domain.Note;
import dom.dec.noteapp.dto.NoteDto;
import dom.dec.noteapp.service.NoteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
@CrossOrigin
public class NoteApi {
    private NoteService service;

    @Autowired
    public NoteApi(NoteService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Note>> getAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Note> createNote(@Valid @RequestBody NoteDto noteDto) {
        Note note = service.saveNote(noteDto.getTitle(), noteDto.getContent());
        return new ResponseEntity<>(note, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@Valid @RequestBody NoteDto noteDto, @PathVariable(name = "id") long id) {
        Note note = service.updateNote(noteDto, id);
        return new ResponseEntity<>(note, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeNote(@PathVariable(name = "id") long id) {

        service.deleteNote(id);
        return new ResponseEntity<>("Note deleted successfully", HttpStatus.OK);
    }
}
