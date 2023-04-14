package dom.dec.noteapp.service;

import dom.dec.noteapp.domain.Note;
import dom.dec.noteapp.domain.NoteRepo;
import dom.dec.noteapp.dto.NoteDto;
import dom.dec.noteapp.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    private NoteRepo noteRepo;

    @Autowired
    public NoteServiceImpl(NoteRepo noteRepo) {
        this.noteRepo = noteRepo;
    }

    public List<Note> findAll() {
        return noteRepo.findAll();
    }

    public Note saveNote(String title, String content) {
        return noteRepo.save(new Note(title, content));
    }

    public Note updateNote(NoteDto newNote, long id) {
        Note note = noteRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Note", "id", id));
        note.setTitle(newNote.getTitle());
        note.setContent(newNote.getContent());

        return noteRepo.save(note);
    }

    public void deleteNote(Long id) {
        Note note = noteRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Note", "id", id));
        noteRepo.delete(note);
    }
}
