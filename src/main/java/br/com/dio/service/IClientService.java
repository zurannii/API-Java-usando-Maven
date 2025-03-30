package br.com.dio.service;

import br.com.dio.entidades.ClientEntity;

public interface IClientService {

    ClientEntity save(final ClientEntity client);

    ClientEntity update(final ClientEntity client);

    void delete(final long id);


}
