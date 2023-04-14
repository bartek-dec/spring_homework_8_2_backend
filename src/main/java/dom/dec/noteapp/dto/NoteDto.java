package dom.dec.noteapp.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class NoteDto {
    @NotEmpty(message = "Title cannot be null")
    @Size(min = 1, message = "Title cannot be less than 1 character")
    @Size(max = 1000, message = "Title cannot be longer than 1000 characters")
    private String title;

    @NotEmpty(message = "Content cannot be null")
    @Size(min = 1, message = "Content cannot be less than 1 character")
    @Size(max = 20000, message = "Content cannot be longer than 20000 characters")
    private String content;

    public NoteDto(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public NoteDto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
