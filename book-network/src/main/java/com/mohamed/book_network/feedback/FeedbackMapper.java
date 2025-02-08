package com.mohamed.book_network.feedback;

import com.mohamed.book_network.book.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service

public class FeedbackMapper {
    public Feedback toFeedback(FeedbackRequest request) {
        return Feedback.builder()
                .note(request.note())
                .comment(request.comment())
                .book(Book.builder().id(request.bookId()).archived(false).shareable(false).build())
                .build();
    }
}
