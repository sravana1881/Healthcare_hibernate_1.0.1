package healthcare.service;

import healthcare.model.Office;
import healthcare.repository.OfficeRepositoryImpl;

import java.util.List;

public class OfficeService {
    private final OfficeRepositoryImpl officeRepository;

    public OfficeService(OfficeRepositoryImpl officeRepository) {
        this.officeRepository = officeRepository;
    }
    public void createOffice(Office office) {
        officeRepository.createOffice(office);
    }
    public Office getOfficeById(int id) {
        return officeRepository.getOfficeById(id);
    }
    public List<Office> getAllOffices() {
        return officeRepository.getAllOffices();
    }
    public void updateOffice(Office office) {
        officeRepository.updateOffice(office);
    }
    public void deleteOffice(int officeId) {
        officeRepository.deleteOffice(officeId);
    }
}
