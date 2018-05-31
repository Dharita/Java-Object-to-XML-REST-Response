/**
 * 
 */
package com.stackoverflow.demo.service;

import org.springframework.stereotype.Service;

import com.stackoverflow.demo.bean.VisaResponse;

/**
 * @author dharita.chokshi
 *
 */

@Service
public class ApiService {

	public VisaResponse visaResponse() {
		// replace this by repository method call
		return new VisaResponse();
	}

}
