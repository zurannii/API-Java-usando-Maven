package br.com.dio.service.query;

import br.com.dio.entidades.ClientEntity;

public interface IClientQueryService {
    ClientEntity findById(final long id);

    List<ClientEntity> list();

    void verifyPhone(final String phone);

    void verifyPhone(final long id, final String phone);

    void verifyEmail(final String email);

    void verifyEmail(final String id, final String email);
}
