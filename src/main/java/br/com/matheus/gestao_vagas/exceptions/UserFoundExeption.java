package br.com.matheus.gestao_vagas.exceptions;

public class UserFoundExeption extends RuntimeException {
  public UserFoundExeption() {
    super("User already exists!");
  }
}
