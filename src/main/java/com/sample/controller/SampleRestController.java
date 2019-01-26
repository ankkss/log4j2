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
		switch(level) {
		case LogLevels.INFO: 
			LOG.info("Successfully printed logs for level -" + level);
			break;
		case LogLevels.WARN: 
			LOG.warn("Successfully printed logs for level -" + level);
			break;
		case LogLevels.DEBUG: 
			LOG.debug("Successfully printed logs for level -" + level);
			break;
		case LogLevels.ERROR: 
			LOG.error("Successfully printed logs for level -" + level);
			break;
		}
		return new ResponseEntity<>("Successfully printed logs for level -" + level, HttpStatus.OK);
	}
}
