package tn.bal.pi.services;

import tn.bal.pi.entities.Option;

import java.util.List;

public interface IOptionService {
    List<Option> getAllOptions();
    Option getOptionById(Long id);
    Option addOption(Option o);
    Option updateOption(Option o);
    void deleteOptionById(Long id);
}
