package com.devshowcase.api.service;

import com.devshowcase.api.domain.Feedback;
import com.devshowcase.api.domain.Project;
import com.devshowcase.api.dto.request.FeedbackRequest;
import com.devshowcase.api.repository.FeedbackRepository;
import com.devshowcase.api.repository.ProjectRepository;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;
    private final ProjectRepository projectRepository;

    public FeedbackService(
            FeedbackRepository feedbackRepository,
            ProjectRepository projectRepository) {

        this.feedbackRepository = feedbackRepository;
        this.projectRepository = projectRepository;
    }

    public Feedback create(Long projectId, FeedbackRequest request) {

        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));

        Feedback feedback = new Feedback();

        feedback.setAuthorName(request.authorName());
        feedback.setAuthorEmail(request.authorEmail());
        feedback.setComment(request.comment());
        feedback.setRating(request.rating());
        feedback.setProject(project);

        return feedbackRepository.save(feedback);
    }
}