package com.example.samgau_test.models;

import com.example.samgau_test.entity.Book;
import com.example.samgau_test.entity.Student;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class MStudent {
    private Long id;
    private String username;
    private String group;
    private List<MBook> bookList;

    public static MStudent toModel(Student entity) {
        MStudent model = new MStudent();
        model.setId(entity.getId());
        model.setUsername(entity.getUsername());
        model.setGroup(entity.getGroup());
        model.setBookList(entity.getBooks().stream().map(MBook::toModel).collect(Collectors.toList()));
        return model;
    }
}
