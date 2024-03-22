package tn.bal.pi.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.bal.pi.entities.Option;
import tn.bal.pi.repositories.OptionRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class OptionServiceImpl implements IOptionService{
    OptionRepository optionRepository;
    @Override
    public List<Option> getAllOptions() {
        return optionRepository.findAll();
    }

    @Override
    public Option getOptionById(Long id) {
        return optionRepository.findById(id).get();
    }

    @Override
    public Option addOption(Option o) {
        return optionRepository.save(o);
    }

    @Override
    public Option updateOption(Option o) {
        return optionRepository.save(o);
    }

    @Override
    public void deleteOptionById(Long id) {
        optionRepository.deleteById(id);
    }
}
