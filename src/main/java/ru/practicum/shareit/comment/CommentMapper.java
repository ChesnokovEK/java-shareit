package ru.practicum.shareit.comment;

import lombok.experimental.UtilityClass;
import ru.practicum.shareit.comment.dto.CommentDTO;
import ru.practicum.shareit.comment.model.Comment;
import ru.practicum.shareit.item.model.Item;
import ru.practicum.shareit.user.model.User;

import java.util.List;

import static java.util.stream.Collectors.toList;

@UtilityClass
public class CommentMapper {
    public Comment toComment(CommentDTO commentDTO, Item item, User author) {
        return Comment.builder()
                .id(commentDTO.getId())
                .text(commentDTO.getText())
                .item(item)
                .author(author)
                .created(commentDTO.getCreated())
                .build();
    }

    public CommentDTO toCommentDTO(Comment comment) {
        return CommentDTO.builder()
                .id(comment.getId())
                .text(comment.getText())
                .authorName(comment.getAuthor().getName())
                .created(comment.getCreated())
                .itemId(comment.getItem().getId())
                .build();
    }

    public List<CommentDTO> toDTOList(List<Comment> comments) {
        return comments
                .stream()
                .map(CommentMapper::toCommentDTO)
                .collect(toList());
    }
}