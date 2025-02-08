package com.mohamed.book_network.feedback;

import com.mohamed.book_network.book.Book;
import com.mohamed.book_network.book.BookRepository;
import com.mohamed.book_network.exception.OperationNotPermittedException;
import com.mohamed.book_network.user.User;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.io.Serial;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class FeedbackService {
    private final BookRepository bookRepository;
    private final FeedbackMapper feedbackMapper;
    private final FeedbackRepository feedbackRepository;


    public Integer save(FeedbackRequest request, Authentication connectedUser) {
        Book book = bookRepository.findById(request.bookId()).orElseThrow(() -> new EntityNotFoundException("No book found with id: " + request.bookId()));
        if (!book.isShareable() && book.isArchived()) {
            throw new OperationNotPermittedException("you cannot give feedback for an archived or not shareable book");
        }

        User user = ((User) connectedUser.getPrincipal());
        if (Objects.equals(book.getOwner().getId(), user.getId())) {
            throw new OperationNotPermittedException("you cannot give feedback for your own book");
        }

        Feedback feedback = feedbackMapper.toFeedback(request);
        return feedbackRepository.save(feedback).getId();
    }
}
