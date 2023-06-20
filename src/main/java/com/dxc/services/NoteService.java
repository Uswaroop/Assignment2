package com.dxc.services;

import java.util.List;

import com.dxc.exception.NoteExistExcep;
import com.dxc.model.Note;

public interface NoteService {

	Note newNote(Note note) throws NoteExistExcep;

	Note updateNote(Note note);

	void deleteNoteById(int noteid);

	List<Note> getAllNotesByUser(String userid);

}
