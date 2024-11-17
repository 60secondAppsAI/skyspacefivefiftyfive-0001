package com.skyspacefivefiftyfive.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.skyspacefivefiftyfive.domain.Terminal;
import com.skyspacefivefiftyfive.dto.TerminalDTO;
import com.skyspacefivefiftyfive.dto.TerminalSearchDTO;
import com.skyspacefivefiftyfive.dto.TerminalPageDTO;
import com.skyspacefivefiftyfive.dto.TerminalConvertCriteriaDTO;
import com.skyspacefivefiftyfive.service.GenericService;
import com.skyspacefivefiftyfive.dto.common.RequestDTO;
import com.skyspacefivefiftyfive.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface TerminalService extends GenericService<Terminal, Integer> {

	List<Terminal> findAll();

	ResultDTO addTerminal(TerminalDTO terminalDTO, RequestDTO requestDTO);

	ResultDTO updateTerminal(TerminalDTO terminalDTO, RequestDTO requestDTO);

    Page<Terminal> getAllTerminals(Pageable pageable);

    Page<Terminal> getAllTerminals(Specification<Terminal> spec, Pageable pageable);

	ResponseEntity<TerminalPageDTO> getTerminals(TerminalSearchDTO terminalSearchDTO);
	
	List<TerminalDTO> convertTerminalsToTerminalDTOs(List<Terminal> terminals, TerminalConvertCriteriaDTO convertCriteria);

	TerminalDTO getTerminalDTOById(Integer terminalId);







}





