package edu.au.cpsc.gymmanagement.usecase;

import org.junit.jupiter.api.BeforeEach;

public abstract class ManageContractsTest {

  @BeforeEach
  public void setUp() {
    createRepositories();
  }

  protected abstract void createRepositories();

}
