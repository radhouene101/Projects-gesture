package tn.bal.pi.services;

import tn.bal.pi.dto.ContestDto;

public interface IContestService extends AbstractService<ContestDto>{
    ContestDto customSaveContest(Long optionId ,ContestDto contestDto);
    ContestDto assignProjectToContest(Long contestDtoId , Long projectId);
}
