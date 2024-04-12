package com.feedbackanalysis.genai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.feedbackanalysis.genai.dto.FeedbackRequest;
import com.feedbackanalysis.genai.service.OpenAIService;
import com.feedbackanalysis.genai.util.ApiResponse;

@RestController
public class FeedbackController 
{
	@Autowired 
	OpenAIService openAIService;
	
	@PostMapping("/feedback-analysis")
	public ApiResponse analyzeFeedback(@RequestBody FeedbackRequest feedbackRequest)
	{
		String analysisResult = openAIService.analyzeFeedback(feedbackRequest.getText());
        return new ApiResponse(true, "Feedback analysis successful", analysisResult);
		
	}
	
	

}
