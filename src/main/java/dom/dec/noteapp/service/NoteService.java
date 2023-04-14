package dom.dec.noteapp.service;

import dom.dec.noteapp.domain.Note;
import dom.dec.noteapp.dto.NoteDto;

import java.util.List;

public interface NoteService {

    List<Note> findAll();

    Note saveNote(String title, String content);

    Note updateNote(NoteDto newNote, long id);

    void deleteNote(Long id);
}
