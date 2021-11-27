package service;

import model.Departamento;
import repository.DepartamentoRepository;

public class DepartamentoService extends BaseService<Departamento, Long, DepartamentoRepository> {
    public DepartamentoService(DepartamentoRepository repository) {
        super(repository);
    }
}
