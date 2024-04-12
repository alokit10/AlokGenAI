package com.feedbackanalysis.genai.service;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenAIService 
{
	@Value("${openai.api.key}")
	private String apiKey;
	
	private final String openaiUrl = "https://api.openai.com/v1/completions";
	
	public String analyzeFeedback(String feedback) 
	{
	 String requestBody = "{\"model\":\"text-davinci-003\",\"prompt\":\"" + feedback + "\",\"max_tokens\":50}";

     HttpHeaders headers = new HttpHeaders();
     headers.setContentType(MediaType.APPLICATION_JSON);
     headers.set("Authorization", "Bearer " + apiKey);

     HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);
     RestTemplate restTemplate = new RestTemplate();
     ResponseEntity<String> responseEntity = restTemplate.exchange(openaiUrl, HttpMethod.POST, requestEntity, String.class);

     return responseEntity.getBody();
	} 
}
