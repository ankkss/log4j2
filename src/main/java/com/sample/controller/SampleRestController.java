package com.sample.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.utils.Constants.LogLevels;


@RestController
@RequestMapping("/rest")
public class SampleRestController {
	
	private static Logger LOG = LogManager.getLogger(SampleRestController.class);
	
	@RequestMapping(value="/samplelog4j", method=RequestMethod.GET)
	public ResponseEntity<Object> sampleLogs(
			@RequestParam(value = "level", required = false, defaultValue = "info") String level) {
	
		level = level.toLowerCase();
		HttpStatus status = HttpStatus.OK;
		String response = "Successfully printed logs for level -"+level;
		
		switch(level) {
		case LogLevels.INFO: 
			LOG.info(response);
			break;
		case LogLevels.WARN: 
			LOG.warn(response);
			break;
		case LogLevels.DEBUG: 
			LOG.debug(response);
			break;
		case LogLevels.ERROR: 
			LOG.error(response);
			break;
		default:
			response = "Unknown log level -"+level;
			LOG.error(response);
			status = HttpStatus.BAD_REQUEST;
		}
		return new ResponseEntity<>(response, status);
	}
}
