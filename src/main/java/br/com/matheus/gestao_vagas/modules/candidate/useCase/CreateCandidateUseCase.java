package br.com.matheus.gestao_vagas.modules.candidate.useCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.matheus.gestao_vagas.exceptions.UserFoundExeption;
import br.com.matheus.gestao_vagas.modules.candidate.CandidateEntity;
import br.com.matheus.gestao_vagas.modules.candidate.CandidateRepository;

@Service
public class CreateCandidateUseCase {
  @Autowired
  private CandidateRepository candidateRepository;

  public CandidateEntity execute(CandidateEntity candidateEntity) {
    this.candidateRepository
        .findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
        .ifPresent((user) -> {
          throw new UserFoundExeption();
        });
    return this.candidateRepository.save(candidateEntity);
  }
}
